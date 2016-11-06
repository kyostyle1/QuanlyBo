package vn.edu.uit.quanlybo.Fragment.TabManager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.uit.quanlybo.Adapter.SearchPageAdapter;
import vn.edu.uit.quanlybo.Adapter.ViewPageAdapter;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentSearchCow extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_cow, container, false);
        tabLayout = (TabLayout)rootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);
        FragmentManager manager = getChildFragmentManager();
        PagerAdapter adapter = new SearchPageAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return rootView;
    }
}
