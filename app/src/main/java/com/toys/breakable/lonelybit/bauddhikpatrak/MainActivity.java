package com.toys.breakable.lonelybit.bauddhikpatrak;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
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
                Snackbar.make(view, R.string.abhipray, Snackbar.LENGTH_LONG)
                        .setAction(R.string.ithe_kalava_text, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                
                            }
                        }).show();
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
        int groupId = item.getGroupId();
        switch (groupId) {
            case R.id.common_group :
                handleStaticContents(item);
                break;
            case R.id.april_2016_group :
                handleApril2016Contents(item);
                break;
            case R.id.may_2016_group :
                handleMay2016Contents(item);
                break;
        }


        /*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else
        if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void handleStaticContents(MenuItem item) {
        int id = item.getItemId();
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
        switch (id) {
            case R.id.mukhya_paan :

                renderMukhyaPaan(layoutInflater, mainContentLayout);
                break;
            case R.id.bhag_karyakarini_menu :

                renderBhagKaryakarini(layoutInflater, mainContentLayout);
                break;
            case R.id.nagar_karyakarini_menu :

                renderNagarKaryakarini(layoutInflater, mainContentLayout);
                break;
        }
    }

    /**
     * April 2016 Content Rendering method
     *
     * @param item
     */
    private void handleApril2016Contents(MenuItem item) {
        updateMainPageTitle(R.string.april_2016);
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

                TextView niropTitle = (TextView)findViewById(R.id.parichched_lable_id);
                niropTitle.setText(R.string.nirop_vrutta_text);
                TextView niropText = (TextView)findViewById(R.id.parichched_contents);
                niropText.setText(R.string.april_2016_nirop);

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
            default:


        }
    }

    private void renderNagarKaryakarini(LayoutInflater layoutInflater,
                                        RelativeLayout mainContentLayout) {
        // TODO
        updateMainPageTitle(R.string.nagar_karyakarini_text);
    }

    private void renderBhagKaryakarini(LayoutInflater layoutInflater,
                                       RelativeLayout mainContentLayout) {

        updateMainPageTitle(R.string.bhag_karyakarini_text);

        View view = layoutInflater.inflate(R.layout.karyakarini_layout,
                mainContentLayout, false);
        mainContentLayout.removeAllViewsInLayout();
        mainContentLayout.addView(view);
        ListView listView = (ListView) view.findViewById(R.id.karyakariniListView);

        List<Karyakarta> karyakartas = new ArrayList<>();

        Resources res = getResources();

        Karyakarta bhagSanghachalak = new Karyakarta("", res.getString(R.string.bhag_sanghachalak_name),
                res.getString(R.string.bhag_sanghachalak_number), res.getString(R.string.bhag_sanghachalak_email),
                res.getString(R.string.bhag_sanghachalak));
        karyakartas.add(bhagSanghachalak);

        Karyakarta bhagKaryavah = new Karyakarta("", res.getString(R.string.bhag_karyavah_name),
                res.getString(R.string.bhag_karyavah_number), res.getString(R.string.bhag_karyavah_email),
                res.getString(R.string.bhag_karyavaah));
        karyakartas.add(bhagKaryavah);

        Karyakarta bhagSahKaryavah1 = new Karyakarta("", res.getString(R.string.bhag_sah_karyavah1_name),
                res.getString(R.string.bhag_sah_karyavah1_number), res.getString(R.string.bhag_sah_karyavah1_email),
                res.getString(R.string.bhag_sahkaryavaah));
        karyakartas.add(bhagSahKaryavah1);


        Karyakarta bhagSahKaryavah2 = new Karyakarta("", res.getString(R.string.bhag_sah_karyavah2_name),
                res.getString(R.string.bhag_sah_karyavah2_number), res.getString(R.string.bhag_sah_karyavah2_email),
                res.getString(R.string.bhag_sahkaryavaah));
        karyakartas.add(bhagSahKaryavah2);

        Karyakarta bhagShaShiPra = new Karyakarta("", res.getString(R.string.bhag_sha_shi_pra_name),
                res.getString(R.string.bhag_sha_shi_pra_number), res.getString(R.string.bhag_sha_shi_pra_email),
                res.getString(R.string.bhag_sha_shi_pra));
        karyakartas.add(bhagShaShiPra);

        Karyakarta bhagBP = new Karyakarta("", res.getString(R.string.bhag_bauddhik_pra_name),
                res.getString(R.string.bhag_bauddhik_pra_number), res.getString(R.string.bhag_bauddhik_pra_email),
                res.getString(R.string.bhag_bauddhik_pra));
        karyakartas.add(bhagBP);

        Karyakarta bhagVyavasthaPra = new Karyakarta("", res.getString(R.string.bhag_vyavastha_pra_name),
                res.getString(R.string.bhag_vyavastha_pra_number), res.getString(R.string.bhag_vyavastha_pra_email),
                res.getString(R.string.bhag_vyavastha_pra));
        karyakartas.add(bhagVyavasthaPra);

        Karyakarta bhagKaryalayPra = new Karyakarta("", res.getString(R.string.bhag_karyalay_pra_name),
                res.getString(R.string.bhag_karyalay_pra_number), res.getString(R.string.bhag_karyalay_pra_email),
                res.getString(R.string.bhag_karyalay_pra));
        karyakartas.add(bhagKaryalayPra);

        Karyakarta bhagMahaVidyaPra = new Karyakarta("", res.getString(R.string.bhag_maha_vidyarthi_pra_name),
                res.getString(R.string.bhag_maha_vidyarthi_pra_number), res.getString(R.string.bhag_maha_vidyarthi_pra_email),
                res.getString(R.string.bhag_maha_vid_pra));
        karyakartas.add(bhagMahaVidyaPra);

        Karyakarta bhagITVyavsayiPra = new Karyakarta("", res.getString(R.string.bhag_it_vyavsayi_pra_name),
                res.getString(R.string.bhag_it_vyavsayi_pra_number), res.getString(R.string.bhag_it_vyavsayi_pra_email),
                res.getString(R.string.bhag_it_vyavsayi_pra));
        karyakartas.add(bhagITVyavsayiPra);

        Karyakarta bhagSevaPra = new Karyakarta("", res.getString(R.string.bhag_seva_shikshan_pra_name),
                res.getString(R.string.bhag_seva_shikshan_pra_number), res.getString(R.string.bhag_seva_shikshan_pra_email),
                res.getString(R.string.bhag_seva_shikshan_pra));
        karyakartas.add(bhagSevaPra);

        Karyakarta bhagPracharPra = new Karyakarta("", res.getString(R.string.bhag_prachar_pra_name),
                res.getString(R.string.bhag_prachar_pra_number), res.getString(R.string.bhag_prachar_pra_email),
                res.getString(R.string.bhag_prachar_pra));
        karyakartas.add(bhagPracharPra);

        Karyakarta bhagSamparkaPra = new Karyakarta("", res.getString(R.string.bhag_samparka_pra_name),
                res.getString(R.string.bhag_samparka_pra_number), res.getString(R.string.bhag_samparka_pra_email),
                res.getString(R.string.bhag_sampark_pra));
        karyakartas.add(bhagSamparkaPra);

        Karyakarta bhagDharmaPra = new Karyakarta("", res.getString(R.string.bhag_dharmajagaran_pra_name),
                res.getString(R.string.bhag_dharmajagaran_pra_number), res.getString(R.string.bhag_dharmajagaran_pra_email),
                res.getString(R.string.bhag_dharmajagaran_pra));
        karyakartas.add(bhagDharmaPra);

        Karyakarta bhagSahDharmaPra = new Karyakarta("", res.getString(R.string.bhag_sah_dharmajagaran_pra_name),
                res.getString(R.string.bhag_sah_dharmajagaran_pra_number), res.getString(R.string.bhag_sah_dharmajagaran_pra_email),
                res.getString(R.string.bhag_sah_dharmajagaran_pra));
        karyakartas.add(bhagSahDharmaPra);

        Karyakarta bhagGhoshPra = new Karyakarta("", res.getString(R.string.bhag_ghosh_pra_name),
                res.getString(R.string.bhag_ghosh_pra_number), res.getString(R.string.bhag_ghosh_pra_email),
                res.getString(R.string.bhag_ghosh_pra));
        karyakartas.add(bhagGhoshPra);

        Karyakarta bhagKutumbPra = new Karyakarta("", res.getString(R.string.bhag_kutumb_prabodhan_pra_name),
                res.getString(R.string.bhag_kutumb_prabodhan_pra_number), res.getString(R.string.bhag_kutumb_prabodhan_pra_email),
                res.getString(R.string.bhag_kutumb_prabodhan_pra));
        karyakartas.add(bhagKutumbPra);

        Karyakarta bhagGramVikasPra = new Karyakarta("", res.getString(R.string.bhag_gram_vikas_pra_name),
                res.getString(R.string.bhag_gram_vikas_pra_number), res.getString(R.string.bhag_gram_vikas_pra_email),
                res.getString(R.string.bhag_gramvikas_pra));
        karyakartas.add(bhagGramVikasPra);

        Karyakarta bhagGoSevaPra = new Karyakarta("", res.getString(R.string.bhag_goseva_pra_name),
                res.getString(R.string.bhag_goseva_pra_number), res.getString(R.string.bhag_goseva_pra_email),
                res.getString(R.string.bhag_go_seva_pra));
        karyakartas.add(bhagGoSevaPra);

        Karyakarta bhagSamarasataPra = new Karyakarta("", res.getString(R.string.bhag_samarasata_pra_name),
                res.getString(R.string.bhag_samarasata_pra_number), res.getString(R.string.bhag_samarasata_pra_email),
                res.getString(R.string.bhag_samarasata_pra));
        karyakartas.add(bhagSamarasataPra);

        Karyakarta bhagMandalSadasya = new Karyakarta("", res.getString(R.string.bhag_sadasya_pra_name),
                res.getString(R.string.bhag_sadasya_pra_number), res.getString(R.string.bhag_sadasya_pra_email),
                res.getString(R.string.bhag_sadasya1));
        karyakartas.add(bhagMandalSadasya);

        KaryakartaAdapter karyakartaAdapter = new KaryakartaAdapter(this, 0, karyakartas);

        listView.setAdapter(karyakartaAdapter);
    }

    private void updateMainPageTitle(int mainPageTitleText) {
        //TextView mainPageTitle = (TextView) findViewById(R.id.main_page_title);
        //mainPageTitle.setText(mainPageTitleText);
        getSupportActionBar().setTitle(getResources().getString(mainPageTitleText));
    }

    /**
     * May 2016 Content Rendering method
     *
     * @param item
     */
    private void handleMay2016Contents(MenuItem item) {
        updateMainPageTitle(R.string.may_2016);
        int id = item.getItemId();
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
        switch (id) {
            case R.id.may_16_amrut :
                Logger.getLogger("MainActivity").info("Clicked for Amrutvachan in may 2016");

                View amrutview = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(amrutview);

                TextView amrutTitle = (TextView)findViewById(R.id.parichched_lable_id);
                amrutTitle.setText(R.string.amrut_vachan_text);
                TextView amrutContents = (TextView)findViewById(R.id.parichched_contents);
                amrutContents.setText(R.string.may_2016_amrut);


                break;
            case R.id.may_16_bodhkatha :
                View bodhkathaView = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(bodhkathaView);

                TextView bothkathaTitle = (TextView)findViewById(R.id.parichched_lable_id);
                bothkathaTitle.setText(R.string.bodhkatha_text);
                TextView bodhkathaContents = (TextView)findViewById(R.id.parichched_contents);
                bodhkathaContents.setText(R.string.may_2016_bodhkatha);
                break;
            case R.id.may_16_nirop :

                View niropView = layoutInflater.inflate(R.layout.parichched_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(niropView);
                break;
            case R.id.may_16_sanghik :

                View sanghikGeetView = layoutInflater.inflate(R.layout.geet_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(sanghikGeetView);
                TextView geetTypeTitle = (TextView)findViewById(R.id.geet_type_lable);
                geetTypeTitle.setText(R.string.sanghik_geet_text);

                TextView geetTitle = (TextView)findViewById(R.id.geet_title);
                geetTitle.setText(R.string.may_2016_sanghik_geet_title);

                TextView sanghikGeetContents = (TextView)findViewById(R.id.geet_contents);
                sanghikGeetContents.setText(R.string.may_2016_sanghik_geet);
                break;

            case R.id.may_16_vaiyaktik :

                View vaiyaktikGeetView = layoutInflater.inflate(R.layout.geet_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(vaiyaktikGeetView);


                TextView geetTypeTitle1 = (TextView)findViewById(R.id.geet_type_lable);
                geetTypeTitle1.setText(R.string.vaiyaktik_geet_text);

                TextView geetTitle1 = (TextView)findViewById(R.id.geet_title);
                geetTitle1.setText(R.string.may_2016_vaiyaktik_geet_title);

                TextView vGeetContents = (TextView)findViewById(R.id.geet_contents);
                vGeetContents.setText(R.string.may_2016_vaiyaktik_geet);
                break;
            case R.id.may_16_subhashit :
                View subhashittView = layoutInflater.inflate(R.layout.subhashit_layout,
                        mainContentLayout, false);
                mainContentLayout.removeAllViewsInLayout();
                mainContentLayout.addView(subhashittView);

                TextView subhashit = (TextView)findViewById(R.id.subhashit_text_id);
                subhashit.setText(R.string.may_2016_subhshit);

                TextView subhashitArth = (TextView)findViewById(R.id.subhashit_arth_contents_id);
                subhashitArth.setText(R.string.may_2016_subhshit_arth);
                break;
            case R.id.mukhya_paan :

                renderMukhyaPaan(layoutInflater, mainContentLayout);
                break;
            default:


        }
    }

    private void renderMukhyaPaan(LayoutInflater layoutInflater, RelativeLayout mainContentLayout) {

        updateMainPageTitle(R.string.shakha_pustika_text);

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
    }
}
