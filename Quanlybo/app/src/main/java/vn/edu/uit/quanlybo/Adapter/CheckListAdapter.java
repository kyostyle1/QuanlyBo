package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import vn.edu.uit.quanlybo.Model.ListCowToDo.CowStatus;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CheckListAdapter extends ArrayAdapter<CowStatus> {

    private List<CowStatus> cowStatuses;
    private Context context;

    public CheckListAdapter(Context context, int resource, List<CowStatus> cowStatuses) {
        super(context, resource, cowStatuses);
        this.cowStatuses = cowStatuses;
        this.context = context;
    }

    private class CheckViewHolder {
        TextView cowNameId;
        CheckBox checkBoxItem;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CowStatus cowStatus = cowStatuses.get(position);
        CheckViewHolder checkViewHolder = null;
        if ( convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.check_list_item, parent, false);
            checkViewHolder = new CheckViewHolder();
            checkViewHolder.checkBoxItem = ( CheckBox ) convertView.findViewById(R.id.checkBoxItem);
            checkViewHolder.cowNameId = (TextView) convertView.findViewById(R.id.cow_name_id);
            convertView.setTag(checkViewHolder);
            checkViewHolder.cowNameId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox cb = (CheckBox) view;
                    CowStatus cowStatus = (CowStatus) cb.getTag();
                    if ( cb.isChecked() ){
                        cowStatus.setSuccess("yes");
                    }else{
                        cowStatus.setSuccess("no");
                    }
                }
            });
        }else {
            checkViewHolder = (CheckViewHolder) convertView.getTag();
        }

        checkViewHolder.cowNameId.setText(String.valueOf(cowStatus.getId()));
        if ( cowStatus.getSuccess().equals("yes")){
            checkViewHolder.checkBoxItem.setChecked(true);
        }else {
            checkViewHolder.checkBoxItem.setChecked(false);
        }
        return convertView;
    }
}
