package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Adapter.CheckListAdapter;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class LibraryDialog {

    private Dialog dialog;
    private Activity activity;
    private View contextView;
    private ListToDoDialog.OnCloseCallback onCloseCallback;
    CheckListAdapter adapter;

    private String todoId;

    public LibraryDialog(Activity atv){
        this.activity = atv;
        dialog = new Dialog(activity);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_library_content, null);
        dialog.setContentView(contextView);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        dialog.setTitle("ABC");
        /*WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.9f;
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setAttributes(lp);*/

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

    }

    public LibraryDialog exit(){
        Button button = (Button)contextView.findViewById(R.id.btn_library_dismiss);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return this;
    }

    public LibraryDialog show() {
        dialog.show();
        return this;
    }

    public LibraryDialog dismiss() {
        dialog.dismiss();
        if (onCloseCallback != null) {
            onCloseCallback.onClose();
        }
        return this;
    }

    public LibraryDialog setTitle(String title){
        if ( title == null){
            title = "THÔNG BÁO";
        }
        dialog.setTitle(title);
        return this;
    }

    public LibraryDialog setContent(String content){
        if ( content == null){
            content = "";
        }
        TextView contentView = (TextView)contextView.findViewById(R.id.library_content);
        contentView.setText(content);
        return this;
    }

    public interface OnCloseCallback {
        void onClose();
    }
}
