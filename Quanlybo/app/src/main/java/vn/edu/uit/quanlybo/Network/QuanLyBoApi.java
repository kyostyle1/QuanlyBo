package vn.edu.uit.quanlybo.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.Model.Response;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
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
    Call<Response<UserLoginResponse>> getUserLogin(
            @Body UserLoginRequest userLoginRequest);

    @POST("register")
    Call<Response<UserRegisterResponse>> registerUser(
            @Body UserRegisterRequest userRegisterRequest);

    /*@FormUrlEncoded
    @POST("login")
    Call<User> createUser(
            @Field("login") String login,
            @Field("password") String password,
            @Field("email") String email,
            @Field("address") String address);*/

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

    @GET("cow")
    Call<List<Cow>> getListCow(@Query("userId") String userId);
}
