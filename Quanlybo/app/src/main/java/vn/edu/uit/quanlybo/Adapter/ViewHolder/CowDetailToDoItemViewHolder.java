package vn.edu.uit.quanlybo.Adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowDetailToDoItemViewHolder extends ChildViewHolder{
    public TextView content;

    public CowDetailToDoItemViewHolder(View itemView) {
        super(itemView);
        content = (TextView)itemView.findViewById(R.id.cow_detail_to_do_content);
    }
}
