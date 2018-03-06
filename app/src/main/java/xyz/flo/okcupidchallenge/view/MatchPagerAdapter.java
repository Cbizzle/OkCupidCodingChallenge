package xyz.flo.okcupidchallenge.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * A pager adapter that binds the two match based fragments to it
 */
public class MatchPagerAdapter extends FragmentStatePagerAdapter{

    public final static int TAB_AMOUNT = 2;

    private int tabAmount = 0;

    public MatchPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return BlendFragment.createInstance();

            case 1:
                return TopMatchFragment.createInstance();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabAmount;
    }

    public void setTabAmount(int tabAmount) {
        this.tabAmount = tabAmount;
    }
}
