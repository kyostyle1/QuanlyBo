package vn.edu.uit.quanlybo.Network;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.Model.Response;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessRequest;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessResponse;
import vn.edu.uit.quanlybo.Network.Model.UserLoginRequest;
import vn.edu.uit.quanlybo.Network.Model.UserLoginResponse;

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
        Call<Response<ToDoSuccessResponse>> call = quanLyBoAPI.postStatusToDo(toDoSuccessRequest);
        call.enqueue(new Callback<Response<ToDoSuccessResponse>>() {
            @Override
            public void onResponse(Call<Response<ToDoSuccessResponse>> call, retrofit2.Response<Response<ToDoSuccessResponse>> response) {
                postToDoCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Response<ToDoSuccessResponse>> call, Throwable t) {
                postToDoCallBack.onFailure("Faliure");
            }
        });
    }

    public interface PostToDoCallBack {
        void onSuccess(Response<ToDoSuccessResponse> toDoSuccessResponseResponse);
        void onFailure(String errorCode);

    }


}
