package vn.edu.uit.quanlybo.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.Model.UserLoginResponse;
import vn.edu.uit.quanlybo.Network.UserService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/18/2016.
 */
public class LoginActivity extends Activity {
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

    public void LoginButton() {
        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                String password_text = password.getText().toString();
                if (username_text.length() <= 3 || password_text.length() <= 3) {
                    Toast.makeText(getApplicationContext(), "Username or Passworld not enough length", Toast.LENGTH_SHORT).show();
                } else {
                    UserService.getInstance().userLogin(username_text, password_text, new UserService.GetUserCallBack() {

                        @Override
                        public void onSuccess(UserLoginResponse userLoginResponse) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            Log.d("TEST", userLoginResponse.getId());
                            User.getInstance().setId(userLoginResponse.getId());
                            User.getInstance().setRole(userLoginResponse.getRole());
                            User.getInstance().setEmail(userLoginResponse.getEmail());
                            User.getInstance().setAddress(userLoginResponse.getAddress());
                            User.getInstance().setAccessToken(userLoginResponse.getAccessToken());
                            User.getInstance().setActive(userLoginResponse.getActive());
                            User.getInstance().setDateCreated(userLoginResponse.getDateCreated());
                            User.getInstance().setDateUpdated(userLoginResponse.getDateUpdated());
                            User.getInstance().setPassword(userLoginResponse.getPassword());
                            User.getInstance().setUsername(userLoginResponse.getUsername());
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(String errorCode) {
                            AlertDialog alertFailure = new AlertDialogInfo().alertDialog(errorCode,LoginActivity.this);
                            alertFailure.show();
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
