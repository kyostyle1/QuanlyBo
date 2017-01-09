
package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.TypedValue;
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
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowStatus;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.BaseResponse;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.Model.ToDoSuccessNfcRequest;
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
    private BroadcastReceiver updateReceiver;


    public ListToDoDialog(final Activity atv){
        this.activity = atv;
        dialog = new Dialog(activity);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_to_do_list, null);
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

        updateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, Intent intent) {
                final String nfc_id = intent.getStringExtra("nfc_id");
                CowService.getInstance().getCowDetailByNfc(User.getInstance().getId(), nfc_id, new CowService.GetCowDetailByNfc() {
                    @Override
                    public void onSuccess(Boolean isCheck, CowDetailResponse cowDetailResponse) {
                        String success = "yes";
                        ToDoSuccessNfcRequest toDoSuccessNfcRequest = new ToDoSuccessNfcRequest(
                                nfc_id, String.valueOf(cowDetailResponse.getCow().getDayOld()), todoId, success
                        );
                        ToDoService.getInstance().postNfcToDo(toDoSuccessNfcRequest, new ToDoService.PostToDoCallBack() {
                            @Override
                            public void onSuccess(BaseResponse<ToDoSuccessResponse> toDoSuccessResponseBaseResponse) {
                                Toast.makeText(context, "Hoàn thành", Toast.LENGTH_SHORT).show();
                                dismiss();
                            }

                            @Override
                            public void onFailure(String errorCode) {

                            }
                        });

                    }

                    @Override
                    public void onFailure(String errorCode) {
                        Toast.makeText(atv,errorCode,Toast.LENGTH_SHORT);
                    }
                });



            }
        };
        atv.registerReceiver(updateReceiver, new IntentFilter(MainActivity.ACTION_UPDATE));

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
        try {
            activity.unregisterReceiver(updateReceiver);

        } catch (Exception e){

        }
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
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
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
