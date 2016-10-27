package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentToDoList extends Fragment {

    private ListView lvToDo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        lvToDo = (ListView)rootView.findViewById(R.id.to_do_list_view);
        return rootView;
    }
}
