package com.toys.breakable.lonelybit.bauddhikpatrak;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "हिंदी बौद्धिक पत्रक", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
        switch (id) {
            case R.id.april_16_amrut :
                Logger.getLogger("MainActivity").info("Clicked for Amrutvachan in April 2016");

                View amrutview = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(amrutview);

                TextView amrutTitle = (TextView)findViewById(R.id.parichched_lable_id);
                amrutTitle.setText(R.string.amrut_vachan_text);
                TextView amrutContents = (TextView)findViewById(R.id.parichched_contents);
                amrutContents.setText(R.string.april_2016_amrut);


                break;
            case R.id.april_16_bodhkatha :
                View bodhkathaView = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(bodhkathaView);

                TextView bothkathaTitle = (TextView)findViewById(R.id.parichched_lable_id);
                bothkathaTitle.setText(R.string.bodhkatha_text);
                TextView bodhkathaContents = (TextView)findViewById(R.id.parichched_contents);
                bodhkathaContents.setText(R.string.april_2016_bodhkatha);
                break;
            case R.id.april_16_nirop :

                View niropView = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(niropView);
                break;
            case R.id.april_16_sanghik :

                View sanghikGeetView = layoutInflater.inflate(R.layout.geet_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(sanghikGeetView);
                TextView geetTypeTitle = (TextView)findViewById(R.id.geet_type_lable);
                geetTypeTitle.setText(R.string.sanghik_geet_text);

                TextView geetTitle = (TextView)findViewById(R.id.geet_title);
                geetTitle.setText(R.string.april_2016_sanghik_geet_title);

                TextView sanghikGeetContents = (TextView)findViewById(R.id.geet_contents);
                sanghikGeetContents.setText(R.string.april_2016_sanghik_geet);
                break;

            case R.id.april_16_vaiyaktik :

                View vaiyaktikGeetView = layoutInflater.inflate(R.layout.geet_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(vaiyaktikGeetView);


                TextView geetTypeTitle1 = (TextView)findViewById(R.id.geet_type_lable);
                geetTypeTitle1.setText(R.string.vaiyaktik_geet_text);

                TextView geetTitle1 = (TextView)findViewById(R.id.geet_title);
                geetTitle1.setText(R.string.april_2016_vaiyaktik_geet_title);

                TextView vGeetContents = (TextView)findViewById(R.id.geet_contents);
                vGeetContents.setText(R.string.april_2016_vaiyaktik_geet);
                break;
            case R.id.april_16_subhashit :
                View subhashittView = layoutInflater.inflate(R.layout.subhashit_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(subhashittView);

                TextView subhashit = (TextView)findViewById(R.id.subhashit_text_id);
                subhashit.setText(R.string.april_2016_subhshit);

                TextView subhashitArth = (TextView)findViewById(R.id.subhashit_arth_contents_id);
                subhashitArth.setText(R.string.april_2016_subhshit_arth);
                break;
            case R.id.mukhya_paan :

                View view = layoutInflater.inflate(R.layout.mukhya_paan_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(view);
                //TextView dynamicContentsView1 = (TextView) findViewById(R.id.dynamic_contents);
                //dynamicContentsView1.setText(R.string.mukhya_paan_mahiti);
                TextView mukyaPaanTitle = (TextView)findViewById(R.id.mukya_paan_title_id);
                mukyaPaanTitle.setText(R.string.mukhya_paan_mahiti_title);

                TextView mukyaPaanSubTitle = (TextView)findViewById(R.id.mukya_paan_subtitle_id);
                mukyaPaanSubTitle.setText(R.string.mukhya_paan_mahiti_subtitle);

                TextView mukyaPaanContents = (TextView)findViewById(R.id.mukya_paan_contents_id);
                mukyaPaanContents.setText(R.string.mukhya_paan_mahiti_contents);
                break;
            default:


        }

        /*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else*/
        if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
