<<<<<<< HEAD
=======

>>>>>>> 3af7b4341815f133a5761b1d5f2309ca3e7f670e
package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Activity.LoginActivity;
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by PhucHuynh on 12/27/16.
 */

public class FragmentProfile extends Fragment {

    View rooView;
    private TextView username;
    private EditText phoneNumber, address;
    private Button logout, saveinfo;

    SharedPreferences pre;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rooView = inflater.inflate(R.layout.profile_fragment, container, false);
        username = (TextView)rooView.findViewById(R.id.profile_name);
        phoneNumber = (EditText)rooView.findViewById(R.id.profile_phone_number);
        address = (EditText)rooView.findViewById(R.id.profile_address);
        logout = (Button)rooView.findViewById(R.id.btn_log_out);
        saveinfo = (Button)rooView.findViewById(R.id.btn_save_info);

        username.setText(User.getInstance().getName());
        address.setText(User.getInstance().getAddress());
        phoneNumber.setText(User.getInstance().getPhone());

        pre = getActivity().getSharedPreferences("quan_ly_bo", MODE_PRIVATE);
        editor = pre.edit();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("isLogin", false);
                editor.commit();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return rooView;
    }


}
<<<<<<< HEAD

=======
>>>>>>> 3af7b4341815f133a5761b1d5f2309ca3e7f670e
