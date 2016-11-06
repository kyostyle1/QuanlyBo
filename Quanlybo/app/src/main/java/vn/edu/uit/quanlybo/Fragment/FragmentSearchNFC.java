package vn.edu.uit.quanlybo.Fragment;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Network.ApiConnection;
import vn.edu.uit.quanlybo.R;
import vn.edu.uit.quanlybo.Service.NfcCardReader;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class FragmentSearchNFC extends Fragment implements ApiConnection, NfcCardReader.NfcCallback {
    public static final String TAG = "CardReaderFragment";
    private TextView text_nfc;
    public static int READER_FLAGS =  NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK;
    public NfcCardReader mNfcCardReader;
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

            mNfcCardReader = new NfcCardReader(this);
            enableReaderMode();
        }

        return v;
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

    @Override
    public void onAccountReceived(final String id) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_nfc.setText(id);
            }
        });
    }
}
