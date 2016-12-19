package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/8/2016.
 */

public class ListBuyCowAdapter extends ArrayAdapter<BuyCowReponse> {



public ListBuyCowAdapter(Context context, List<BuyCowReponse> buyCowReponses){
        super(context, 0, buyCowReponses);
        }


@Override
public BuyCowReponse getItem(int position) {
        return super.getItem(position);
        }

static class ViewHolder {
    TextView title;
    TextView id;
    TextView location;
    TextView price;
    TextView cow_type;
    TextView cow_gender;
    TextView date_created;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BuyCowReponse buyCowReponse = getItem(position);
        ListBuyCowAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_buy_cow_item, parent, false);
            holder = new ListBuyCowAdapter.ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.buy_cow_id);
            holder.title = (TextView) convertView.findViewById(R.id.buy_cow_title);
            holder.location = (TextView) convertView.findViewById(R.id.sell_location);
            holder.price = (TextView) convertView.findViewById(R.id.sell_cow_price);
            holder.cow_type = (TextView) convertView.findViewById(R.id.buy_cow_type);
            holder.cow_gender = (TextView) convertView.findViewById(R.id.buy_cow_gender);
            holder.date_created = (TextView) convertView.findViewById(R.id.sell_date);
            convertView.setTag(holder);
        }else {
            holder = (ListBuyCowAdapter.ViewHolder)convertView.getTag();
        }
        holder.id.setText(buyCowReponse.getId());
        holder.title.setText(buyCowReponse.getTitle());
        holder.location.setText("Địa chỉ: " + buyCowReponse.getLocation());
        holder.price.setText("Giá: " + String.valueOf(buyCowReponse.getPrice()));
        holder.cow_type.setText("Giống bò: " + buyCowReponse.getCow_type());
        holder.cow_gender.setText("Giới tính: " + buyCowReponse.getCow_gender());
        holder.date_created.setText(buyCowReponse.getDate_created());
        return convertView;
    }
}
