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
import vn.edu.uit.quanlybo.Adapter.ListBuyCowAdapter;
import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.Market.BuyCowReponse;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.MartketService;
import vn.edu.uit.quanlybo.Network.Model.Response;
import vn.edu.uit.quanlybo.R;

import static vn.edu.uit.quanlybo.R.id.cow_list;

/**
 * Created by Jackson Nghi on 12/5/2016.
 */

public class FragmentListBuyCows extends Fragment {
    private View rootView;
    ListBuyCowAdapter adapter = null;
    List<BuyCowReponse> buyCowReponses = new ArrayList<>();
    ListView buy_cow_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_buy_cows, container, false);
        buy_cow_list = (ListView)rootView.findViewById(R.id.buy_cow_list);
        addCow();

//        buy_cow_list.setAdapter(adapter);
        buy_cow_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Cow itemCow = cows.get(position);
                Intent intent = new Intent(getContext(), CowDetailActivity.class);
                intent.putExtra("cow_id", itemCow.getId());
                startActivity(intent);*/
            }
        });
        return rootView;
    }

    private void addCow(){
        MartketService.getInstance().getListBuyCow( new MartketService.GetListBuyCow() {
            @Override
            public void onSuccess(List<BuyCowReponse> buyCowReponseList ) {

                buyCowReponses = buyCowReponseList;
                adapter = new ListBuyCowAdapter(getContext(), buyCowReponses);
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

