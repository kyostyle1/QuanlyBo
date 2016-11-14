package vn.edu.uit.quanlybo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.uit.quanlybo.Model.Cow;
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
                Log.d("OK", "OK");
                String search = search_cow_id.getText().toString();
                if( search != null ){
                    /*Call<Cow> cowSearchCall = service.getCowById(search_cow_id.getText().toString(), User.getInstance().getId(), User.getInstance().getAccess_token());
                    Log.d("Id", search);
                    Log.d("UserId", User.getInstance().getId());
                    Log.d("access_token", User.getInstance().getAccess_token());
                    Log.d("Id", search_cow_id.getText().toString());
                    cowSearchCall.enqueue(new Callback<Cow>() {
                        @Override
                        public void onResponse(Call<Cow> call, Response<Cow> response) {
                            if (response.isSuccessful()) {
                                Log.d("respone Code", String.valueOf(response.code()));
                                cow_search = response.body();
                                if ( cow_search == null){
                                    Toast.makeText(getContext(), "Không thể tìm thấy con bò này", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent = new Intent(getActivity(), CowDetailActivity.class);
                                    intent.putExtra("cow_position", cow_search);
                                    startActivity(intent);
                                }
                            } else {
                                Log.d("Test","TEST");
                            }
                        }

                        @Override
                        public void onFailure(Call<Cow> call, Throwable t) {
                            Toast.makeText(getContext(), "Không thể tìm thấy con bò này", Toast.LENGTH_SHORT).show();
                        }
                    });*/
                }
            }
        });
    }
}
