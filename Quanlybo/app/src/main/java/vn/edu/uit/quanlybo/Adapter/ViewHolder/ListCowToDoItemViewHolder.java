package vn.edu.uit.quanlybo.Adapter.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListCowToDoItemViewHolder extends ChildViewHolder {

    public TextView itemTitle;
    public TextView itemCowIdDo;
    public TextView itemCowIdNotDo;
    public ImageView itemImage;

    public ListCowToDoItemViewHolder(View itemView) {
        super(itemView);
        itemTitle = (TextView)itemView.findViewById(R.id.list_cow_to_do_item_title);
        itemCowIdDo = (TextView)itemView.findViewById(R.id.list_cow_to_do_item_id);
        itemCowIdNotDo = (TextView)itemView.findViewById(R.id.list_cow_to_do_item_id_1);
        itemImage = (ImageView)itemView.findViewById(R.id.list_to_do_item_image);
    }
}
