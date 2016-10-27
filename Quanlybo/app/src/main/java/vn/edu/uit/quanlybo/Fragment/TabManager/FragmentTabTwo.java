package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ViewPageAdapter;
import vn.edu.uit.quanlybo.Fragment.FragmentCreateCow;
import vn.edu.uit.quanlybo.Fragment.FragmentListCow;
import vn.edu.uit.quanlybo.Fragment.FragmentPhoiGiong;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentTabTwo extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
        tabLayout = (TabLayout)rootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);
        FragmentManager manager = getChildFragmentManager();
        PagerAdapter adapter = new ViewPageAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return rootView;
    }

}
