package com.example.admin.contactfunctionality.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.contactfunctionality.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        findViewByIds(rootView);
        return rootView;



    }




    private void findViewByIds(View rootView) {
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabs();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(((AppCompatActivity) getActivity()).getSupportFragmentManager());
        adapter.addFrag(new LogsFragment(), getString(R.string.alllogs));
        adapter.addFrag(new OutGoingFragment(), getString(R.string.Outgoing));
        adapter.addFrag(new IncomingFragment(), getString(R.string.incoming));
        adapter.addFrag(new MIssedCallFragment(), getString(R.string.misscall));
        adapter.addFrag(new CallDropFragment(), getString(R.string.calldrop));

        adapter.addFrag(new AllContactFragment(), getString(R.string.allContact));

        viewPager.setAdapter(adapter);
    }

    private void setupTabs() {

        LayoutInflater mInflater1 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView1 = mInflater1.inflate(R.layout.list_tab_item, null);

        final TextView tabOnenew = (TextView) convertView1.findViewById(R.id.list_tab_item_title);

        tabOnenew.setText(getString(R.string.alllogs));
        tabLayout.getTabAt(0).setCustomView(convertView1);

        LayoutInflater mInflater3 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView3 = mInflater3.inflate(R.layout.list_tab_item, null);

        final TextView tabOne1 = (TextView) convertView3.findViewById(R.id.list_tab_item_title);


        tabOne1.setText(getString(R.string.Outgoing));
        tabLayout.getTabAt(1).setCustomView(convertView3);


        LayoutInflater mInflater2 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView2 = mInflater2.inflate(R.layout.list_tab_item, null);
        final TextView tabTwo1 = (TextView) convertView2.findViewById(R.id.list_tab_item_title);

        tabTwo1.setText(getString(R.string.incoming));
        tabLayout.getTabAt(2).setCustomView(convertView2);


        LayoutInflater mInflater4 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView4 = mInflater4.inflate(R.layout.list_tab_item, null);
        final TextView tabTwo3 = (TextView) convertView4.findViewById(R.id.list_tab_item_title);

        tabTwo3.setText(getString(R.string.misscall));
        tabLayout.getTabAt(3).setCustomView(convertView4);


        LayoutInflater mInflater6 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView6 = mInflater6.inflate(R.layout.list_tab_item, null);
        final TextView tabTwo = (TextView) convertView6.findViewById(R.id.list_tab_item_title);

        tabTwo.setText(getString(R.string.calldrop));
        tabLayout.getTabAt(4).setCustomView(convertView6);


        LayoutInflater mInflater5 = (LayoutInflater) ((AppCompatActivity) getActivity()).getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView5 = mInflater5.inflate(R.layout.list_tab_item, null);

        final TextView tabfive = (TextView) convertView5.findViewById(R.id.list_tab_item_title);

        tabfive.setText(getString(R.string.allContact));
        tabLayout.getTabAt(5).setCustomView(convertView5);


    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




}
