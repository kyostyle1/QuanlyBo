package vn.edu.uit.quanlybo.Network;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class QuanLyBoService {
    private static QuanLyBoAPI quanLyBoAPI;
    private static String baseUrl = "http://quanlybo.pkgs.vn/";

    public static QuanLyBoAPI getService(){
        if ( quanLyBoAPI == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            Retrofit service = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .serializeNulls()
                            .create()))
                    .client(okHttpClient)
                    .build();

            quanLyBoAPI = service.create(QuanLyBoAPI.class);
        }

        return quanLyBoAPI;
    }
}
