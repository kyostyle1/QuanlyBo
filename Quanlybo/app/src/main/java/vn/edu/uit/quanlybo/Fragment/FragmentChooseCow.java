package vn.edu.uit.quanlybo.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.MainActivity;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/10/2016.
 */

public class FragmentChooseCow extends Fragment  {

    public static final String TAG = "CardReaderFragment";
    // Recommend NfcAdapter flags for reading from other Android devices. Indicates that this
    // activity is interested in NFC-A devices (including other Android devices), and that the
    // system should not check for the presence of NDEF-formatted data (e.g. Android Beam).
    private TextView mAccountField;
    private BroadcastReceiver updateReceiver;

    private String cowId;
    /** Called when sample is created. Displays generic UI with welcome text. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_nfc, container, false);
        if (v != null) {
            mAccountField = (TextView) v.findViewById(R.id.text_nfc);
            mAccountField.setText("Áp thẻ NFC vào để tìm kiếm...");
            updateReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    final String nfc_id = intent.getStringExtra("nfc_id");
                    mAccountField.setText(nfc_id);
                    CowService.getInstance().getCowDetailByNfc(User.getInstance().getId(), nfc_id, new CowService.GetCowDetailByNfc() {
                        @Override
                        public void onSuccess(Boolean isCheck, CowDetailResponse cowDetailResponse) {
                            if(isCheck){
                                cowId = cowDetailResponse.getCow().getId();
                                Fragment fragment = new FragmentSellCows();
                                Bundle bundle = new Bundle();
                                bundle.putString("cow_id",cowId);
                                fragment.setArguments(bundle);
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.text_nfc, fragment);
                                fragmentTransaction.addToBackStack(null);
                                getActivity().unregisterReceiver(updateReceiver);
                                fragmentTransaction.commit();


                            } else {
                                AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                                alertDialogInfo.alertDialog("Bạn không sở hữu con bò với mã NFC: " + nfc_id,getActivity()).show();
                                mAccountField.setText("Áp thẻ NFC vào để tìm kiếm...");
                            }

                        }

                        @Override
                        public void onFailure(String errorCode) {
                            Toast.makeText(getActivity(),errorCode,Toast.LENGTH_SHORT);
                            mAccountField.setText("Áp thẻ NFC vào để tìm kiếm...");

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
        getActivity().unregisterReceiver(updateReceiver);
        super.onDestroy();
    }

}