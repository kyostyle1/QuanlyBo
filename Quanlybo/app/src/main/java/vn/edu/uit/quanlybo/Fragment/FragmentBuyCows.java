package vn.edu.uit.quanlybo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/5/2016.
 */

public class FragmentBuyCows extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_cows, container, false);
    }
}
