package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.uit.quanlybo.Model.Market.History_Cow;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/16/2016.
 */

public class ListDetailsHistoryBuyMarket extends ArrayAdapter<History_Cow> {
    public ListDetailsHistoryBuyMarket(Context context, List<History_Cow> history_cows){
        super(context,0,history_cows);
    }
    @Override
    public History_Cow getItem(int position) {
        return super.getItem(position);
    }
    static class ViewHolder{
        TextView id;
        TextView title;
        TextView descripton;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        History_Cow history_cow = getItem(position);
        ListDetailsHistoryBuyMarket.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.market_buy_cow_details_history_item, parent, false);
            holder = new ListDetailsHistoryBuyMarket.ViewHolder();
            holder.title = (TextView)convertView.findViewById(R.id.details_history_buy_cow_title);
            holder.id = (TextView)convertView.findViewById(R.id.details_history_buy_cow_id);
            holder.descripton = (TextView)convertView.findViewById(R.id.details_history_buy_cow_description);

            convertView.setTag(holder);
        }else {
            holder = (ListDetailsHistoryBuyMarket.ViewHolder)convertView.getTag();
        }

        holder.id.setText("#"+history_cow.getId());
        holder.title.setText(history_cow.getTitle());
        holder.descripton.setText(history_cow.getDescription());

        return convertView;
    }
}
