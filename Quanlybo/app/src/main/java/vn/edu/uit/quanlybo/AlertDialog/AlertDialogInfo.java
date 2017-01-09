package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;

/**
 * Created by Jackson Nghi on 11/26/2016.
 */

public  final  class AlertDialogInfo {
    public String title;
    public AlertDialog alertDialog(String infoAlert, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Thiết lập tiêu đề hiển thị
        if(title == null ){
            title = "Thông báo";
        }
        builder.setTitle(title);
        //Thiết lập thông báo hiển thị
        builder.setMessage(infoAlert);
        builder.setCancelable(false);
        //Tạo nút Hủy
        builder.setNeutralButton("Đồng ý", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }


}
