<<<<<<< HEAD
=======

>>>>>>> 3af7b4341815f133a5761b1d5f2309ca3e7f670e
package vn.edu.uit.quanlybo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListCowToDoHeaderViewHolder;
import vn.edu.uit.quanlybo.Adapter.ViewHolder.ListCowToDoItemViewHolder;
import vn.edu.uit.quanlybo.AlertDialog.ListToDoDialog;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowStatus;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowToDo;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ListCowToDoAdapter extends ExpandableRecyclerAdapter<ListCowToDoHeaderViewHolder, ListCowToDoItemViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public ListCowToDoAdapter(Activity activity, Context context, List<ParentListItem> itemList) {
        super(itemList);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.activity = activity;

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
        final CowToDo cowToDo = (CowToDo) childListItem;
        childViewHolder.itemTitle.setText(cowToDo.getToDo().getTitle());
        final List<String> listCowDo = new ArrayList<>();
        final List<String> listCowNotDo = new ArrayList<>();

        /*for ( int i = 0 ; i < cowToDo.getCow().size(); i ++){
            listCowId.add(String.valueOf(cowToDo.getCow().get(i).getId()));
        }*/
        for (CowStatus cowStatus : cowToDo.getCow()) {
            if (cowStatus.getSuccess().equals("no")) {
                listCowNotDo.add(String.valueOf(cowStatus.getId()));
            } else {
                listCowDo.add(String.valueOf(cowStatus.getId()));
            }
        }
        String cowIdsDo = TextUtils.join(", #", listCowDo);
        String cowIdsNotDo = TextUtils.join(", #", listCowNotDo);

        if (listCowDo.size() > 0) {
            childViewHolder.itemCowIdDo.setText("Đã hoàn thành: #" + cowIdsDo);
        }

        if (listCowNotDo.size() > 0) {
            childViewHolder.itemCowIdNotDo.setText("Chưa hoàn thành: #" + cowIdsNotDo);
        }

        Picasso.with(context)
                .load(cowToDo.getToDo().getImg())
                .into(childViewHolder.itemImage);

        childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListToDoDialog listToDoDialog = new ListToDoDialog(activity);
                listToDoDialog.setTitle(cowToDo.getToDo().getTitle());
                listToDoDialog.setContent(cowToDo.getToDo().getContent());
                listToDoDialog.confirm();
                listToDoDialog.setToDoId(cowToDo.getToDo().getId());
                listToDoDialog.setListCheck(cowToDo.getCow());
                listToDoDialog.show();
            }
        });
    }

    @Override
    public void expandParent(ParentListItem parentListItem) {
        super.expandParent(parentListItem);
    }
<<<<<<< HEAD


}

=======
}
>>>>>>> 3af7b4341815f133a5761b1d5f2309ca3e7f670e
