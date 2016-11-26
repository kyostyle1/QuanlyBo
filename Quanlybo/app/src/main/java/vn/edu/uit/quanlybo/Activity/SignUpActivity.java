package vn.edu.uit.quanlybo.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import vn.edu.uit.quanlybo.Network.Model.UserRegisterResponse;
import vn.edu.uit.quanlybo.Network.UserService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/25/2016.
 */
public class SignUpActivity extends Activity{
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
                String emailPartern = "\\S+@\\S+\\.\\S+";
                if (str_email.matches(emailPartern)) {
                    UserService.getInstance().registerUser(str_username, str_password, str_email, str_address, str_address, str_username, new UserService.RegisterUserCallBack() {
                        @Override
                        public void onSuccess(UserRegisterResponse registerResponse) {
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(String errorCode) {
                            AlertDialog alertFailure = new AlertDialogInfo().alertDialog(errorCode,SignUpActivity.this);
                            alertFailure.show();
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
