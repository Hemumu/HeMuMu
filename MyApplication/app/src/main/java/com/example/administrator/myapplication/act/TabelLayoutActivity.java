package com.example.administrator.myapplication.act;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.TestFragment;

import java.util.ArrayList;

public class TabelLayoutActivity extends BaseBackActivity {

    TabLayout mTabLayout;
    ViewPager mViewPage;

    private ArrayList<String> mDatas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_layout);
        initView();
    }
    private void initView() {

        mViewPage =(ViewPager) findViewById(R.id.main_pager);
        mTabLayout =(TabLayout) findViewById(R.id.main_pager_tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("标题栏控件");
        toolbar.setSubtitle("带手势返回");

        mDatas= new ArrayList<String>();

        mDatas.add("全部");
        mDatas.add("微电影");
        mDatas.add("歌曲");
        mDatas.add("音乐");
        mDatas.add("时尚");
        mDatas.add("动漫");
        mDatas.add("标题");
        mDatas.add("视频");
        mDatas.add("新闻");

        assert mTabLayout != null;
        assert mViewPage != null;
        mViewPage.setOffscreenPageLimit(mDatas.size());

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPage.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPage);

    }


    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            Fragment newFragment = new TestFragment();
            return newFragment;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDatas.get(position);
        }
    }
}
