package com.toys.breakable.lonelybit.bauddhikpatrak;

import android.content.res.Resources;
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
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TabHost tabHost;


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
        int groupId = item.getGroupId();

        switch (groupId) {
            case R.id.common_group :
                handleStaticContents(item);
                break;
            case R.id.april_2016_group :
                //handleApril2016Contents(item);
                handleMonthContents(item);
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
            /*case R.id.patte_suchi_menu :

                handlePatteSuchi(item);
                break;*/
        }
    }


    private void handlePatteSuchi(MenuItem item) {
        int id = item.getItemId();


        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
        RelativeLayout Bhag_karyakarini = (RelativeLayout) findViewById(R.id.bhag_karyakarini_tab);

        View tabbedview = layoutInflater.inflate(R.layout.patte_suchi, mainContentLayout, false);
        mainContentLayout.removeAllViewsInLayout();
        mainContentLayout.addView(tabbedview);

        TabHost host = (TabHost) findViewById(R.id.tabHost_pattesuchi);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("भाग कार्यकारिणी");
        spec.setContent(R.id.bhag_karyakarini_tab);
        renderNagarKaryakarini(layoutInflater, Bhag_karyakarini);


        /*TextView sanghikGeetContents = (TextView) findViewById(R.id.sanghik_geet_txt);
        sanghikGeetContents.setText(sanghik_geet_txt);*/
    }

    /**To create tabbed layout*/
    private void handleMonthContents(MenuItem item){
        int id = item.getItemId();
        String sanghik_geet_txt = "";
        String vkt_geet_txt = "";
        String amrut_vachan_txt = "";
        String subhashit_txt = "";
        //String subhashit_artha_txt = "";
        String bodhkatha_txt = "";
        String vrutta_txt = "";
        String karyakram_txt = "";
        String vicharmanthan_txt = "";
        switch (id) {
            case R.id.april_16:
                sanghik_geet_txt = getResources().getString(R.string.april_2016_sanghik_geet);
                vkt_geet_txt = getResources().getString(R.string.april_2016_vaiyaktik_geet);
                amrut_vachan_txt = getResources().getString(R.string.april_2016_amrut);
                subhashit_txt = getResources().getString(R.string.april_2016_subhshit);
                //subhashit_artha_txt = getResources().getString(R.string.april_2016_subhshit_arth);
                bodhkatha_txt = getResources().getString(R.string.april_2016_bodhkatha);
                vrutta_txt = getResources().getString(R.string.april_2016_nirop);
                karyakram_txt = getResources().getString(R.string.april_2016_karyakram);
                vicharmanthan_txt = getResources().getString(R.string.home_page_txt);
                updateMainPageTitle(R.string.april_2016);

                break;
            case R.id.may_16:
                sanghik_geet_txt = getResources().getString(R.string.may_2016_sanghik_geet);
                vkt_geet_txt = getResources().getString(R.string.may_2016_vaiyaktik_geet);
                amrut_vachan_txt = getResources().getString(R.string.may_2016_amrut);
                subhashit_txt = getResources().getString(R.string.may_2016_subhshit);
                //subhashit_artha_txt = getResources().getString(R.string.may_2016_subhshit_arth);
                bodhkatha_txt = getResources().getString(R.string.may_2016_bodhkatha);
                vrutta_txt = getResources().getString(R.string.may_2016_nirop);
                karyakram_txt = getResources().getString(R.string.may_2016_karyakram);
                vicharmanthan_txt = getResources().getString(R.string.home_page_txt);
                updateMainPageTitle(R.string.may_2016);

                break;
            default:
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);

        View tabbedview = layoutInflater.inflate(R.layout.tabbed_april16, mainContentLayout, false);
        mainContentLayout.removeAllViewsInLayout();
        mainContentLayout.addView(tabbedview);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("सांघिक गीत");
        spec.setContent(R.id.sanghik_geet_tab);
        TextView sanghikGeetContents = (TextView)findViewById(R.id.sanghik_geet_txt);
        sanghikGeetContents.setText(sanghik_geet_txt);

        spec.setIndicator("सांघिक गीत");
        host.addTab(spec);


        //Tab 2
        spec = host.newTabSpec("वैयक्तिक गीत");
        spec.setContent(R.id.vaiyaktik_geet_tab);
        TextView vGeetContents = (TextView)findViewById(R.id.vaiyaktik_geet_txt);
        vGeetContents.setText(vkt_geet_txt);
        spec.setIndicator("वैयक्तिक गीत");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("सुभाषित");
        spec.setContent(R.id.subhashit_tab);
        TextView vSubhashitContents = (TextView)findViewById(R.id.subhashit_txt);
        vSubhashitContents.setText(subhashit_txt);

        spec.setIndicator("सुभाषित");
        host.addTab(spec);

        //Tab 5
        spec = host.newTabSpec("अमृत वचन");
        spec.setContent(R.id.amrut_tab);
        TextView vAmrutContents = (TextView)findViewById(R.id.amrut_txt);
        vAmrutContents.setText(amrut_vachan_txt);
        spec.setIndicator("अमृत वचन");
        host.addTab(spec);

        //Tab 6
        spec = host.newTabSpec("बोधकथा");
        spec.setContent(R.id.bodhkatha_tab);
        TextView vBodhContents = (TextView)findViewById(R.id.bodhkatha_txt);
        vBodhContents.setText(bodhkatha_txt);
        spec.setIndicator("बोधकथा");
        host.addTab(spec);

        //Tab 7
        spec = host.newTabSpec("वृत्त");
        spec.setContent(R.id.vrutta_tab);
        TextView vVruttaContents = (TextView)findViewById(R.id.vrutta_txt);
        vVruttaContents.setText(vrutta_txt);
        spec.setIndicator("वृत्त");
        host.addTab(spec);

        //Tab 8
        spec = host.newTabSpec("आगामी कार्यक्रम");
        spec.setContent(R.id.karyakram_tab);
        TextView vKaryakramContents = (TextView)findViewById(R.id.karyakram_txt);
        vKaryakramContents.setText(karyakram_txt);
        spec.setIndicator("आगामी कार्यक्रम ");
        host.addTab(spec);

        //Tab 8
        spec = host.newTabSpec("मंथन");
        spec.setContent(R.id.vicharmanthan_tab);
        TextView vManthanContents = (TextView)findViewById(R.id.vicharmanthan_txt);
        vManthanContents.setText(vicharmanthan_txt);
        spec.setIndicator("मंथन");
        host.addTab(spec);
    }

    /**
     * April 2016 Content Rendering method
     *
     * @param item
     */
    private void handleApril2016Contents(MenuItem item) {
        int id = item.getItemId();
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
/*        switch (id) {

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


        }*/
    }

    private void renderNagarKaryakarini(LayoutInflater layoutInflater,
                                        RelativeLayout mainContentLayout) {

        View view = layoutInflater.inflate(R.layout.karyakarini_layout,
                mainContentLayout, false);
        mainContentLayout.removeAllViewsInLayout();
        mainContentLayout.addView(view);
        ListView listView = (ListView) view.findViewById(R.id.karyakariniListView);

        List<Karyakarta> karyakartas = new ArrayList<>();

        Resources res = getResources();
        updateMainPageTitle(R.string.nagar_karyakarini_text);

        /*Vivekanand Nagar start*/
        Karyakarta vivekaandnagar = new Karyakarta("",res.getString(R.string.vivekanand_nagar_text),"","","");
        karyakartas.add(vivekaandnagar);

        Karyakarta vivekkaryavah = new Karyakarta("", res.getString(R.string.vivek_karyavah_name),
                res.getString(R.string.vivek_karyavah_number), res.getString(R.string.vivek_karyavah_email),
                res.getString(R.string.nagar_karyavaah));
        karyakartas.add(vivekkaryavah);

        Karyakarta viveksahkar = new Karyakarta("", res.getString(R.string.vivek_sahkar_name),
                res.getString(R.string.vivek_sahkar_number), res.getString(R.string.vivek_sahkar_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(viveksahkar);

        Karyakarta viveksahkar1 = new Karyakarta("", res.getString(R.string.vivek_sahkar1_name),
                res.getString(R.string.vivek_sahkar1_number), res.getString(R.string.vivek_sahkar1_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(viveksahkar1);

        Karyakarta vivekshashi = new Karyakarta("", res.getString(R.string.vivek_sahshi_name),
                res.getString(R.string.vivek_sahshi_number), res.getString(R.string.vivek_sahshi_email),
                res.getString(R.string.nagar_sha_shi_pra));
        karyakartas.add(vivekshashi);

        Karyakarta vivekboupra = new Karyakarta("", res.getString(R.string.vivek_boupra_name),
                res.getString(R.string.vivek_boupra_number), res.getString(R.string.vivek_boupra_email),
                res.getString(R.string.nagar_bauddhik_pra));
        karyakartas.add(vivekboupra);

        Karyakarta vivekvyavastha = new Karyakarta("", res.getString(R.string.vivek_vyavastha_name),
                res.getString(R.string.vivek_vyavastha_number), res.getString(R.string.vivek_vyavastha_email),
                res.getString(R.string.nagar_vyavastha_pra));
        karyakartas.add(vivekvyavastha);

        Karyakarta viveksahvyavastha = new Karyakarta("", res.getString(R.string.vivek_sah_vyavastha_name),
                res.getString(R.string.vivek_sah_vyavastha_number), res.getString(R.string.vivek_sah_vyavastha_email),
                res.getString(R.string.nagar_sah_vyavastha_pra));
        karyakartas.add(viveksahvyavastha);

        Karyakarta vivekmahav = new Karyakarta("", res.getString(R.string.vivek_mahav_name),
                res.getString(R.string.vivek_mahav_number), res.getString(R.string.vivek_mahav_email),
                res.getString(R.string.nagar_maha_vid_pra));
        karyakartas.add(vivekmahav);

        Karyakarta viveksamparka = new Karyakarta("", res.getString(R.string.vivek_samparka_name),
                res.getString(R.string.vivek_samparka_number), res.getString(R.string.vivek_samparka_email),
                res.getString(R.string.nagar_sampark_pra));
        karyakartas.add(viveksamparka);

        Karyakarta vivekseva = new Karyakarta("", res.getString(R.string.vivek_seva_name),
                res.getString(R.string.vivek_seva_number), res.getString(R.string.vivek_seva_email),
                res.getString(R.string.nagar_seva_shikshan_pra));
        karyakartas.add(vivekseva);

        Karyakarta vivekdharma = new Karyakarta("", res.getString(R.string.vivek_dharma_name),
                res.getString(R.string.vivek_dharma_number), res.getString(R.string.vivek_dharma_email),
                res.getString(R.string.nagar_dharmajagaran_pra));
        karyakartas.add(vivekdharma);

        Karyakarta viveksahdharma = new Karyakarta("", res.getString(R.string.vivek_sah_dharma_name),
                res.getString(R.string.vivek_sah_dharma_number), res.getString(R.string.vivek_sah_dharma_email),
                res.getString(R.string.nagar_sah_dharmajagaran_pra));
        karyakartas.add(viveksahdharma);

        Karyakarta vivekghosh = new Karyakarta("", res.getString(R.string.vivek_ghosh_name),
                res.getString(R.string.vivek_ghosh_number), res.getString(R.string.vivek_ghosh_email),
                res.getString(R.string.nagar_ghosh_pra));
        karyakartas.add(vivekghosh);

        /*Vivekanand Nagar End*/

        /*Vitthalwadi Nagar start*/

        Karyakarta vitthalwadinagar = new Karyakarta("",res.getString(R.string.viththalwadi_nagar_text),"","","");
        karyakartas.add(vitthalwadinagar);

        Karyakarta vitthsanghachalak = new Karyakarta("", res.getString(R.string.vitth_sangha_name),
                res.getString(R.string.vitth_sangha_number), res.getString(R.string.vitth_sangha_email),
                res.getString(R.string.nagar_sanghachalak));
        karyakartas.add(vitthsanghachalak);

        Karyakarta vitthkaryavah = new Karyakarta("", res.getString(R.string.vitth_karyavah_name),
                res.getString(R.string.vitth_karyavah_number), res.getString(R.string.vitth_karyavah_email),
                res.getString(R.string.nagar_karyavaah));
        karyakartas.add(vitthkaryavah);


        Karyakarta vitthsahkar = new Karyakarta("", res.getString(R.string.vitth_sahkar_name),
                res.getString(R.string.vitth_sahkar_number), res.getString(R.string.vitth_sahkar_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(vitthsahkar);

        Karyakarta vitthsahkar1 = new Karyakarta("", res.getString(R.string.vitth_sahkar1_name),
                res.getString(R.string.vitth_sahkar1_number), res.getString(R.string.vitth_sahkar1_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(vitthsahkar1);

        Karyakarta vitthshashi = new Karyakarta("", res.getString(R.string.vitth_sahshi_name),
                res.getString(R.string.vitth_sahshi_number), res.getString(R.string.vitth_sahshi_email),
                res.getString(R.string.nagar_sha_shi_pra));
        karyakartas.add(vitthshashi);

        Karyakarta vitthboupra = new Karyakarta("", res.getString(R.string.vitth_boupra_name),
                res.getString(R.string.vitth_boupra_number), res.getString(R.string.vitth_boupra_email),
                res.getString(R.string.nagar_bauddhik_pra));
        karyakartas.add(vitthboupra);

        Karyakarta vitthvyavastha = new Karyakarta("", res.getString(R.string.vitth_vyavastha_name),
                res.getString(R.string.vitth_vyavastha_number), res.getString(R.string.vitth_vyavastha_email),
                res.getString(R.string.nagar_vyavastha_pra));
        karyakartas.add(vitthvyavastha);

        Karyakarta vitthmahav = new Karyakarta("", res.getString(R.string.vitth_mahav_name),
                res.getString(R.string.vitth_mahav_number), res.getString(R.string.vitth_mahav_email),
                res.getString(R.string.nagar_maha_vid_pra));
        karyakartas.add(vitthmahav);

        Karyakarta vitthsamparka = new Karyakarta("", res.getString(R.string.vitth_samparka_name),
                res.getString(R.string.vitth_samparka_number), res.getString(R.string.vitth_samparka_email),
                res.getString(R.string.nagar_sampark_pra));
        karyakartas.add(vitthsamparka);

        Karyakarta vitthseva = new Karyakarta("", res.getString(R.string.vitth_seva_name),
                res.getString(R.string.vitth_seva_number), res.getString(R.string.vitth_seva_email),
                res.getString(R.string.nagar_seva_shikshan_pra));
        karyakartas.add(vitthseva);

        Karyakarta vitthprachar = new Karyakarta("", res.getString(R.string.vitth_prachar_name),
                res.getString(R.string.vitth_prachar_number), res.getString(R.string.vitth_prachar_email),
                res.getString(R.string.nagar_prachar_pra));
        karyakartas.add(vitthprachar);

        Karyakarta vitthdharma = new Karyakarta("", res.getString(R.string.vitth_dharma_name),
                res.getString(R.string.vitth_dharma_number), res.getString(R.string.vitth_dharma_email),
                res.getString(R.string.nagar_dharmajagaran_pra));
        karyakartas.add(vitthdharma);

        /*Vitthalwadi Nagar End*/

        /*Wadgaon Nagar Start*/

        Karyakarta wadgaonnagar = new Karyakarta("",res.getString(R.string.vadgaav_nagar_text),"","","");
        karyakartas.add(wadgaonnagar);

        Karyakarta wadkaryavah = new Karyakarta("", res.getString(R.string.wad_karyavah_name),
                res.getString(R.string.wad_karyavah_number), res.getString(R.string.wad_karyavah_email),
                res.getString(R.string.nagar_karyavaah));
        karyakartas.add(wadkaryavah);

        Karyakarta wadsahkar = new Karyakarta("", res.getString(R.string.wad_sahkar_name),
                res.getString(R.string.wad_sahkar_number), res.getString(R.string.wad_sahkar_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(wadsahkar);

         /*Wadgaon Nagar End*/

        /*Dhayaru Nagar start*/

        Karyakarta dhayarinagar = new Karyakarta("",res.getString(R.string.dhayari_nagar_text),"","","");
        karyakartas.add(dhayarinagar);

        Karyakarta dhakaryavah = new Karyakarta("", res.getString(R.string.dha_kar_name),
                res.getString(R.string.dha_kar_number), res.getString(R.string.dha_kar_email),
                res.getString(R.string.nagar_karyavaah));
        karyakartas.add(dhakaryavah);

        Karyakarta dhasahkar = new Karyakarta("", res.getString(R.string.dha_sahkar_name),
                res.getString(R.string.dha_sahkar_number), res.getString(R.string.dha_sahkar_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(dhasahkar);

        /*Dhayaru Nagar End*/

        /*Nanded Nagar start*/

        Karyakarta nandednagar = new Karyakarta("",res.getString(R.string.nanded_nagar_text),"","","");
        karyakartas.add(nandednagar);

        Karyakarta nankaryavah = new Karyakarta("", res.getString(R.string.nad_karyavah_name),
                res.getString(R.string.nad_karyavah_number), res.getString(R.string.nad_karyavah_email),
                res.getString(R.string.nagar_karyavaah));
        karyakartas.add(nankaryavah);

        Karyakarta nansahkar = new Karyakarta("", res.getString(R.string.nad_sahkar_name),
                res.getString(R.string.nad_sahkar_number), res.getString(R.string.nad_sahkar_email),
                res.getString(R.string.nagar_sahkaryavaah));
        karyakartas.add(nansahkar);

        Karyakarta nanshashi = new Karyakarta("", res.getString(R.string.nad_sahshi_name),
                res.getString(R.string.nad_sahshi_number), res.getString(R.string.nad_sahshi_email),
                res.getString(R.string.nagar_sha_shi_pra));
        karyakartas.add(nanshashi);

        Karyakarta nanboupra = new Karyakarta("", res.getString(R.string.nad_boupra_name),
                res.getString(R.string.nad_boupra_number), res.getString(R.string.nad_boupra_email),
                res.getString(R.string.nagar_bauddhik_pra));
        karyakartas.add(nanboupra);

        Karyakarta nanvyavastha = new Karyakarta("", res.getString(R.string.nad_vyavastha_name),
                res.getString(R.string.nad_vyavastha_number), res.getString(R.string.nad_vyavastha_email),
                res.getString(R.string.nagar_vyavastha_pra));
        karyakartas.add(nanvyavastha);

        Karyakarta nanmahav = new Karyakarta("", res.getString(R.string.nad_mahav_name),
                res.getString(R.string.nad_mahav_number), res.getString(R.string.nad_mahav_email),
                res.getString(R.string.nagar_maha_vid_pra));
        karyakartas.add(nanmahav);

        Karyakarta nansamparka = new Karyakarta("", res.getString(R.string.nad_samparka_name),
                res.getString(R.string.nad_samparka_number), res.getString(R.string.nad_samparka_email),
                res.getString(R.string.nagar_sampark_pra));
        karyakartas.add(nansamparka);

        Karyakarta nanseva = new Karyakarta("", res.getString(R.string.nad_seva_name),
                res.getString(R.string.nad_seva_number), res.getString(R.string.nad_seva_email),
                res.getString(R.string.nagar_seva_shikshan_pra));
        karyakartas.add(nanseva);

        Karyakarta nanprachar = new Karyakarta("", res.getString(R.string.nad_prachar_name),
                res.getString(R.string.nad_prachar_number), res.getString(R.string.nad_prachar_email),
                res.getString(R.string.nagar_prachar_pra));
        karyakartas.add(nanprachar);

        Karyakarta nandharma = new Karyakarta("", res.getString(R.string.nad_dharma_name),
                res.getString(R.string.nad_dharma_number), res.getString(R.string.nad_dharma_email),
                res.getString(R.string.nagar_dharmajagaran_pra));
        karyakartas.add(nandharma);

        /*Nanded Nagar End*/

                KaryakartaAdapter karyakartaAdapter = new KaryakartaAdapter(this, 0, karyakartas);

        listView.setAdapter(karyakartaAdapter);

    }

    private void renderBhagKaryakarini(LayoutInflater layoutInflater,
                                       RelativeLayout mainContentLayout) {

        View view = layoutInflater.inflate(R.layout.karyakarini_layout,
                mainContentLayout, false);
        mainContentLayout.removeAllViewsInLayout();
        mainContentLayout.addView(view);
        ListView listView = (ListView) view.findViewById(R.id.karyakariniListView);

        List<Karyakarta> karyakartas = new ArrayList<>();

        updateMainPageTitle(R.string.bhag_karyakarini_text);

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

        Karyakarta bhagShashi = new Karyakarta("", res.getString(R.string.bhag_shashi_name),
                res.getString(R.string.bhag_shashi_number), res.getString(R.string.bhag_shashi_email),
                res.getString(R.string.bhag_sha_shi_pra));
        karyakartas.add(bhagShashi);

        Karyakarta bhagBoupra = new Karyakarta("", res.getString(R.string.bhag_boupra_name),
                res.getString(R.string.bhag_boupra_number), res.getString(R.string.bhag_boupra_email),
                res.getString(R.string.bhag_bauddhik_pra));
        karyakartas.add(bhagBoupra);

        Karyakarta bhagVyavastha = new Karyakarta("", res.getString(R.string.bhag_vyavastha_name),
                res.getString(R.string.bhag_vyavastha_number), res.getString(R.string.bhag_vyavastha_email),
                res.getString(R.string.bhag_vyavastha_pra));
        karyakartas.add(bhagVyavastha);

        Karyakarta bhagKaryalaya = new Karyakarta("", res.getString(R.string.bhag_karyalaya_name),
                res.getString(R.string.bhag_karyalaya_number), res.getString(R.string.bhag_karyalaya_email),
                res.getString(R.string.bhag_karyalay_pra));
        karyakartas.add(bhagKaryalaya);

        Karyakarta bhagMahavidyalaya = new Karyakarta("", res.getString(R.string.bhag_mahavidyalaya_name),
                res.getString(R.string.bhag_mahavidyalaya_number), res.getString(R.string.bhag_mahavidyalaya_email),
                res.getString(R.string.bhag_maha_vid_pra));
        karyakartas.add(bhagMahavidyalaya);

        Karyakarta bhagIT = new Karyakarta("", res.getString(R.string.bhag_it_name),
                res.getString(R.string.bhag_it_number), res.getString(R.string.bhag_it_email),
                res.getString(R.string.bhag_it_vyavsayi_pra));
        karyakartas.add(bhagIT);


        Karyakarta bhagSamparka = new Karyakarta("", res.getString(R.string.bhag_samparka_name),
                res.getString(R.string.bhag_samparka_number), res.getString(R.string.bhag_samparka_email),
                res.getString(R.string.bhag_sampark_pra));
        karyakartas.add(bhagSamparka);

        Karyakarta bhagSeva = new Karyakarta("", res.getString(R.string.bhag_seva_name),
                res.getString(R.string.bhag_seva_number), res.getString(R.string.bhag_seva_email),
                res.getString(R.string.bhag_seva_shikshan_pra));
        karyakartas.add(bhagSeva);

        Karyakarta bhagPrachar = new Karyakarta("", res.getString(R.string.bhag_prachar_name),
                res.getString(R.string.bhag_prachar_number), res.getString(R.string.bhag_prachar_email),
                res.getString(R.string.bhag_prachar_pra));
        karyakartas.add(bhagPrachar);

        Karyakarta bhagDharma = new Karyakarta("", res.getString(R.string.bhag_dharma_name),
                res.getString(R.string.bhag_dharma_number), res.getString(R.string.bhag_dharma_email),
                res.getString(R.string.bhag_dharmajagaran_pra));
        karyakartas.add(bhagDharma);

        Karyakarta bhagSahDharma = new Karyakarta("", res.getString(R.string.bhag_sah_dharma_name),
                res.getString(R.string.bhag_sah_dharma_number), res.getString(R.string.bhag_sah_dharma_email),
                res.getString(R.string.bhag_sah_dharmajagaran_pra));
        karyakartas.add(bhagSahDharma);

        Karyakarta bhagSadasya = new Karyakarta("", res.getString(R.string.bhag_sadasya_name),
                res.getString(R.string.bhag_sadasya_number), res.getString(R.string.bhag_sadasya_email),
                res.getString(R.string.bhag_sadasya1));
        karyakartas.add(bhagSadasya);

        Karyakarta bhagGhosh = new Karyakarta("", res.getString(R.string.bhag_ghosh_name),
                res.getString(R.string.bhag_ghosh_number), res.getString(R.string.bhag_ghosh_email),
                res.getString(R.string.bhag_ghosh_pra));
        karyakartas.add(bhagGhosh);

        Karyakarta bhagKutumba = new Karyakarta("", res.getString(R.string.bhag_kutumba_name),
                res.getString(R.string.bhag_kutumba_number), res.getString(R.string.bhag_kutumba_email),
                res.getString(R.string.bhag_kutumb_prabodhan_pra));
        karyakartas.add(bhagKutumba);

        Karyakarta bhagGram = new Karyakarta("", res.getString(R.string.bhag_gram_name),
                res.getString(R.string.bhag_gram_number), res.getString(R.string.bhag_gram_email),
                res.getString(R.string.bhag_gramvikas_pra));
        karyakartas.add(bhagGram);

        Karyakarta bhagGouseva = new Karyakarta("", res.getString(R.string.bhag_gouseva_name),
                res.getString(R.string.bhag_gouseva_number), res.getString(R.string.bhag_gouseva_email),
                res.getString(R.string.bhag_go_seva_pra));
        karyakartas.add(bhagGouseva);

        Karyakarta bhagSamarasata = new Karyakarta("", res.getString(R.string.bhag_samarasata_name),
                res.getString(R.string.bhag_samarasata_number), res.getString(R.string.bhag_samarasata_email),
                res.getString(R.string.bhag_samarasata_pra));
        karyakartas.add(bhagSamarasata);

        KaryakartaAdapter karyakartaAdapter = new KaryakartaAdapter(this, 0, karyakartas);

        listView.setAdapter(karyakartaAdapter);
    }

    /**
     * May 2016 Content Rendering method
     *
     * @param item
     */
    private void handleMay2016Contents(MenuItem item) {
        int id = item.getItemId();
        LayoutInflater layoutInflater = getLayoutInflater();
        RelativeLayout mainContentLayout = (RelativeLayout) findViewById(R.id.main_content_layout);
        /*switch (id) {
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


        }*/
    }

    private void renderMukhyaPaan(LayoutInflater layoutInflater, RelativeLayout mainContentLayout) {
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

        updateMainPageTitle(R.string.shakha_pustika_text);
    }

    private void updateMainPageTitle(int mainPageTitleText) {
        //TextView mainPageTitle = (TextView) findViewById(R.id.main_page_title);
        //mainPageTitle.setText(mainPageTitleText);
        getSupportActionBar().setTitle(getResources().getString(mainPageTitleText));
    }
}
