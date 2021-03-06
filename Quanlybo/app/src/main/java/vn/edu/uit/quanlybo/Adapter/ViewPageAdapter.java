package vn.edu.uit.quanlybo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vn.edu.uit.quanlybo.Fragment.FragmentCreateCow;
import vn.edu.uit.quanlybo.Fragment.FragmentGetNFCCreateCow;
import vn.edu.uit.quanlybo.Fragment.FragmentListCow;
import vn.edu.uit.quanlybo.Fragment.FragmentPhoiGiong;
import vn.edu.uit.quanlybo.Fragment.FragmentSearchNFC;
import vn.edu.uit.quanlybo.Fragment.RootFragment;

/**
 * Created by phuc9 on 10/25/2016.
 */
public class ViewPageAdapter extends FragmentStatePagerAdapter {

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentListCow();
                break;
            case 1:
                fragment = new RootFragment(new FragmentGetNFCCreateCow());
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
                title="Danh sách bò";
                break;
            case 1:
                title="Tạo Bò";
                break;
            case 2:
                title="Kiểm tra phối giống";
                break;
        }

        return title;
    }
}