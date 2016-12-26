package vn.edu.uit.quanlybo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
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
        cow_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cow itemCow = cows.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("cow_id", itemCow.getId());
                Fragment fragment = new FragmentCowDetail();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    private void addCow(){
        CowService.getInstance().getListCow(User.getInstance().getId(), new CowService.GetListCow() {
            @Override
            public void onSuccess(List<Cow> cowList) {
                cows = cowList;
                adapter = new ListCowAdapter(getContext(), cows);
                adapter.notifyDataSetChanged();
                cow_list.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorCode) {
                Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
