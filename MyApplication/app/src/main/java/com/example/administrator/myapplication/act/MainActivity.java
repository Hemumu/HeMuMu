package com.example.administrator.myapplication.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.administrator.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("App Title");
        toolbar.setSubtitle("Sub title");
        toolbar.setNavigationIcon(R.drawable.test);

        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        setupDrawerContent(mNavigationView);


        mNavigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    private MenuItem mPreMenuItem;

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (mPreMenuItem != null) mPreMenuItem.setChecked(false);
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        mPreMenuItem = menuItem;
                        int id =menuItem.getItemId();
                        switch (id){
                            case R.id.nav_home: {
                                Intent intent = new Intent(MainActivity.this, GuoDuActivity.class);
                                startActivity(intent);
                            }
                                break;
                            case R.id.nav_messages: {
                                Intent intent = new Intent(MainActivity.this, TabelLayoutActivity.class);
                                startActivity(intent);
                            }
                                break;
                            case R.id.nav_friends:{
                                Intent intent = new Intent(MainActivity.this, CollapsingToolbarActivity.class);
                                startActivity(intent);
                            }
                            break;
                        }

                        return true;
                    }
                });



        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, toolbar,R.string.open, R.string.close );
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

    }



    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener()
                {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true ;
        }
        return super.onOptionsItemSelected(item);
    }




}
