package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListCowToDoHeaderViewHolder;
import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListCowToDoItemViewHolder;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoHeader;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListCowToDoAdapter extends ExpandableRecyclerAdapter<ListCowToDoHeaderViewHolder, ListCowToDoItemViewHolder> {

    private LayoutInflater inflater;

    public ListCowToDoAdapter(Context context, List<ParentListItem> itemList){
        super(itemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListCowToDoHeaderViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.list_cow_to_do_header, parentViewGroup, false);
        return new ListCowToDoHeaderViewHolder(view);
    }

    @Override
    public ListCowToDoItemViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.list_cow_to_do_item, childViewGroup, false);
        return new ListCowToDoItemViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ListCowToDoHeaderViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ToDoResponse toDoResponse = (ToDoResponse) parentListItem;
        parentViewHolder.headerTitle.setText(toDoResponse.getType().getName());
    }

    @Override
    public void onBindChildViewHolder(ListCowToDoItemViewHolder childViewHolder, final int position, final Object childListItem) {
        //ToDoItem toDoItem = (ToDoItem)childListItem;
        CowToDo cowToDo = (CowToDo)childListItem;

        childViewHolder.itemTitle.setText(cowToDo.getTodo().getTitle());
        List<String> listCowId = new ArrayList<>();
        for ( int i = 0 ; i < cowToDo.getCow().size(); i ++){
            listCowId.add(String.valueOf(cowToDo.getCow().get(i).getId()));
        }
        String cowIds = TextUtils.join(",", listCowId);
        childViewHolder.itemCowId.setText("Danh sách con bò cần làm: " + cowIds);
        childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void expandParent(ParentListItem parentListItem) {
        super.expandParent(parentListItem);
    }
}
