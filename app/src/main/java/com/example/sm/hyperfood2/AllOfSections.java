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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.utils.Session;

import java.util.ArrayList;

public class AllOfSections extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView txtallsections,txt_title;
    ListView GV;
    ArrayList<ListItemForAllOfSections> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_of_sections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
        txtallsections=(TextView)findViewById(R.id.txtallsections);
        txtallsections.setTypeface(typeface);

        GV=(ListView)findViewById(R.id.gridview);
        array=new ArrayList<ListItemForAllOfSections>();
        array.add(new ListItemForAllOfSections("الحلويات والتسالى","منتجات الالبان",R.color.pink,R.color.yellow));
        array.add(new ListItemForAllOfSections("الحلويات والتسالى","الفواكه والخضروات",R.color.blue,R.color.green));
        array.add(new ListItemForAllOfSections("الحلويات والتسالى","منتجات الالبان,",R.color.pink,R.color.yellow));
        array.add(new ListItemForAllOfSections("الحلويات والتسالى","منتجات الالبان",R.color.pink,R.color.yellow));
        array.add(new ListItemForAllOfSections("عنايه المنزل","منتجات الالبان",R.color.green,R.color.pink));
        array.add(new ListItemForAllOfSections("الحلويات والتسالى","منتجات الالبان",R.color.green,R.color.yellow));
        AdapterForAllOfSections adapter=new AdapterForAllOfSections(array);
        GV.setAdapter(adapter);


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
    public void BtnSearch(View v)
    { Intent i=new Intent(AllOfSections.this,SearchResult.class);
        startActivity(i);}



    public void logoHome(View view) {
        startActivity(new Intent(AllOfSections.this,Section.class));
    }

    public void MenuHome(View view){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i=new Intent(AllOfSections.this,Section.class);
            startActivity(i);
        } else if (id == R.id.id_myaccont) {
            Intent i=new Intent(AllOfSections.this,MyAccount.class);
            startActivity(i);

        } else if (id == R.id.salahShopping) {
            Intent i=new Intent(AllOfSections.this,Salahs.class);
            startActivity(i);

        } else if (id == R.id.SectionsMenu) {
            Intent i=new Intent(AllOfSections.this,AllOfSections.class);
            startActivity(i);
        }else if (id == R.id.exit)
        {
            try {
                if (Session.getinstance(this).isUserLoggedIn()) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(AllOfSections.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("هل انت متاكد من تسجيل الخروج ؟");
                    alertDialog.setPositiveButton("تسجيل الخروج", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Session.getinstance(AllOfSections.this).logoutAndGoToLogin(AllOfSections.this);
                        }
                    });
                    alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                } else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(AllOfSections.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("لا بد من تسجيل الدخول اولا !");
                    alertDialog.setPositiveButton("تسجيل ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(AllOfSections.this, MainActivity.class));
                        }
                    });
                    alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                }
            }catch (Exception e){
                Toast.makeText(AllOfSections.this, "sorry  services stoped :(", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class AdapterForAllOfSections extends BaseAdapter {

        ArrayList<ListItemForAllOfSections> arrayList;

        public AdapterForAllOfSections(ArrayList<ListItemForAllOfSections> items) {
            this.arrayList = items;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            Typeface typeface = Typeface.createFromAsset(getAssets(), "Din next arabic light.otf");
            View view1 = layoutInflater.inflate(R.layout.customforallofsections, null);
            TextView btnA1 = (TextView) view1.findViewById(R.id.btnA1);
            TextView btnA2 = (TextView) view1.findViewById(R.id.btnA2);

            btnA1.setBackgroundResource(arrayList.get(i).color1);
            btnA2.setBackgroundResource(arrayList.get(i).color2);
            btnA1.setText(arrayList.get(i).btnA1);
            btnA2.setText(arrayList.get(i).btnA2);
            //     btnA1.setBackgroundColor(arrayList.get(i).color1);
            //   btnA2.setBackgroundColor(arrayList.get(i).color2);

            btnA1.setTypeface(typeface);
            btnA2.setTypeface(typeface);

            return view1;
        }


    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(),  "din-next-bold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeface("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

}
