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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Activity.CowDetailActivity;
import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.ApiConnection;
import vn.edu.uit.quanlybo.R;
import vn.edu.uit.quanlybo.Respone.ListCowResponse;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentListCow extends Fragment implements ApiConnection {

    ListCowAdapter adapter = null;
    List<Cow> cows = new ArrayList<>();
    ListView cow_list = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_cow, container, false);
        cow_list = (ListView)rootView.findViewById(R.id.cow_list);
        Call<ListCowResponse> listCowResponseCall = service.getListCow(User.getInstance().getId(), User.getInstance().getAccess_token());

        listCowResponseCall.enqueue(new Callback<ListCowResponse>() {
            @Override
            public void onResponse(Call<ListCowResponse> call, Response<ListCowResponse> response) {
                ListCowResponse listCowResponse = response.body();
                if ( listCowResponse.getCow() == null){
                    return;
                }else {
                    cows = listCowResponse.getCow();
                    adapter = new ListCowAdapter(getContext(), R.layout.cow_item, cows);
                    adapter.setNotifyOnChange(true);
                    adapter.notifyDataSetChanged();
                    cow_list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListCowResponse> call, Throwable t) {

            }
        });

        cow_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("Id", String.valueOf(position));
                Cow cow_position = new Cow();
                cow_position = cows.get(position);
                Intent intent = new Intent(getActivity(), CowDetailActivity.class);
                intent.putExtra("cow_position", cow_position);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);

    }
}
