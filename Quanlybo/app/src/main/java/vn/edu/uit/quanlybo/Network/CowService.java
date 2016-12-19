package vn.edu.uit.quanlybo.Network;

import android.app.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;
import vn.edu.uit.quanlybo.Network.Model.CowCheckResponse;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.Model.CowTypeResponse;
import vn.edu.uit.quanlybo.Network.Model.CreateCowRequest;
import vn.edu.uit.quanlybo.Network.Model.NoData;

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



    // ------------------------ GET COW DETAIL BY NFC----------------------------------

    public void getCowDetailByNfc(String userId, String nfcId, final CowDetailCallBack cowDetailCallBack){
        showProgressDialog();
        Call<CowDetailResponse> call = quanLyBoAPI.getCowDetailByNfc(userId, nfcId);
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

    // ------------------------ GET COW DETAIL BY QRCODE----------------------------------

    public void getCowDetailByQrCode(String userId, String qrCode, final CowDetailCallBack cowDetailCallBack){
        showProgressDialog();
        Call<CowDetailResponse> call = quanLyBoAPI.getCowDetailByQrCode(userId, qrCode);
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


    // ------------------------ CREATE COW---------------------------------

    public void createCow(CreateCowRequest createCowRequest, final CreateCowCallBack createCowCallBack){
        showProgressDialog();
        Call<BaseResponse<NoData>> call = quanLyBoAPI.createCow(createCowRequest);
        call.enqueue(new Callback<BaseResponse<NoData>>() {
            @Override
            public void onResponse(Call<BaseResponse<NoData>> call, Response<BaseResponse<NoData>> response) {
                createCowCallBack.onSuccess();
            }

            @Override
            public void onFailure(Call<BaseResponse<NoData>> call, Throwable t) {
                createCowCallBack.onFailure("Failure");
            }
        });
    }


    public interface CreateCowCallBack {
        void onSuccess();
        void onFailure(String errorCode);

    }

    // ----------------- GET CODE TYPE ---------------

    public void getCowType(final GetCowTypeCallBack getCowTypeCallBack){
        showProgressDialog();
        Call<List<CowTypeResponse>> call = quanLyBoAPI.getCowType();
        call.enqueue(new Callback<List<CowTypeResponse>>() {
            @Override
            public void onResponse(Call<List<CowTypeResponse>> call, Response<List<CowTypeResponse>> response) {
                getCowTypeCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CowTypeResponse>> call, Throwable t) {
                getCowTypeCallBack.onFailure("Cannot connect to server");
            }
        });

    }

    public interface GetCowTypeCallBack{
        void onSuccess(List<CowTypeResponse> cowTypeResponseList);
        void onFailure(String errorCode);
    }

    // ----------------- CHECK COW TYPE ---------------

    public void checkCow(String cow_1, String cow_2, final CheckCowCallBack checkCowCallBack){
        showProgressDialog();
        Call<CowCheckResponse> call = quanLyBoAPI.checkCow(cow_1, cow_2);
        call.enqueue(new Callback<CowCheckResponse>() {
            @Override
            public void onResponse(Call<CowCheckResponse> call, Response<CowCheckResponse> response) {
                checkCowCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CowCheckResponse> call, Throwable t) {
                checkCowCallBack.onFailure("Failure");
            }
        });

    }

    public interface CheckCowCallBack{
        void onSuccess(CowCheckResponse cowCheckResponse);
        void onFailure(String errorCode);
    }
}
