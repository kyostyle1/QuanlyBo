package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListToDoDialog {
    private Dialog dialog;
    private Activity activity;
    private View contextView;
    private OnCloseCallback onCloseCallback;

    public ListToDoDialog(Activity atv){
        this.activity = atv;
        dialog = new Dialog(activity, R.style.LoginCautionDialog);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_to_do_list, (ViewGroup)activity.getWindow().getDecorView(), false);
        dialog.setContentView(contextView);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.9f;
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setAttributes(lp);

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dismissButton();

    }

    private ListToDoDialog dismissButton() {
        Button dismissButton = (Button) contextView.findViewById(R.id.dialog_exit_button);
        dismissButton.setVisibility(View.VISIBLE);
        final ListToDoDialog thisLoginDialog = this;
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisLoginDialog.dismiss();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisLoginDialog.dismiss();
            }
        });

        return this;
    }

    public ListToDoDialog show() {
        dialog.show();
        return this;
    }

    public ListToDoDialog dismiss() {
        dialog.dismiss();
        if (onCloseCallback != null) {
            onCloseCallback.onClose();
        }
        return this;
    }

    public ListToDoDialog setTitle(String title){
        if ( title == null){
            title = "THÔNG BÁO";
        }
        TextView titleView = (TextView)contextView.findViewById(R.id.login_dialog_title);
        titleView.setText(title);
        return this;
    }

    public ListToDoDialog setDescription(String content){
        if ( content == null){
            content = "";
        }
        TextView contentView = (TextView)contextView.findViewById(R.id.login_dialog_content);
        contentView.setText(content);
        return this;
    }

    public interface OnClickCallback {
        void onClick();
    }

    public interface OnCloseCallback {
        void onClose();
    }
}
