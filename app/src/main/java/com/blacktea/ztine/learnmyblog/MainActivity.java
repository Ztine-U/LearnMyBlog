package com.blacktea.ztine.learnmyblog;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTooolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    private void initView()
    {
        mTooolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawer);
        mTabLayout = (TabLayout) findViewById(R.id.tl_main_tabs);
        mNavigationView = (NavigationView) findViewById(R.id.nv_main_menu);
        mViewPager = (ViewPager) findViewById(R.id.vp_main_content);
        initToolBar();
        initMainContent();
        initAction();
    }

    private void initAction()
    {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        mViewPager.setCurrentItem(0);
                        break;

                }
                mDrawerLayout.closeDrawers();
                return false;

            }
        });
    }

    private void initMainContent() {
        ViewPagerAdapter adapter =  new ViewPagerAdapter(getSupportFragmentManager());
        Fragment homeFrament = new HomeFragment();
        Fragment bestFrament = new BestFragment();
        Fragment candidateFrament = new CandidateFragment();
        Fragment recommendFrament = new RecommendFragment();

        adapter.addFrament(homeFrament, "首页");
        adapter.addFrament(bestFrament, "精华");
        adapter.addFrament(candidateFrament, "候选");
        adapter.addFrament(recommendFrament, "推荐");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void initToolBar() {
        mTooolbar.setTitle("博客园");
        setSupportActionBar(mTooolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mTooolbar,
                R.string.drawer_open,
                R.string.drawer_close);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer_view, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_setting)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
