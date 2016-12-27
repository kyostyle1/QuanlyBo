package vn.edu.uit.quanlybo.Network;

import android.app.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessNfcRequest;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessRequest;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessResponse;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ToDoService extends BaseService {

    private static ToDoService toDoService = null;
    private QuanLyBoAPI quanLyBoAPI = getQuanLyBoAPI();

    public static ToDoService getInstance(){
        activity = null;
        if( toDoService == null){
            toDoService = new ToDoService();
        }
        return toDoService;
    }

    public static ToDoService getInstance(Activity atv){
        if ( activity == null){
            activity = atv;
        }

        if (toDoService == null){
            toDoService = new ToDoService();
        }

        return toDoService;
    }


    // ------------------------ GET TO DO SERVICE----------------------------------

    public void getToDoList(String userId, final ToDoCallBack toDoCallBack){
        showProgressDialog();
        Call<List<ToDoResponse>> call = quanLyBoAPI.getToDoList(userId);
        call.enqueue(new Callback<List<ToDoResponse>>() {
            @Override
            public void onResponse(Call<List<ToDoResponse>> call, retrofit2.Response<List<ToDoResponse>> response) {
                if ( response.isSuccessful() ) {
                    List<ToDoResponse> toDoResponseList = response.body();
                    toDoCallBack.onSuccess(toDoResponseList);
                }else {
                    toDoCallBack.onFailure("Lỗi");
                }
            }

            @Override
            public void onFailure(Call<List<ToDoResponse>> call, Throwable t) {
                toDoCallBack.onFailure("Không thể kết nối tới sever");
            }
        });
    }

    public interface ToDoCallBack {
        void onSuccess(List<ToDoResponse> toDoResponseList);
        void onFailure(String errorCode);

    }


    // ------------------------ POST TO DO STATUS SERVICE----------------------------------

    public void postToDo(ToDoSuccessRequest toDoSuccessRequest, final PostToDoCallBack postToDoCallBack){
        showProgressDialog();
        Call<BaseResponse<ToDoSuccessResponse>> call = quanLyBoAPI.postStatusToDo(toDoSuccessRequest);
        call.enqueue(new Callback<BaseResponse<ToDoSuccessResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<ToDoSuccessResponse>> call, retrofit2.Response<BaseResponse<ToDoSuccessResponse>> response) {
                postToDoCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<ToDoSuccessResponse>> call, Throwable t) {
                postToDoCallBack.onFailure("Failure");
            }
        });
    }

    public void postNfcToDo(ToDoSuccessNfcRequest toDoSuccessNfcRequest, final  PostToDoCallBack postToDoCallBack){
        showProgressDialog();
        Call<BaseResponse<ToDoSuccessResponse>> call = quanLyBoAPI.postStatusNfcToDo(toDoSuccessNfcRequest);
        call.enqueue(new Callback<BaseResponse<ToDoSuccessResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<ToDoSuccessResponse>> call, Response<BaseResponse<ToDoSuccessResponse>> response) {
                postToDoCallBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<BaseResponse<ToDoSuccessResponse>> call, Throwable t) {
                postToDoCallBack.onFailure("Failure");

            }
        });
    }

    public interface PostToDoCallBack {
        void onSuccess(BaseResponse<ToDoSuccessResponse> toDoSuccessResponseBaseResponse);
        void onFailure(String errorCode);

    }


}
