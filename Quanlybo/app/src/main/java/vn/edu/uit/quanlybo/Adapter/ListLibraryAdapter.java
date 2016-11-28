package vn.edu.uit.quanlybo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListLibraryHeaderViewHolder;
import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListLibraryItemViewHolder;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryResponse;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryType;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibratyToDo;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class ListLibraryAdapter extends ExpandableRecyclerAdapter<ListLibraryHeaderViewHolder, ListLibraryItemViewHolder> {

    private LayoutInflater inflater;

    public ListLibraryAdapter(Context context, List<ParentListItem> itemList){
        super(itemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListLibraryHeaderViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.library_type_item, parentViewGroup, false);
        return new ListLibraryHeaderViewHolder(view);
    }

    @Override
    public ListLibraryItemViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.library_item, childViewGroup, false);
        return new ListLibraryItemViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ListLibraryHeaderViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        LibraryType libraryType = (LibraryType) parentListItem;
        parentViewHolder.library_title_type.setText(libraryType.getName());
    }

    @Override
    public void onBindChildViewHolder(ListLibraryItemViewHolder childViewHolder, final int position, final Object childListItem) {
        //ToDoItem toDoItem = (ToDoItem)childListItem;
        LibraryResponse libraryResponse = (LibraryResponse) childListItem;
       // childViewHolder.library_title.setText(libratyToDo.getLibraryType().ge);
      //  childViewHolder.library_desctiption.setText(libratyToDo.getTodo().getDescription());
        childViewHolder.library_title.setText(libraryResponse.getContent());
    }

    @Override
    public void expandParent(ParentListItem parentListItem) {
        super.expandParent(parentListItem);
    }
}

