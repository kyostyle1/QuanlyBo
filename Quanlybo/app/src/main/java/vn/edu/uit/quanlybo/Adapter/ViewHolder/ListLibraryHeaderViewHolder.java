package vn.edu.uit.quanlybo.Adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class ListLibraryHeaderViewHolder  extends ParentViewHolder {

        public TextView library_title_type;


        public ListLibraryHeaderViewHolder(View itemView) {
            super(itemView);

            library_title_type = (TextView) itemView.findViewById(R.id.library_title_type);
        }
    }

