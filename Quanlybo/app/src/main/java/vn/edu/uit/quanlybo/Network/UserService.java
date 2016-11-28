package vn.edu.uit.quanlybo.Network;

import android.app.Activity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.Model.Response;
import vn.edu.uit.quanlybo.Network.Model.UserLoginRequest;
import vn.edu.uit.quanlybo.Network.Model.UserLoginResponse;
import vn.edu.uit.quanlybo.Network.Model.UserRegisterRequest;
import vn.edu.uit.quanlybo.Network.Model.UserRegisterResponse;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class UserService extends BaseService {

    private static UserService userService = null;
    private QuanLyBoAPI quanLyBoAPI = getQuanLyBoAPI();

    public static UserService getInstance(){
        activity = null;
        if( userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public static UserService getInstance(Activity atv){
        if ( activity == null){
            activity = atv;
        }

        if (userService == null){
            userService = new UserService();
        }

        return userService;
    }

    // ------------------------ USER LOGIN SERVICE ----------------------------------

    public void userLogin(String username, String password, final GetUserCallBack getUserCallBack){
        showProgressDialog();
        final UserLoginRequest request = new UserLoginRequest(username, password);
        Call<Response<UserLoginResponse>> call = quanLyBoAPI.getUserLogin(request);
        call.enqueue(new Callback<Response<UserLoginResponse>>() {
            @Override
            public void onResponse(Call<Response<UserLoginResponse>> call, retrofit2.Response<Response<UserLoginResponse>> response) {
                if (response.isSuccessful()){
                    if (!response.body().getSuccess()){
                        getUserCallBack.onFailure(response.body().getMessage());
                    }
                    else {
                        UserLoginResponse userLoginResponse = response.body().getData();
                        Log.d("Id",String.valueOf(userLoginResponse.getId()));
                        getUserCallBack.onSuccess(userLoginResponse);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<UserLoginResponse>> call, Throwable t) {
                getUserCallBack.onFailure("");
            }
        });


    }

    public interface GetUserCallBack {
        void onSuccess(UserLoginResponse userLoginResponse);
        void onFailure(String errorCode);

    }

    // ------------------------ USER REGISTER SERVICE ----------------------------------

    public void registerUser(String username, String password, String email, String phone, String address, String name, final RegisterUserCallBack registerUserCallBack){
        showProgressDialog();
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(username,password,email,phone,address,name);
        Call<Response<UserRegisterResponse>> call = quanLyBoAPI.registerUser(userRegisterRequest);
        call.enqueue(new Callback<Response<UserRegisterResponse>>() {
            @Override
            public void onResponse(Call<Response<UserRegisterResponse>> call, retrofit2.Response<Response<UserRegisterResponse>> response) {
                if ( response.isSuccessful()){
                    if( !response.body().getSuccess()){
                        registerUserCallBack.onFailure(response.body().getMessage());
                    }else {
                        UserRegisterResponse registerResponse = response.body().getData();
                        registerUserCallBack.onSuccess(registerResponse);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<UserRegisterResponse>> call, Throwable t) {
                registerUserCallBack.onFailure("");
            }
        });


    }

    public interface RegisterUserCallBack {
        void onSuccess(UserRegisterResponse registerResponse);
        void onFailure(String errorCode);
    }
}
