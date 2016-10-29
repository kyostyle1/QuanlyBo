package vn.edu.uit.quanlybo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.ApiConnection;
import vn.edu.uit.quanlybo.R;
import vn.edu.uit.quanlybo.Respone.ListCowRespone;

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
        Call<ListCowRespone> listCowResponseCall = service.getListCow(User.getInstance().getId(), User.getInstance().getAccess_token());
        Log.d("OK", "OK");
        listCowResponseCall.enqueue(new Callback<ListCowRespone>() {
            @Override
            public void onResponse(Call<ListCowRespone> call, Response<ListCowRespone> response) {
                Log.d("Body", response.body().toString());
                Log.d("Raw", response.raw().toString());
                ListCowRespone listCowRespone = response.body();
                if ( listCowRespone.getCow() == null){
                    return;
                }else {
                    cows = listCowRespone.getCow();
                    adapter = new ListCowAdapter(getContext(), R.layout.cow_item, cows);
                    adapter.setNotifyOnChange(true);
                    adapter.notifyDataSetChanged();
                    cow_list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListCowRespone> call, Throwable t) {

            }
        });

        return rootView;
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);

    }
}
