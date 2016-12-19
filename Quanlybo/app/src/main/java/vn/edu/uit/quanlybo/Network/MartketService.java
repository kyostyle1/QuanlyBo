package vn.edu.uit.quanlybo.Network;

import android.app.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.Model.Market.CodeOTP;
import vn.edu.uit.quanlybo.Model.Market.DetailsBuyCows;
import vn.edu.uit.quanlybo.Model.Market.SellCow;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;

/**
 * Created by Jackson Nghi on 12/10/2016.
 */

public class MartketService extends BaseService {

    private static MartketService martketService = null;

    private QuanLyBoAPI quanLyBoAPI = getQuanLyBoAPI();

    public static MartketService getInstance(){
        activity = null;
        if( martketService == null){
            martketService = new MartketService();
        }
        return martketService;
    }

    public static MartketService getInstance(Activity atv){
        if ( activity == null){
            activity = atv;
        }

        if (martketService == null){
            martketService = new MartketService();
        }

        return martketService;
    }

    // ------------------------ GET LIBRARY LIST SERVICE----------------------------------

    public void postCowWannaSell(SellCow sellCow, final PostWannaSell postWannaSell){
        showProgressDialog();
        Call<BaseResponse<SellCow>> call = quanLyBoAPI.postCowSell(sellCow);
        call.enqueue(new Callback<BaseResponse<SellCow>>() {
            @Override
            public void onResponse(Call<BaseResponse<SellCow>> call, Response<BaseResponse<SellCow>> response) {
                SellCow cow = response.body().getData();
                postWannaSell.onSuccess(cow);
            }

            @Override
            public void onFailure(Call<BaseResponse<SellCow>> call, Throwable t) {
                postWannaSell.onFailure("");
            }
        });
    }

    public interface PostWannaSell {
        void onSuccess(SellCow sellCow);
        void onFailure(String errorCode);

    }
    public void getListBuyCow(final GetListBuyCow getListBuyCow){
        showProgressDialog();
        Call<BaseResponse<List<BuyCowReponse>>> call = quanLyBoAPI.getListBuyCow();
        call.enqueue(new Callback<BaseResponse<List<BuyCowReponse>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<BuyCowReponse>>> call, Response<BaseResponse<List<BuyCowReponse>>> response) {
                List<BuyCowReponse> list = response.body().getData();
                getListBuyCow.onSuccess(list);
            }

            @Override
            public void onFailure(Call<BaseResponse<List<BuyCowReponse>>> call, Throwable t) {
                getListBuyCow.onFailure("faliures");
            }
        });

    }

    public interface GetListBuyCow {
        void onSuccess(List<BuyCowReponse> buyCowReponseList);
        void onFailure(String errorCode);

    }

    public void getDetailBuyCow(String marketId, final GetDetailBuyCow getDetailBuyCow){
        showProgressDialog();
        Call<BaseResponse<DetailsBuyCows>> call = quanLyBoAPI.getDetailBuyCow(marketId);
        call.enqueue(new Callback<BaseResponse<DetailsBuyCows>>() {
            @Override
            public void onResponse(Call<BaseResponse<DetailsBuyCows>> call, Response<BaseResponse<DetailsBuyCows>> response) {
                if(response.isSuccessful()){
                    DetailsBuyCows detailsBuyCows = response.body().getData();
                    getDetailBuyCow.onSuccess(detailsBuyCows);
                }
                else{
                    getDetailBuyCow.onFailure("Failure");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DetailsBuyCows>> call, Throwable t) {
                getDetailBuyCow.onFailure("Failure");
            }
        });
    }
    public  interface GetDetailBuyCow{
        void onSuccess(DetailsBuyCows detailsBuyCows);
        void onFailure(String errorCode);
    }

    public void getCodeOtp(String otpCode, final GetCodeOtp getCodeOtp){
        showProgressDialog();
        Call<BaseResponse<CodeOTP>> call = quanLyBoAPI.getCodeOtp(otpCode);
        call.enqueue(new Callback<BaseResponse<CodeOTP>>() {
            @Override
            public void onResponse(Call<BaseResponse<CodeOTP>> call, Response<BaseResponse<CodeOTP>> response) {
                if(response.isSuccessful()){
                    CodeOTP codeOTP = response.body().getData();
                    getCodeOtp.onSuccess(codeOTP);
                }
                else {
                    getCodeOtp.onFailure("Failure");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<CodeOTP>> call, Throwable t) {
                getCodeOtp.onFailure("Failure");

            }
        });

    }
    public interface GetCodeOtp{
        void onSuccess(CodeOTP codeOTP);
        void onFailure(String errorCode);
    }
}


    /*Call<vn.edu.uit.quanlybo.Network.Model.BaseResponse<SellCow>> call = quanLyBoAPI.postCowSell(buyCow);
call.enqueue(new Callback<SellCow>() {
@Override
public void onResponse(Call<SellCow> call, BaseResponse<SellCow> response) {
        SellCow data =response.body();
        postWannaSell.onSuccess(data);
        }

@Override
public void onFailure(Call<SellCow> call, Throwable t) {
        postWannaSell.onFailure("");
        }
        });*/