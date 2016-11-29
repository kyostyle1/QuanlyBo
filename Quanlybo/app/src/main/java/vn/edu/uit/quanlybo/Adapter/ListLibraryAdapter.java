package vn.edu.uit.quanlybo.Adapter;

import android.app.Activity;
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
import vn.edu.uit.quanlybo.AlertDialog.LibraryDialog;
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
    private Activity activity;

    public ListLibraryAdapter(Activity activity, Context context, List<ParentListItem> itemList){
        super(itemList);
        this.activity = activity;
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
        final LibraryResponse libraryResponse = (LibraryResponse) childListItem;
        childViewHolder.library_title.setText(libraryResponse.getTitle());
        childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibraryDialog libraryDialog = new LibraryDialog(activity);
                libraryDialog.setTitle(libraryResponse.getTitle());
                libraryDialog.setContent(libraryResponse.getContent());
                libraryDialog.exit();
                libraryDialog.show();


            }
        });
    }

    @Override
    public void expandParent(ParentListItem parentListItem) {
        super.expandParent(parentListItem);
    }
}

