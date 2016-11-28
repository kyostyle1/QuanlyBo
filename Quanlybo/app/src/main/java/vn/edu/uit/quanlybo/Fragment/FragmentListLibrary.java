package vn.edu.uit.quanlybo.Fragment;

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

import vn.edu.uit.quanlybo.Adapter.ListLibraryAdapter;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoHeader;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryResponse;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryType;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.LibraryService;
import vn.edu.uit.quanlybo.Network.Model.ToDoResponse;
import vn.edu.uit.quanlybo.Network.ToDoService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class FragmentListLibrary  extends Fragment {

    private RecyclerView lvLibrary;
    private View rootView;
    private ListLibraryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_library, container, false);
        lvLibrary = (RecyclerView)rootView.findViewById(R.id.list_library);
        final List<ParentListItem> parentListItems = new ArrayList<>();

        LibraryService.getInstance().getListTypeLibrary(new LibraryService.GetListTypeLibrary() {
            @Override
            public void onSuccess(List<LibraryType> libraryTypeList) {
                for ( final LibraryType libraryType : libraryTypeList){
                    LibraryService.getInstance().getLibraryByType(libraryType.getId(), new LibraryService.GetLibraryByType() {
                        @Override
                        public void onSuccess(List<LibraryResponse> libraryResponseList) {
                            libraryType.setLibraryResponseList(libraryResponseList);
                            parentListItems.add(libraryType);
                            adapter = new ListLibraryAdapter(getContext(), parentListItems);
                            adapter.notifyDataSetChanged();
                            lvLibrary.setLayoutManager(new LinearLayoutManager(getContext()));
                            lvLibrary.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(String errorCode) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(String errorCode) {
                Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
