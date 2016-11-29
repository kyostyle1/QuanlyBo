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
                fragment = new FragmentSearchId();
                break;
            case 1:
                fragment = new FragmentSearchNFC();
                break;
            case 2:
                fragment = new FragmentSearchQrCode();
                break;
            default:
                fragment = new FragmentSearchId();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Search Id";
                break;
            case 1:
                title="Search NFC";
                break;
            case 2:
                title="Search QR";
                break;
        }

        return title;
    }
}
