package data.com.myapplication.sub_category.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 28/3/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> fragmentTitleList = new ArrayList<>();
    private int i;
    private String query;
    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        i=position;
        return new ProductsListFragment().newInstance(position,query);
    }

    @Override
    public int getCount() {
        return fragmentTitleList.size();
    }

    public void setTabData(String query,List<String> fragmentTitleList)
    {
        this.query=query;
        this.fragmentTitleList = fragmentTitleList;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return fragmentTitleList.get(position);
    }

    @Override
    public int getItemPosition(Object object)
    {

        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }


}
