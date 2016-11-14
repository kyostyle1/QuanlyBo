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
    ArrayList<String> typeCow = new ArrayList<>();

    public ListCowAdapter(Context context,int resource, List<Cow> cows){
        super(context, resource, cows);
    }

    @Override
    public Cow getItem(int position) {
        return super.getItem(position);
    }

    static class ViewHolder {
        TextView cow_type;
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
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
            i++;
        }

        holder.cow_id.setText("#" + cow.getId());
        holder.cow_gender.setText(cow.getGender());
        holder.cow_type.setText(cow.getTypeId().toString());
        holder.cow_born.setText(cow.getBirthday());
        return convertView;
    }
}
