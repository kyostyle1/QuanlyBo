package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class ListCowAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> data;

    public ListCowAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ToDoViewHolder {
        public TextView tvTitle;
        public TextView tvSubtitle;
        public TextView tvDetail;
        public ImageView ivThumbnail;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ToDoViewHolder vh;
        if (view == null){
            view = layoutInflater.inflate(R.layout.to_do_list_item, null);
            vh = new ToDoViewHolder();
            //vh.tvDetail = (TextView)view.findViewById(R.id.);
            view.setTag(vh);
        }
        else{
            vh = (ToDoViewHolder)view.getTag();
        }

        return view;
    }
}
