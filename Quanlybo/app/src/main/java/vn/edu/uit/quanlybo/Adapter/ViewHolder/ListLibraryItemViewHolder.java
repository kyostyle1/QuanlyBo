package vn.edu.uit.quanlybo.Adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class ListLibraryItemViewHolder  extends ChildViewHolder {

        public TextView library_title;

        public ListLibraryItemViewHolder(View itemView) {
            super(itemView);

            library_title = (TextView) itemView.findViewById(R.id.library_title);
        }

}
