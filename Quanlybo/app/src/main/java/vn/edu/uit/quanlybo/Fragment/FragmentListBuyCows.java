package vn.edu.uit.quanlybo.Fragment;

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

import vn.edu.uit.quanlybo.Adapter.ListBuyCowAdapter;
import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.Network.MartketService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/5/2016.
 */

public class FragmentListBuyCows extends Fragment {
    private View rootView;
    ListBuyCowAdapter adapter = null;
    List<BuyCowReponse> buyCowReponses = new ArrayList<>();
    ListView buy_cow_list;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_buy_cows, container, false);
        buy_cow_list = (ListView)rootView.findViewById(R.id.buy_cow_list);
        addCow();

        buy_cow_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BuyCowReponse itemBuyCow = buyCowReponses.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("marketId", itemBuyCow.getId());
                Fragment fragment = new FragmentDetailsBuyCow();
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
        MartketService.getInstance().getListBuyCow( new MartketService.GetListBuyCow() {
            @Override
            public void onSuccess(List<BuyCowReponse> buyCowReponseList ) {

                buyCowReponses = buyCowReponseList;
                adapter = new ListBuyCowAdapter(getContext(), buyCowReponses,false);
                adapter.notifyDataSetChanged();
                buy_cow_list.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorCode) {
                Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
            }
        });
    }



}

