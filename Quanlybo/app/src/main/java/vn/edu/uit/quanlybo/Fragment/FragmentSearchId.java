package vn.edu.uit.quanlybo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class FragmentSearchId extends Fragment {

    EditText search_cow_id;
    Button btn_search_id;
    Cow cow_search = new Cow();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_id, container, false);
        search_cow_id = (EditText) rootView.findViewById(R.id.search_cow_id);
        btn_search_id = (Button) rootView.findViewById(R.id.btn_search_id);
        return rootView;
    }



    @Override
    public void onStart() {
        super.onStart();
        btn_search_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String search = search_cow_id.getText().toString();
                CowService.getInstance().getCowDetail(User.getInstance().getId(), search, new CowService.GetCowDetailByNfc() {
                    @Override
                    public void onSuccess(Boolean isCheck, CowDetailResponse cowDetailResponse) {
                        if(isCheck)
                        {
                            Bundle bundle = new Bundle();
                            bundle.putString("cow_id", cowDetailResponse.getCow().getId());
                            Fragment fragment =  new FragmentCowDetail();;
                            fragment.setArguments(bundle);
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();



                        } else {
                            AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                            alertDialogInfo.alertDialog("Bạn không sở hữu con bò với ID: " + search,getActivity()).show();
                            search_cow_id.setText("");
                        }

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

