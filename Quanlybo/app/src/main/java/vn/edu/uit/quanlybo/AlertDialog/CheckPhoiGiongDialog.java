package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Adapter.CheckListAdapter;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 1/6/2017.
 */

public class CheckPhoiGiongDialog {
    private Dialog dialog;
    private Activity activity;
    private View contextView;
    private ListToDoDialog.OnCloseCallback onCloseCallback;
    private BroadcastReceiver updateReceiver;
    private String cow_id;

    public CheckPhoiGiongDialog(Activity atv, final String cow_id){
        this.activity = atv;
        dialog = new Dialog(activity);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_check_cow_phoigiong, null);
        dialog.setContentView(contextView);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        dialog.setTitle("ABC");


        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        updateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String nfc_id = intent.getStringExtra("nfc_id");
                CowService.getInstance().getCheckPhoiGiongNFC(cow_id,nfc_id, new CowService.GetCheckNFCPhoiGiong() {
                    @Override
                    public void onSuccess(String status) {
                        setContent(status);
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        setContent(errorCode);

                    }
                });
            }
        };

    }

    public CheckPhoiGiongDialog exit(){
        return this;
    }

    public CheckPhoiGiongDialog show() {
        dialog.show();
        return this;
    }

    public CheckPhoiGiongDialog dismiss() {
        dialog.dismiss();
        try {
            activity.unregisterReceiver(updateReceiver);

        } catch (Exception e){

        }
        if (onCloseCallback != null) {
            onCloseCallback.onClose();
        }
        return this;
    }

    public CheckPhoiGiongDialog setTitle(String title){
        if ( title == null){
            title = "THÔNG BÁO";
        }
        dialog.setTitle(title);

        return this;
    }

    public CheckPhoiGiongDialog setContent(String content){
        if ( content == null){
            content = "";
        }
        TextView contentView = (TextView)contextView.findViewById(R.id.txt_check_phoigiong);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        contentView.setText(content);
        return this;
    }

    public interface OnCloseCallback {
        void onClose();
    }
}
