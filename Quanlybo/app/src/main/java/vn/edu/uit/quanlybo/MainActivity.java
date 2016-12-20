package vn.edu.uit.quanlybo;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import vn.edu.uit.quanlybo.Fragment.FragmentListLibrary;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentTabTwo;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentMarket;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentSearchCow;
import vn.edu.uit.quanlybo.Fragment.TabManager.FragmentToDoList;

public class MainActivity extends FragmentActivity {

    private Fragment fragment;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
