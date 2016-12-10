package vn.edu.uit.quanlybo.Fragment;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.AlertDialog.LibraryDialog;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.R;
import vn.edu.uit.quanlybo.Service.NfcCardReader;

/**
 * Created by Jackson Nghi on 12/10/2016.
 */

public class FragmentChooseCow extends Fragment implements NfcCardReader.NfcCallback {
    private View rootView;
    public static final String TAG = "CardReaderFragment";
    private TextView text_nfc;
    public static int READER_FLAGS =  NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;
    public NfcCardReader mNfcCardReader;
    List<Cow> cows = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search_nfc, container, false);
        Fragment fragment = new FragmentSellCows();
        Bundle bundle = new Bundle();
        bundle.putString("cow_id", "40");
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(container.getId(), fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        addCow();
        if (rootView != null) {
            text_nfc = (TextView) rootView.findViewById(R.id.text_nfc);
            text_nfc.setText("Waiting...");

            mNfcCardReader = new NfcCardReader(this);
            enableReaderMode();
        }




        return rootView;
    }

    private void addCow(){
        CowService.getInstance().getListCow(User.getInstance().getId(), new CowService.GetListCow() {
            @Override
            public void onSuccess(List<Cow> cowList) {
                cows = cowList;
            }

            @Override
            public void onFailure(String errorCode) {
                Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        disableReaderMode();
    }

    private void enableReaderMode() {
        Log.i(TAG, "Enabling reader mode");
        Activity activity = getActivity();
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(activity);
        if (nfc != null) {
            nfc.enableReaderMode(activity, mNfcCardReader, READER_FLAGS, null);
        }
    }

    private void disableReaderMode() {
        Log.i(TAG, "Disabling reader mode");
        Activity activity = getActivity();
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(activity);
        if (nfc != null) {
            nfc.disableReaderMode(activity);
        }
    }

    protected int checkCowInList(String id){
        for (int i=0; i<cows.size(); i++){
            if (cows.get(i).getNfcId().equals(id)){
                return i;
            }
        }
        return  -1;

    }
    @Override
    public void onAccountReceived(final String id) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_nfc.setText(id);
                int checkId = checkCowInList(String.valueOf(id));
                if(checkId!=-1){
                    Cow itemCow = cows.get(checkId);
                    Fragment fragment = new FragmentSellCows();
                    Bundle bundle = new Bundle();
                    bundle.putString("cow_id", itemCow.getId());
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(getView().getId(), fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    LibraryDialog libraryDialog = new LibraryDialog(getActivity());
                    libraryDialog.setTitle("Thông báo");
                    libraryDialog.setContent("Con bò này bạn không sở hữu!");
                    libraryDialog.show();
                }
            }
        });
    }

}

