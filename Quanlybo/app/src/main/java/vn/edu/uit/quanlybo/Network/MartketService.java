package vn.edu.uit.quanlybo.Network;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryType;
import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.Model.Market.SellCow;

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
        Call<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>> call = quanLyBoAPI.postCowSell(sellCow);
        call.enqueue(new Callback<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>>() {
            @Override
            public void onResponse(Call<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>> call, Response<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>> response) {
                SellCow cow = response.body().getData();
                postWannaSell.onSuccess(cow);
            }

            @Override
            public void onFailure(Call<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>> call, Throwable t) {
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
        Call<vn.edu.uit.quanlybo.Network.Model.Response<List<BuyCowReponse>>> call = quanLyBoAPI.getListBuyCow();
        call.enqueue(new Callback<vn.edu.uit.quanlybo.Network.Model.Response<List<BuyCowReponse>>>() {
            @Override
            public void onResponse(Call<vn.edu.uit.quanlybo.Network.Model.Response<List<BuyCowReponse>>> call, Response<vn.edu.uit.quanlybo.Network.Model.Response<List<BuyCowReponse>>> response) {
                List<BuyCowReponse> list = response.body().getData();
                getListBuyCow.onSuccess(list);
            }

            @Override
            public void onFailure(Call<vn.edu.uit.quanlybo.Network.Model.Response<List<BuyCowReponse>>> call, Throwable t) {
                getListBuyCow.onFailure("faliures");
            }
        });

    }

    public interface GetListBuyCow {
        void onSuccess(List<BuyCowReponse> buyCowReponseList);
        void onFailure(String errorCode);

    }
}


    /*Call<vn.edu.uit.quanlybo.Network.Model.Response<SellCow>> call = quanLyBoAPI.postCowSell(buyCow);
call.enqueue(new Callback<SellCow>() {
@Override
public void onResponse(Call<SellCow> call, Response<SellCow> response) {
        SellCow data =response.body();
        postWannaSell.onSuccess(data);
        }

@Override
public void onFailure(Call<SellCow> call, Throwable t) {
        postWannaSell.onFailure("");
        }
        });*/