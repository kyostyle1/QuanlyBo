package vn.edu.uit.quanlybo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowCheckResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentPhoiGiong extends Fragment{

    View rootView;
    TextView cow_1st;
    TextView cow_2nd;
    Button btn_check;
    TextView result_check;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_phoi_giong, container, false);

        result_check = (TextView)rootView.findViewById(R.id.result_check);
        cow_1st = (TextView)rootView.findViewById(R.id.cow_1st);
        cow_2nd = (TextView)rootView.findViewById(R.id.cow_2nd);
        btn_check = (Button)rootView.findViewById(R.id.btn_check);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String cow1 = cow_1st.getText().toString();
                final String cow2 = cow_2nd.getText().toString();
                CowService.getInstance().checkCow(cow1, cow2, new CowService.CheckCowCallBack() {
                    @Override
                    public void onSuccess(CowCheckResponse cowCheckResponse) {
                        if ( cowCheckResponse.getStatus() == false){
                            result_check.setText("Bạn KHÔNG THỂ giao phối bò có ID " + cow1 + "  với bò có ID là " + cow2);
                        }
                        else {
                            result_check.setText("Bạn CÓ THỂ giao phối bò có ID " + cow1 + " với bò có ID là " + cow2);
                        }
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        result_check.setText("Không thể kiểm tra!");
                    }
                });
            }
        });

        return rootView;
    }
}
