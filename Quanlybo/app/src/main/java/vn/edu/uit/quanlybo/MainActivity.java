package vn.edu.uit.quanlybo;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import vn.edu.uit.quanlybo.Fragment.FragmentChooseCow;
import vn.edu.uit.quanlybo.Fragment.FragmentListLibrary;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentTabTwo;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentMarket;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentSearchCow;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentToDoList;

public class MainActivity extends FragmentActivity {

    private Fragment fragment;
    //Create NFC
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    public final static String ACTION_UPDATE = "getNFC";

    //public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        //NFC

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        if (!hasNfc()) {
            Toast.makeText(this, "NFC is not avaliable", Toast.LENGTH_LONG).show();
        }

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.bottomBarToDo:
                        fragment = new FragmentToDoList();
                        break;

                    case R.id.bottomBarListCow:
                        fragment = new FragmentTabTwo();
                        break;

                    case R.id.bottomBarSearch:
                        fragment = new FragmentSearchCow();
                        break;

                    case R.id.bottomBarLibrary:
                        fragment = new FragmentListLibrary();
                        break;

                    case R.id.bottomBarMarket:
                        fragment = new FragmentMarket();
                        break;

                    default:
                        fragment = new FragmentToDoList();
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();
            }
        });

    }
    public boolean hasNfc() {
        boolean hasFeature =
                getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC);
        boolean isEnabled = NfcAdapter.getDefaultAdapter(this).isEnabled();
        return hasFeature && isEnabled;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        resolveIntent(intent);
        super.onNewIntent(intent);
    }
    private void resolveIntent(Intent intent) {
        String action = intent.getAction();

        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            String nfcId = byteArrayToHexString(intent.getByteArrayExtra(NfcAdapter.EXTRA_ID));
            Log.d("NFCAA",nfcId +             fragment.getClass().getSimpleName());
            Intent I = new Intent(ACTION_UPDATE);
            I.putExtra("nfc_id",nfcId);
            this.sendBroadcast(I);
        }
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
    protected void onPause() {
        super.onPause();
        nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }
    @Override
    public void onBackPressed() {
        if (fragment != null){


        }
            //user defined onBackPressed method. Not of Fragment.
        super.onBackPressed();
    }

        //this will pass BackPress event to activity. If not called, it will
        //prevent activity to get BackPress event.




}
