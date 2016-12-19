package vn.edu.uit.quanlybo.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryResponse;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryType;
import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.Model.Market.CodeOTP;
import vn.edu.uit.quanlybo.Model.Market.DetailsBuyCows;
import vn.edu.uit.quanlybo.Model.Market.RequestCodeOTP;
import vn.edu.uit.quanlybo.Model.Market.SellCow;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;
import vn.edu.uit.quanlybo.Network.Model.CowCheckResponse;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.Model.CowTypeResponse;
import vn.edu.uit.quanlybo.Network.Model.CreateCowRequest;
import vn.edu.uit.quanlybo.Network.Model.NoData;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessRequest;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessResponse;
import vn.edu.uit.quanlybo.Network.Model.UserLoginRequest;
import vn.edu.uit.quanlybo.Network.Model.UserLoginResponse;
import vn.edu.uit.quanlybo.Network.Model.UserRegisterRequest;
import vn.edu.uit.quanlybo.Network.Model.UserRegisterResponse;
import vn.edu.uit.quanlybo.Respone.ListCowResponse;

/**
 * Created by phuc9 on 10/24/2016.
 */
public interface QuanLyBoAPI {

    @POST("login")
    Call<BaseResponse<UserLoginResponse>> getUserLogin(
            @Body UserLoginRequest userLoginRequest);

    @POST("register")
    Call<BaseResponse<UserRegisterResponse>> registerUser(
            @Body UserRegisterRequest userRegisterRequest);

    @GET("cow-type")
    Call<List<CowTypeResponse>> getCowType();

    @POST("cow")
    Call<BaseResponse<NoData>> createCow(@Body CreateCowRequest createCowRequest);

    @GET("cow/search")
    Call<ListCowResponse> getListCow(@Query("userId") String userId,
                                     @Query("access-token") String access_token);

    @GET("cow/search-one")
    Call<Cow> getCowById(@Query("id") String id,
                         @Query("userId") String userId,
                         @Query("access-token") String access_token);

    @GET("cow/search-one")
    Call<Cow> getCowByNfc(@Query("nfcId") String nfcId,
                          @Query("userId") String userId,
                          @Query("access-token") String access_token);

    @GET("cow/todo-all/{userId}")
    Call<List<ToDoResponse>> getToDoList(@Path("userId") String userId);

    @GET("cow/todo-one")
    Call<CowDetailResponse> getCowDetail(@Query("userId") String userId,
                                         @Query("id") String cowId);

    @GET("cow/todo-one")
    Call<CowDetailResponse> getCowDetailByQrCode(@Query("userId") String userId,
                                                 @Query("qrId") String qrId);

    @GET("cow/todo-one")
    Call<CowDetailResponse> getCowDetailByNfc(@Query("userId") String userId,
                                              @Query("nfcId") String nfcId);

    @GET("cow")
    Call<List<Cow>> getListCow(@Query("userId") String userId);

    @GET("library")
    Call<List<LibraryResponse>> getLibraryList();

    @GET("library/type/{typeId}")
    Call<List<LibraryResponse>> getLibraryByType(@Path("typeId") String typeId);

    @GET("library-type")
    Call<List<LibraryType>> getTypeLibrary();

    @POST("cow/todo/success")
    Call<BaseResponse<ToDoSuccessResponse>> postStatusToDo(@Body ToDoSuccessRequest toDoSuccessRequest);

    @GET("cow/check")
    Call<CowCheckResponse> checkCow(@Query("cow_1st") String cow_1st
            , @Query("cow_2nd") String cow_2nd);

    @POST("market")
    Call<BaseResponse<SellCow>> postCowSell(@Body SellCow sellCow);

    @GET("market")
    Call<BaseResponse<List<BuyCowReponse>>> getListBuyCow();
    @GET("market/{marketId}")
    Call<BaseResponse<DetailsBuyCows>> getDetailBuyCow(@Path("marketId") String marketId);
    @GET("market/otp/{optCode}")
    Call<BaseResponse<CodeOTP>> getCodeOtp(@Path("optCode") String optCode);
    @POST("market/otp/{marketId}")
    Call<BaseResponse<Boolean>> postCodeOtp(@Path("marketId") String marketId,@Body RequestCodeOTP requestCodeOTP);
}
