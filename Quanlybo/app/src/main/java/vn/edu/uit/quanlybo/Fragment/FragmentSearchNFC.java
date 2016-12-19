package vn.edu.uit.quanlybo.Fragment;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class FragmentSearchNFC extends Fragment {
        //implements NfcCardReader.NfcCallback {
   // public static final String TAG = "CardReaderFragment";
    private TextView text_nfc;
    //public static int READER_FLAGS =  NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;
    //public NfcCardReader mNfcCardReader;
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_nfc, container, false);

        if (v != null) {
            text_nfc = (TextView) v.findViewById(R.id.text_nfc);
            text_nfc.setText("Waiting...");
            nfcAdapter = NfcAdapter.getDefaultAdapter(getActivity());
            pendingIntent = PendingIntent.getActivity(getActivity(), 0,
                    new Intent(getActivity(), getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

            if (!hasNfc()) {
                Toast.makeText(getActivity(), "NFC isn't available", Toast.LENGTH_LONG).show();
            }
           // mNfcCardReader = new NfcCardReader(this);
            //  enableReaderMode();
        }

        return v;
    }


    public void onNewIntent(Intent intent) {
        text_nfc.setText("Listening...");
        resolveIntent(intent);
    }

    private void resolveIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            text_nfc.setText(byteArrayToHexString(intent.getByteArrayExtra(NfcAdapter.EXTRA_ID)));
        }
    }
    boolean hasNfc() {
        boolean hasFeature =
                getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC);
        boolean isEnabled = NfcAdapter.getDefaultAdapter(getActivity()).isEnabled();
        return hasFeature && isEnabled;
    }
    private String byteArrayToHexString(byte[] b) {
        int len = b.length;
        String data = new String();

        for (int i = 0; i < len; i++){
            data += Integer.toHexString((b[i] >> 4) & 0xf);
            data += Integer.toHexString(b[i] & 0xf);
        }
        return data;
    }
    @Override
    public void onPause() {
        super.onPause();
        nfcAdapter.disableForegroundDispatch(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(getActivity(), pendingIntent, null, null);
    }

  /*  @Override
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

    @Override
    public void onAccountReceived(final String id) {
        Log.d("NFCA",id);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_nfc.setText(id);
            }
        });
    }*/
}
