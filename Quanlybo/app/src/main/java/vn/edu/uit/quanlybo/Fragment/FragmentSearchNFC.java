package vn.edu.uit.quanlybo.Fragment;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class FragmentSearchNFC extends Fragment {
        //implements NfcCardReader.NfcCallback {
   // public static final String TAG = "CardReaderFragment";
    private TextView text_nfc;
    private BroadcastReceiver updateReceiver;
    private String cowId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_nfc, container, false);

        if (v != null) {
            text_nfc = (TextView) v.findViewById(R.id.text_nfc);
            text_nfc.setText("Áp thẻ NFC vào để tìm kiếm...");
            updateReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    final String nfc_id = intent.getStringExtra("nfc_id");
                    text_nfc.setText(nfc_id);
                    CowService.getInstance().getCowDetailByNfc(User.getInstance().getId(), nfc_id, new CowService.GetCowDetailByNfc() {
                        @Override
                        public void onSuccess(Boolean isCheck, CowDetailResponse cowDetailResponse) {
                            Log.d("KKKK",String.valueOf(isCheck));
                            if(isCheck){
                                cowId = cowDetailResponse.getCow().getId();

                               /* Intent intentCow = new Intent(getActivity(),CowDetailResponse.class);
                               // Fragment fragment = new FragmentSellCows();
                                intentCow.putExtra("cow_id",cowId);
                                startActivity(intentCow);*/
                             /*   FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();*/
                                getActivity().unregisterReceiver(updateReceiver);



                            } else {
                                AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                                alertDialogInfo.alertDialog("Bạn không sở hữu con bò với mã NFC: " + nfc_id,getActivity()).show();
                                text_nfc.setText("Áp thẻ NFC vào để tìm kiếm...");
                            }

                        }

                        @Override
                        public void onFailure(String errorCode) {
                            Toast.makeText(getActivity(),errorCode,Toast.LENGTH_SHORT);
                            text_nfc.setText("Áp thẻ NFC vào để tìm kiếm...");

                        }
                    });



                }
            };
            getActivity().registerReceiver(updateReceiver, new IntentFilter(MainActivity.ACTION_UPDATE));
        }




        return v;
    }
    @Override
    public void onDestroy(){
        try {
            getActivity().unregisterReceiver(updateReceiver);

        } catch (Exception e){

        }
        super.onDestroy();
    }


}
