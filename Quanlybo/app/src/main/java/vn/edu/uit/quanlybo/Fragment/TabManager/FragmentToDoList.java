package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ListCowToDoAdapter;
import vn.edu.uit.quanlybo.Model.ListCowToDo.CowToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoHeader;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.Network.ToDoService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentToDoList extends Fragment {

    private RecyclerView lvToDo;
    private View rootView;
    private ListCowToDoAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    final List<ToDoHeader> toDoHeaders = new ArrayList<>();
    final List<ParentListItem> parentListItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        lvToDo = (RecyclerView)rootView.findViewById(R.id.to_do_list_view);
        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });


        adapter = new ListCowToDoAdapter(getActivity(), getContext(), parentListItems);

        ToDoService.getInstance().getToDoList(User.getInstance().getId(), new ToDoService.ToDoCallBack() {
            @Override
            public void onSuccess(List<ToDoResponse> toDoResponseList) {
                for ( ToDoResponse toDoResponse : toDoResponseList) {
                    toDoResponse.setToDoItems(toDoResponse.getCow_todo());
                    parentListItems.add(toDoResponse);
                }

                adapter = new ListCowToDoAdapter(getActivity(), getContext(), parentListItems);
                adapter.notifyDataSetChanged();
                lvToDo.setLayoutManager(new LinearLayoutManager(getContext()));
                lvToDo.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorCode) {

            }
        });

        return rootView;
    }

    void refreshItems() {

        clearData();
        ToDoService.getInstance().getToDoList(User.getInstance().getId(), new ToDoService.ToDoCallBack() {
            @Override
            public void onSuccess(List<ToDoResponse> toDoResponseList) {
                for ( ToDoResponse toDoResponse : toDoResponseList) {
                    toDoResponse.setToDoItems(toDoResponse.getCow_todo());
                    parentListItems.add(toDoResponse);
                }

                adapter = new ListCowToDoAdapter(getActivity(), getContext(), parentListItems);
                adapter.notifyDataSetChanged();
                lvToDo.setLayoutManager(new LinearLayoutManager(getContext()));
                lvToDo.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorCode) {

            }
        });

        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...

        adapter.notifyDataSetChanged();
        // Stop refresh animation
        swipeRefreshLayout.setRefreshing(false);
    }

    public void clearData() {
        lvToDo.removeAllViewsInLayout();
        adapter.notifyDataSetChanged();
    }
}
