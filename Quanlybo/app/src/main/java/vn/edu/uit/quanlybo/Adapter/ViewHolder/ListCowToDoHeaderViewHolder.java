package vn.edu.uit.quanlybo.Adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListCowToDoHeaderViewHolder extends ParentViewHolder {

    public TextView headerTitle;

    public ListCowToDoHeaderViewHolder(View itemView) {
        super(itemView);
        headerTitle = (TextView)itemView.findViewById(R.id.list_cow_to_do_header_title);
    }
}
