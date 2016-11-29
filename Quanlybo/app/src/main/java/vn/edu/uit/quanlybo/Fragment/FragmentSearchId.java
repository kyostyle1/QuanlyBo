package vn.edu.uit.quanlybo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.uit.quanlybo.Activity.CowDetailActivity;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class FragmentSearchId extends Fragment{

    EditText search_cow_id;
    Button btn_search_id;
    Cow cow_search = new Cow();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_id, container, false);
        search_cow_id = (EditText)rootView.findViewById(R.id.search_cow_id);
        btn_search_id = (Button)rootView.findViewById(R.id.btn_search_id);
        Log.d("OK", "OK");

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        btn_search_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = search_cow_id.getText().toString();
                CowService.getInstance().getCowDetail(User.getInstance().getId(), search, new CowService.CowDetailCallBack() {
                    @Override
                    public void onSuccess(CowDetailResponse cowDetailResponse) {
                        Intent intent = new Intent(getContext(), CowDetailActivity.class);
                        intent.putExtra("cow_id", cowDetailResponse.getCow().getId());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
