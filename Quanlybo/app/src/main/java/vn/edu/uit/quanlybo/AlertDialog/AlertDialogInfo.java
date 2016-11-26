package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Jackson Nghi on 11/26/2016.
 */

public  final  class AlertDialogInfo {
    public AlertDialog alertDialog(String infoAlert, Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Thiết lập tiêu đề hiển thị
        builder.setTitle("Thông báo");
        //Thiết lập thông báo hiển thị
        builder.setMessage(infoAlert);
        builder.setCancelable(false);
        //Tạo nút Hủy
        builder.setNeutralButton("OK", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
