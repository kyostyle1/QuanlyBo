package vn.edu.uit.quanlybo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.ApiConnection;
import vn.edu.uit.quanlybo.Service.QuanLyService;

/**
 * Created by phuc9 on 10/18/2016.
 */
public class LoginActivity extends Activity implements ApiConnection {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        LoginButton();
        SignUp();

    }

    public void LoginButton(){
        Button btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                String password_text = password.getText().toString();
                if( username_text.length() <= 3 || password_text.length() <= 3){
                    Toast.makeText(getApplicationContext(), "Username or Passworld not enough length", Toast.LENGTH_SHORT).show();
                }
                else {
                    Call<User> userCall = service.getUserLogin(username_text, password_text);
                    userCall.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            User decodeRespone = response.body();
                            if (decodeRespone == null) {
                                return;
                            }
                            User.getInstance().setUser(decodeRespone);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Your Username or Password is not correct", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    public void SignUp(){
        TextView signup = (TextView)findViewById(R.id.link_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
