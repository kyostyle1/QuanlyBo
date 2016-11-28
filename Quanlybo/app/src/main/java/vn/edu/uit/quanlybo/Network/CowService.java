package vn.edu.uit.quanlybo.Network;

import android.app.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowService extends BaseService{

    private static CowService cowService = null;
    private QuanLyBoAPI quanLyBoAPI = getQuanLyBoAPI();

    public static CowService getInstance(){
        activity = null;
        if( cowService == null){
            cowService = new CowService();
        }
        return cowService;
    }

    public static CowService getInstance(Activity atv){
        if ( activity == null){
            activity = atv;
        }

        if (cowService == null){
            cowService = new CowService();
        }

        return cowService;
    }


    // ------------------------ GET COW LIST SERVICE----------------------------------

    public void getListCow(String userId, final GetListCow getListCow){
        showProgressDialog();
        Call<List<Cow>> call = quanLyBoAPI.getListCow(userId);
        call.enqueue(new Callback<List<Cow>>() {
            @Override
            public void onResponse(Call<List<Cow>> call, Response<List<Cow>> response) {
                if ( response.isSuccessful()){
                    List<Cow> cowList = response.body();
                    getListCow.onSuccess(cowList);
                }else {
                    getListCow.onFailure("Đã có lỗi xảy ra");
                }
            }

            @Override
            public void onFailure(Call<List<Cow>> call, Throwable t) {
                getListCow.onFailure("Không thể kết nối tới server");
            }
        });
    }

    public interface GetListCow {
        void onSuccess(List<Cow> cowList);
        void onFailure(String errorCode);

    }

    // ------------------------ GET COW DETAIL SERVICE----------------------------------

    public void getCowDetail(String userId, String cowId, final CowDetailCallBack cowDetailCallBack){
        showProgressDialog();
        Call<CowDetailResponse> call = quanLyBoAPI.getCowDetail(userId, cowId);
        call.enqueue(new Callback<CowDetailResponse>() {
            @Override
            public void onResponse(Call<CowDetailResponse> call, retrofit2.Response<CowDetailResponse> response) {
                if ( response.isSuccessful() ){
                    CowDetailResponse cowDetailResponse = response.body();
                    cowDetailCallBack.onSuccess(cowDetailResponse);
                }
                else {
                    cowDetailCallBack.onFailure("Lỗi xảy ra");
                }
            }

            @Override
            public void onFailure(Call<CowDetailResponse> call, Throwable t) {
                cowDetailCallBack.onFailure("Không thể kết nối tới sever");
            }
        });
    }

    public interface CowDetailCallBack {
        void onSuccess(CowDetailResponse cowDetailResponse);
        void onFailure(String errorCode);

    }

}
