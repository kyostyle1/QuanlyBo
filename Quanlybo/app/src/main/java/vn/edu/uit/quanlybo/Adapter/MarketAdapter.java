package vn.edu.uit.quanlybo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vn.edu.uit.quanlybo.Fragment.FragmentChooseCow;
import vn.edu.uit.quanlybo.Fragment.FragmentCreateCow;
import vn.edu.uit.quanlybo.Fragment.FragmentDetailsBuyCow;
import vn.edu.uit.quanlybo.Fragment.FragmentListBuyCows;
import vn.edu.uit.quanlybo.Fragment.FragmentListCow;
import vn.edu.uit.quanlybo.Fragment.FragmentPhoiGiong;
import vn.edu.uit.quanlybo.Fragment.RootFragment;

/**
 * Created by phuc9 on 10/25/2016.
 */
public class MarketAdapter extends FragmentStatePagerAdapter {
    public Fragment fragment = null;
    public MarketAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                fragment = new FragmentListBuyCows();
                break;
            case 1:
                fragment = new FragmentChooseCow();
                break;
            case 2:
                fragment = new FragmentPhoiGiong();
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
                title="Chợ bò";
                break;
            case 1:
                title="Đăng bán bò";
                break;
            case 2:
               title="Danh sách bò đã đăng bán";
                break;
        }

        return title;
    }
}