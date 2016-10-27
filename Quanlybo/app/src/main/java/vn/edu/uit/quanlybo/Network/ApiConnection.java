package vn.edu.uit.quanlybo.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.uit.quanlybo.Service.QuanLyService;

/**
 * Created by phuc9 on 10/24/2016.
 */
public interface ApiConnection {
    public static final String BASE_URL = "http://api.quanlybo.pkgs.vn/v1/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    QuanLyService service = retrofit.create(QuanLyService.class);

}
