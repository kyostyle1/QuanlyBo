package vn.edu.uit.quanlybo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vn.edu.uit.quanlybo.Fragment.FragmentCreateCow;
import vn.edu.uit.quanlybo.Fragment.FragmentListCow;
import vn.edu.uit.quanlybo.Fragment.FragmentPhoiGiong;
import vn.edu.uit.quanlybo.Fragment.FragmentSearchId;
import vn.edu.uit.quanlybo.Fragment.FragmentSearchNFC;
import vn.edu.uit.quanlybo.Fragment.FragmentSearchQrCode;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class SearchPageAdapter extends FragmentStatePagerAdapter {

    public SearchPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentSearchNFC();
                break;
            case 1:
                fragment = new FragmentSearchId();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Tìm theo NFC";
                break;
            case 1:
               title="Tìm theo ID";
                break;
        }

        return title;
    }
}
