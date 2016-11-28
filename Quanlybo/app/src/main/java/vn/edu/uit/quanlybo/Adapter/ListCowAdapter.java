package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class ListCowAdapter extends ArrayAdapter<Cow> {

    int i ;
    String gender;

    public ListCowAdapter(Context context, List<Cow> cows){
        super(context, 0, cows);
    }


    @Override
    public Cow getItem(int position) {
        return super.getItem(position);
    }

    static class ViewHolder {
        TextView cow_target;
        TextView cow_type;
        TextView cow_source;
        TextView cow_born;
        TextView cow_gender;
        TextView cow_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cow cow = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cow_item, parent, false);
            holder = new ViewHolder();
            holder.cow_type = (TextView)convertView.findViewById(R.id.cow_type);
            holder.cow_id = (TextView)convertView.findViewById(R.id.cow_id);
            holder.cow_born = (TextView)convertView.findViewById(R.id.cow_born);
            holder.cow_gender = (TextView)convertView.findViewById(R.id.cow_gender);
            holder.cow_target = (TextView)convertView.findViewById(R.id.cow_target);
            holder.cow_source = (TextView)convertView.findViewById(R.id.cow_source);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
            i++;
        }

        holder.cow_id.setText("#" + cow.getId());
        holder.cow_gender.setText("Giới tính: " + cow.getGenderName());
        holder.cow_type.setText("Giống bò: " + cow.getTypeName());
        holder.cow_born.setText("Số ngày tuổi: " + cow.getDayOld().toString() + " ngày");
        holder.cow_source.setText("Nguồn gốc: " + cow.getSourceName());
        holder.cow_target.setText("Mục đích nuôi: " + cow.getTargetName());
        return convertView;
    }
}
