package data.com.myapplication.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import data.com.myapplication.R;


/**
 * Created by aman on 12/3/17.
 */
class ViewPagerAdapter extends PagerAdapter {

    private int TAB_COUNT=2;
    private String tabTitles[] = new String[]{"Daily","Monthly"};
    private String targetDaily;
    private String targetMonthly;
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setData(String targetDaily,String targetMonthly){
        this.targetDaily=targetDaily;
        this.targetMonthly=targetMonthly;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position){
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.viewpager_item,container,false);
        container.addView(view);
        TextView textView = (TextView) view.findViewById(R.id.tv1);
        if(position==1)
            textView.setText(targetMonthly);
        else
            textView.setText(targetDaily);
        return  view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
