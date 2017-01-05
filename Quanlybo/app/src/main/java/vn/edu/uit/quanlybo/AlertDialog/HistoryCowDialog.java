package vn.edu.uit.quanlybo.AlertDialog;

import android.app.Activity;
import android.app.Dialog;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import vn.edu.uit.quanlybo.Adapter.CheckListAdapter;
import vn.edu.uit.quanlybo.Model.CowDetail.HistoryCow;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 1/5/2017.
 */

public class HistoryCowDialog {
    private Dialog dialog;
    private Activity activity;
    private View contextView;
    private TableLayout tbhistory;
    private ListToDoDialog.OnCloseCallback onCloseCallback;

    public HistoryCowDialog(Activity atv){
        this.activity = atv;
        dialog = new Dialog(activity);
        contextView = activity.getLayoutInflater().inflate(R.layout.dialog_history_cow_content, null);
        dialog.setContentView(contextView);
        tbhistory = (TableLayout) contextView.findViewById(R.id.tb_history_cow);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        dialog.setTitle("ABC");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

    }

    public HistoryCowDialog exit(){
        return this;
    }

    public HistoryCowDialog show() {
        dialog.show();
        return this;
    }

    public HistoryCowDialog dismiss() {
        dialog.dismiss();
        if (onCloseCallback != null) {
            onCloseCallback.onClose();
        }
        return this;
    }

    public HistoryCowDialog setTitle(String title){

        if ( title == null){
            title = "THÔNG BÁO";
        }
        dialog.setTitle(title);

        return this;
    }

    public HistoryCowDialog setContent(List<HistoryCow> historyCowList){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1;
        TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

        if(historyCowList== null){
            TextView nullData = new TextView(activity);
            nullData.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            nullData.setPadding(20,20,20,20);
            nullData.setText("Không có dữ liệu");
            nullData.setGravity(Gravity.CENTER_HORIZONTAL);
            TableRow tbr_history = new TableRow(activity);
            tbr_history.addView(nullData);
            tbhistory.addView(tbr_history,layoutParams1);
        }
        else {


            TextView col_id = new TextView(activity);
            TextView col_user = new TextView(activity);
            TextView col_date = new TextView(activity);

            col_id.setLayoutParams(layoutParams);
            col_id.setGravity(Gravity.CENTER_HORIZONTAL);


            col_id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            col_user.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            col_date.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            col_id.setTextColor(activity.getResources().getColor(R.color.colorWhite));
            col_user.setTextColor(activity.getResources().getColor(R.color.colorWhite));
            col_date.setTextColor(activity.getResources().getColor(R.color.colorWhite));

            col_id.setPadding(10,10,10,10);


            col_id.setText("ID");
            col_user.setText("Chủ sở hữu");
            col_date.setText("Ngày sở hữu");


            TableRow name_tbr = new TableRow(activity);
            name_tbr.setLayoutParams(layoutParams1);
            name_tbr.setBackgroundResource(R.color.colorTableRow);
            name_tbr.invalidate();
            name_tbr.addView(col_id);
            name_tbr.addView(col_user);
            name_tbr.addView(col_date);
            tbhistory.addView(name_tbr,layoutParams1);

            for (HistoryCow historyCow:historyCowList){
                TextView row_id = new TextView(activity);
                TextView row_user = new TextView(activity);
                TextView row_date = new TextView(activity);
                row_id.setLayoutParams(layoutParams);
                row_id.setPadding(10,10,10,10);

                TableRow tbr_history = new TableRow(activity);
                tbr_history.setLayoutParams(layoutParams);
                row_id.setText(historyCow.getId());
                row_user.setText(historyCow.getUsername());
                row_date.setText(historyCow.getDate_created());

                row_id.setGravity(Gravity.CENTER_HORIZONTAL);
                row_id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                row_user.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                row_date.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);


                tbr_history.setBackgroundResource(R.drawable.border_layout);
                tbr_history.addView(row_id);
                tbr_history.addView(row_user);
                tbr_history.addView(row_date);

                tbhistory.addView(tbr_history,layoutParams1);
            }
        }
        return this;
    }

    public interface OnCloseCallback {
        void onClose();
    }
}
