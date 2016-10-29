package vn.edu.uit.quanlybo.Service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Respone.ListCowRespone;

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
    Call<ListCowRespone> getListCow(@Query("userId") String userId,
                                    @Query("access-token") String access_token);

}
