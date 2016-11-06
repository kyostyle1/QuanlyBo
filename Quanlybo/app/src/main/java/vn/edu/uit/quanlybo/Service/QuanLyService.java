package vn.edu.uit.quanlybo.Service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Respone.ListCowResponse;

/**
 * Created by phuc9 on 10/24/2016.
 */
public interface QuanLyService {

    @FormUrlEncoded
    @POST("site/login")
    Call<User> getUserLogin(
            @Field("login") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("site/register")
    Call<User> createUser(
            @Field("login") String login,
            @Field("password") String password,
            @Field("email") String email,
            @Field("address") String address);

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
}
