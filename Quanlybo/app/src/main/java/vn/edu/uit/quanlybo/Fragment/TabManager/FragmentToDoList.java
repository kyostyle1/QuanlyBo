package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        lvToDo = (RecyclerView)rootView.findViewById(R.id.to_do_list_view);
        final List<ToDoHeader> toDoHeaders = new ArrayList<>();
        final List<ParentListItem> parentListItems = new ArrayList<>();

        adapter = new ListCowToDoAdapter(getContext(), parentListItems);

        ToDoService.getInstance().getToDoList("24", new ToDoService.ToDoCallBack() {
            @Override
            public void onSuccess(List<ToDoResponse> toDoResponseList) {
                for ( ToDoResponse toDoResponse : toDoResponseList) {
                    //ToDoHeader eachHeader = new ToDoHeader(toDoResponse.getType().getName());
                    List<ToDoItem> toDoItems = new ArrayList<>();
                    for ( int i=0 ; i < toDoResponse.getCow_todo().size(); i++){
                        List<String> cowId = new ArrayList<>();
                        for ( int j = 0 ; j < toDoResponse.getCow_todo().get(i).getCow().size(); j++){
                            cowId.add(String.valueOf(toDoResponse.getCow_todo().get(i).getCow().get(j).getId()));
                        }
                        toDoItems.add(new ToDoItem(toDoResponse.getCow_todo().get(i).getTodo().getTitle(), cowId));
                    }
                    //eachHeader.setToDoItems(toDoItems);
                    //toDoHeaders.add(eachHeader);
                    toDoResponse.setToDoItems(toDoItems);
                    parentListItems.add(toDoResponse);
                }

                List<String> cowId = new ArrayList<>();
                cowId.add("1");
                cowId.add("2");
                cowId.add("3");

                for ( ToDoHeader toDoHeader : toDoHeaders){
                    List<ToDoItem> toDoItems = new ArrayList<>();
                    for ( int i = 0 ; i < 5 ; i++){
                        toDoItems.add(new ToDoItem("Item" + i, cowId));
                    }
                    toDoHeader.setToDoItems(toDoItems);
                    parentListItems.add(toDoHeader);
                }
                adapter = new ListCowToDoAdapter(getContext(), parentListItems);
                adapter.notifyDataSetChanged();
                lvToDo.setLayoutManager(new LinearLayoutManager(getContext()));
                lvToDo.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorCode) {

            }
        });

        /*List<String> cowId = new ArrayList<>();
        cowId.add("1");
        cowId.add("2");
        cowId.add("3");
        for ( int i = 0 ; i< 5; i++){
            ToDoHeader eachHeader = new ToDoHeader("Header " + i);
            toDoHeaders.add(eachHeader);
        }

        for ( ToDoHeader toDoHeader : toDoHeaders){
            List<ToDoItem> toDoItems = new ArrayList<>();
            for ( int i = 0 ; i < 5 ; i++){
                toDoItems.add(new ToDoItem("Item" + i, cowId));
            }
            toDoHeader.setToDoItems(toDoItems);
            parentListItems.add(toDoHeader);
        }
        adapter = new ListCowToDoAdapter(getContext(), parentListItems);
        adapter.notifyDataSetChanged();
        lvToDo.setLayoutManager(new LinearLayoutManager(getContext()));
        lvToDo.setAdapter(adapter);*/
        return rootView;
    }
}
