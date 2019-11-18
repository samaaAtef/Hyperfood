package com.example.sm.hyperfood2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.SubMenu;
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
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sm.hyperfood2.utils.Session;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView txtgebna, txtresultsearch;
    GridView list;
    ArrayList<ListItem> Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Din next arabic light.otf");
        txtgebna = (TextView) findViewById(R.id.txtgebna);
        txtresultsearch = (TextView) findViewById(R.id.txtresultsearch);
        txtgebna.setTypeface(typeface);
        txtresultsearch.setTypeface(typeface);

        list = (GridView) findViewById(R.id.listfor_result_search);
        Items = new ArrayList<ListItem>();

        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));
        Items.add(new ListItem("افندى", "ريال", "كيلو", "1", "14.00", R.drawable.images_search));


        MyAdapter myAdapter = new MyAdapter(Items);
        list.setAdapter(myAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void logoHome(View view) {
        startActivity(new Intent(SearchResult.this, Section.class));
    }

    public void MenuHome(View view) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);

        }
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

    public void BtnSearch(View v) {
        Intent i = new Intent(SearchResult.this, SearchResult.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_result, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(SearchResult.this, Section.class);
            startActivity(i);
        } else if (id == R.id.id_myaccont) {
            Intent i = new Intent(SearchResult.this, MyAccount.class);
            startActivity(i);

        } else if (id == R.id.salahShopping) {
            Intent i = new Intent(SearchResult.this, Salahs.class);
            startActivity(i);

        } else if (id == R.id.SectionsMenu) {
            Intent i = new Intent(SearchResult.this, AllOfSections.class);
            startActivity(i);
        } else if (id == R.id.exit) {
            if (Session.getinstance(this).isUserLoggedIn()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchResult.this);
                alertDialog.setTitle("");
                alertDialog.setMessage("هل انت متاكد من تسجيل الخروج ؟");
                alertDialog.setPositiveButton("تسجيل الخروج", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Session.getinstance(SearchResult.this).logoutAndGoToLogin(SearchResult.this);
                    }
                });
                alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
            } else {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchResult.this);
                alertDialog.setTitle("");
                alertDialog.setMessage("لا بد من تسجيل الدخول اولا !");
                alertDialog.setPositiveButton("تسجيل ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(SearchResult.this, MainActivity.class));
                    }
                });
                alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();

            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
        public class MyAdapter extends BaseAdapter {
            ArrayList<ListItem> arrayList;

            public MyAdapter(ArrayList<ListItem> items) {
                this.arrayList=items;
            }

            @Override
            public int getCount() {
                return   arrayList.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view1=layoutInflater.inflate(R.layout.custom2,null);
                TextView afandy=(TextView)view1.findViewById(R.id.afandyc);
                TextView one=(TextView)view1.findViewById(R.id.onec);
                TextView kilo=(TextView)view1.findViewById(R.id.kiloc);
                TextView ryal=(TextView)view1.findViewById(R.id.ryalc);
                TextView four=(TextView)view1.findViewById(R.id.fourc);
                ImageView img=(ImageView)view1.findViewById(R.id.img1c);
                afandy.setText(arrayList.get(i).afandy);
                one.setText(arrayList.get(i).one);
                kilo.setText(arrayList.get(i).kilo);
                four.setText(arrayList.get(i).four);
                ryal.setText(arrayList.get(i).ryal);
                img.setImageResource(arrayList.get(i).img);

                Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");


                afandy.setTypeface(typeface);
                one.setTypeface(typeface);
                kilo.setTypeface(typeface);
                four.setTypeface(typeface);
                ryal.setTypeface(typeface);

                return view1;
            }
        }
        public class ListItem
        {
            String  afandy,ryal,kilo,one,four;
            int img;
            ListItem(String afandy,String ryal,String kilo,String one,String four,int img){

                this.afandy=afandy;
                this.ryal=ryal;
                this.kilo=kilo;
                this.one=one;
                this.img=img;
            }

        }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(),  "din-next-bold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeface("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }
    }