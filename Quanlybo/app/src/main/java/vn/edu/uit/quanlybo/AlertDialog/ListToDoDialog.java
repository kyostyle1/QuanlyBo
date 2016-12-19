package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.edu.uit.quanlybo.Adapter.CheckListAdapter;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowStatus;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessRequest;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessResponse;
import vn.edu.uit.quanlybo.Network.ToDoService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListToDoDialog {
    private Dialog dialog;
    private Activity activity;
    private View contextView;
    private OnCloseCallback onCloseCallback;
    CheckListAdapter adapter;
    List<CowStatus> cowStatusList;
    ListView lv;
    private String todoId;

    public ListToDoDialog(Activity atv){
        this.activity = atv;
        dialog = new Dialog(activity);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_to_do_list, null);
        dialog.setContentView(contextView);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
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

    public ListToDoDialog confirm() {
        Button confirm = (Button) contextView.findViewById(R.id.btn_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for( int i =0 ; i < adapter.getCount(); i ++){
                    if ( adapter.getItem(i).getSuccess().equals("yes") ){
                        ToDoSuccessRequest toDoSuccessRequest = new ToDoSuccessRequest(
                                String.valueOf(adapter.getItem(i).getId()),
                                String.valueOf(adapter.getItem(i).getDay_old()),
                                todoId,
                                adapter.getItem(i).getSuccess()
                                );

                        ToDoService.getInstance().postToDo(toDoSuccessRequest, new ToDoService.PostToDoCallBack() {
                            @Override
                            public void onSuccess(BaseResponse<ToDoSuccessResponse> toDoSuccessResponseBaseResponse) {
                                Log.d("Success", "success");
                            }

                            @Override
                            public void onFailure(String errorCode) {
                                Log.d("Falire", errorCode);
                            }
                        });

                    }
                }
                Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show();
                dismiss();
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
        dialog.setTitle(title);
        return this;
    }

    public ListToDoDialog setContent(String content){
        if ( content == null){
            content = "";
        }
        TextView contentView = (TextView)contextView.findViewById(R.id.dialog_to_do_content);
        contentView.setText(content);
        return this;
    }

    public ListToDoDialog setListCheck(List<CowStatus> cowStatus){
        cowStatusList = cowStatus;
        lv = (ListView)contextView.findViewById(R.id.checkListToDo);
        adapter = new CheckListAdapter(activity.getBaseContext(), R.layout.check_list_item, cowStatus);
        lv.setAdapter(adapter);
        return this;
    }

    public ListToDoDialog setToDoId(String id){
        todoId = id;
        return this;
    }

    public interface OnCloseCallback {
        void onClose();
    }
}
