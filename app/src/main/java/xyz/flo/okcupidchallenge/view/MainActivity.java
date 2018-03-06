package xyz.flo.okcupidchallenge.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import xyz.flo.okcupidchallenge.R;
import xyz.flo.okcupidchallenge.databinding.ActivityMainBinding;


/**
 * This is the main activity hosting a viewpager for the matches
 */
public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    ActivityMainBinding activityMainBinding;

    @Inject
    MatchPagerAdapter matchPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.executePendingBindings();

        matchPagerAdapter.setTabAmount(MatchPagerAdapter.TAB_AMOUNT);

        //Set up the pager adapter
        activityMainBinding.matchViewPager.setAdapter(matchPagerAdapter);
        activityMainBinding.matchViewPager.setOffscreenPageLimit(activityMainBinding.tabLayout.getTabCount());
        activityMainBinding.tabLayout.addTab(activityMainBinding.tabLayout.newTab().setText(getResources().getString(R.string.specialBlendTabName)));
        activityMainBinding.tabLayout.addTab(activityMainBinding.tabLayout.newTab().setText(getResources().getString(R.string.matchPercentTabName)));

        //Bind together the tablayout and viewpager
        activityMainBinding.matchViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(activityMainBinding.tabLayout));
        activityMainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                activityMainBinding.matchViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
