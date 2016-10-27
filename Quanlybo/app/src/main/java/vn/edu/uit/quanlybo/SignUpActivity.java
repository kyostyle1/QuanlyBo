package vn.edu.uit.quanlybo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.ApiConnection;

/**
 * Created by phuc9 on 10/25/2016.
 */
public class SignUpActivity extends Activity implements ApiConnection {
    private EditText username;
    private EditText password;
    private EditText email;
    private EditText address;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        address = (EditText)findViewById(R.id.input_address);
        username = (EditText)findViewById(R.id.input_username);
        email = (EditText)findViewById(R.id.input_email);
        password = (EditText)findViewById(R.id.input_password);
        signUp = (Button)findViewById(R.id.btn_signup);

        btnSignUp();
        btnLogin();
    }

    private void btnSignUp(){
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_address = address.getText().toString();
                String str_username = username.getText().toString();
                String str_email = email.getText().toString();
                String str_password = password.getText().toString();
                String emailPartern = "[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}";
                if (str_email.matches(emailPartern)) {
                    Call<User> createUser = service.createUser(str_username,str_password,str_email,str_address);
                    createUser.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if ( response.code() == 422 ){
                                Toast.makeText(getApplicationContext(), "Email or Username already in use", Toast.LENGTH_SHORT).show();
                            }else if ( response.code() == 201){
                                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(), "Couldn't connect to server", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Couldn't connect to server", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void btnLogin(){
        TextView link_login = (TextView)findViewById(R.id.link_login);
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
