package vn.edu.uit.quanlybo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class FragmentSearchQrCode extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScannerView = new ZXingScannerView(getActivity());
        return mScannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String result = rawResult.getText();
        if( result != null){
            CowService.getInstance().getCowDetailByQrCode(User.getInstance().getId(), result, new CowService.CowDetailCallBack() {
                @Override
                public void onSuccess(CowDetailResponse cowDetailResponse) {
                    Bundle bundle = new Bundle();
                    bundle.putString("cow_id", cowDetailResponse.getCow().getId());
                    Fragment fragment = new FragmentDetailsBuyCow();
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                @Override
                public void onFailure(String errorCode) {
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(FragmentSearchQrCode.this);
            }
        }, 2000);
    }
}
