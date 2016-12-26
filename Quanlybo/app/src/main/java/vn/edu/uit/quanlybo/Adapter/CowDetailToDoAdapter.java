package vn.edu.uit.quanlybo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ViewHolder.CowDetailToDoItemViewHolder;
import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListCowToDoHeaderViewHolder;
import vn.edu.uit.quanlybo.Model.CowDetail.CurrentToDo;
import vn.edu.uit.quanlybo.Model.CowDetail.ToDoDetail;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowDetailToDoAdapter extends ExpandableRecyclerAdapter<ListCowToDoHeaderViewHolder, CowDetailToDoItemViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public CowDetailToDoAdapter(Activity activity,Context context, List<ParentListItem> itemList){
        super(itemList);
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.activity = activity;

    }

    @Override
    public ListCowToDoHeaderViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.list_cow_to_do_header, parentViewGroup, false);
        return new ListCowToDoHeaderViewHolder(view);
    }

    @Override
    public CowDetailToDoItemViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.to_do_list_item, childViewGroup, false);
        return new CowDetailToDoItemViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ListCowToDoHeaderViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        CurrentToDo currentToDo = (CurrentToDo) parentListItem;
        parentViewHolder.headerTitle.setText(currentToDo.getType().getName());
    }

    @Override
    public void onBindChildViewHolder(CowDetailToDoItemViewHolder childViewHolder, final int position, final Object childListItem) {
        final ToDoDetail toDoDetail = (ToDoDetail)childListItem;
        if ( toDoDetail.getSuccess().equals("yes")) {
            childViewHolder.content.setText(toDoDetail.getTitle());
            childViewHolder.content.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            childViewHolder.content.setText(toDoDetail.getTitle());
        }

    }

    @Override
    public void expandParent(ParentListItem parentListItem) {
        super.expandParent(parentListItem);
    }
}

