package vn.edu.uit.quanlybo.Fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/26/2016.
 */

public class FragmentGetNFCCreateCow extends android.support.v4.app.Fragment {
    //implements NfcCardReader.NfcCallback {
    // public static final String TAG = "CardReaderFragment";
    private TextView text_nfc;
    private BroadcastReceiver updateReceiver;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_nfc, container, false);

        if (v != null) {
            text_nfc = (TextView) v.findViewById(R.id.text_nfc);
            text_nfc.setText("Chạm thẻ NFC vào để tạo bò...");
            updateReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    final String nfc_id = intent.getStringExtra("nfc_id");
                    text_nfc.setText(nfc_id);
                    FragmentCreateCow fragment =  new FragmentCreateCow();
                    Bundle bundle = new Bundle();
                    bundle.putString("nfc_id",nfc_id);
                    fragment.setArguments(bundle);
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.root_frame,fragment);
                    trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    trans.addToBackStack(null);
                    trans.commit();




                }
            };
            getActivity().registerReceiver(updateReceiver, new IntentFilter(MainActivity.ACTION_UPDATE));
        }




        return v;
    }
    @Override
    public void onDestroyView() {
        getActivity().unregisterReceiver(updateReceiver);
        super.onDestroyView();
    }

}
