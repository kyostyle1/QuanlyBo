package vn.edu.uit.quanlybo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Activity.CowDetailActivity;
import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentListCow extends Fragment{
    private View rootView;
    ListCowAdapter adapter = null;
    List<Cow> cows = new ArrayList<>();
    ListView cow_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_cow, container, false);
        addCow();
        cow_list = (ListView)rootView.findViewById(R.id.cow_list);
        adapter = new ListCowAdapter(getContext(), cows);
        cow_list.setAdapter(adapter);
        cow_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cow itemCow = cows.get(position);
                int cowId = itemCow.getId();

            }
        });
        return rootView;
    }

    private void addCow(){
        Cow cow = new Cow(1,50,51,3,1,"Abc","efd","28-11-2016","male", "milk", "born", 500, 123);
        Cow cow1 = new Cow(2,50,51,3,1,"Abc","efd","28-11-2016","male", "milk", "born", 500, 123);
        Cow cow2 = new Cow(3,50,51,3,1,"Abc","efd","28-11-2016","male", "milk", "born", 500, 123);
        Cow cow3 = new Cow(4,50,51,3,1,"Abc","efd","28-11-2016","male", "milk", "born", 500, 123);
        Cow cow4 = new Cow(5,50,51,3,1,"Abc","efd","28-11-2016","male", "milk", "born", 500, 123);
        cows.add(cow);
        cows.add(cow1);
        cows.add(cow2);
        cows.add(cow3);
        cows.add(cow4);
        cows.add(cow1);
        cows.add(cow2);
        cows.add(cow3);
        cows.add(cow4);
    }


}
