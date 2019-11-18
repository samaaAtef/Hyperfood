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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sm.hyperfood2.utils.Session;

import java.util.ArrayList;

public class Salahs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<ListItem> Items;
    MyAdapter myAdapterForSalah;

    ListView listforsalah;
    TextView txtsalah,txtTAzeg,txtRyal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salhas);

        Intent i=getIntent();
        Items=new ArrayList<ListItem>();
        Items.add(new ListItem(i.getStringExtra("quoi"),i.getStringExtra("cost"),i.getStringExtra("View"),i.getStringExtra("one"),R.drawable.image_cart));
        Items.add(new ListItem("افندى","14.00","3","1",R.drawable.image_cart));
        Items.add(new ListItem("افندى","14.00","3","1",R.drawable.image_cart));
        Items.add(new ListItem("افندى","14.00","3","1",R.drawable.image_cart));

        listforsalah=(ListView)findViewById(R.id.recyclerforSalah);
        // listforsalah.setLayoutManager(new LinearLayoutManager(this));

        myAdapterForSalah=new MyAdapter(Items);
        listforsalah.setAdapter(myAdapterForSalah);

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navView.getMenu();
        for (int k=0;k<m.size();k++) {
            MenuItem mi = m.getItem(k);

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
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);



        Button complete=(Button)findViewById(R.id.BtnCompleteBuy);
        Button shop=(Button)findViewById(R.id.BtnBackShope);
        txtsalah=(TextView)findViewById(R.id.txtsalah);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Salahs.this,Complete_buy.class);
                startActivity(i);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Salahs.this,Section.class);
                startActivity(i);
            }
        });

    /*    LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.custom_menu,null);
        txt_title=(TextView)view1.findViewById(R.id.txt_title);*/


        txtsalah.setTypeface(typeface);
        complete.setTypeface(typeface);
        shop.setTypeface(typeface);

    }
    public void logoHome(View view) {
        startActivity(new Intent(Salahs.this,Section.class));
    }

    public void MenuHome(View view){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);

        }
    }

    public void BtnSearch(View v)
    { Intent i=new Intent(Salahs.this,SearchResult.class);
        startActivity(i);}
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i=new Intent(Salahs.this,Section.class);
            startActivity(i);
        } else if (id == R.id.id_myaccont) {
            Intent i=new Intent(Salahs.this,MyAccount.class);
            startActivity(i);

        } else if (id == R.id.salahShopping) {
            Intent i=new Intent(Salahs.this,Salahs.class);
            startActivity(i);

        } else if (id == R.id.SectionsMenu) {
            Intent i=new Intent(Salahs.this,AllOfSections.class);
            startActivity(i);
        }else if (id == R.id.exit)
        {
            if(Session.getinstance(this).isUserLoggedIn()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Salahs.this);
                alertDialog.setTitle("");
                alertDialog.setMessage("هل انت متاكد من تسجيل الخروج ؟");
                alertDialog.setPositiveButton("تسجيل الخروج", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Session.getinstance(Salahs.this).logoutAndGoToLogin(Salahs.this);
                    }
                });
                alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
            }
            else {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Salahs.this);
                alertDialog.setTitle("");
                alertDialog.setMessage("لا بد من تسجيل الدخول اولا !");
                alertDialog.setPositiveButton("تسجيل ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Salahs.this,MainActivity.class));
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
            Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
            View view1 = layoutInflater.inflate(R.layout.customforsalah, null);
            TextView txtafandy=(TextView)view1.findViewById(R.id.afandyforsalh);
            TextView txtcount=(TextView)view1.findViewById(R.id.count);
            TextView txtcost=(TextView)view1.findViewById(R.id.cost);
            TextView txtkilo=(TextView)view1.findViewById(R.id.kiloforsalh);
            txtTAzeg=(TextView)view1.findViewById(R.id.TAZEGSForSalah);
            txtRyal=(TextView)view1.findViewById(R.id.RYALS);
            ImageView img=(ImageView)view1.findViewById(R.id.imgforsalah);
            txtafandy.setText(arrayList.get(i).afandy);
            txtcount.setText(arrayList.get(i).one);
            txtcost.setText(arrayList.get(i).four);
            img.setImageResource(arrayList.get(i).img);
            txtafandy.setTypeface(typeface);
            txtcount.setTypeface(typeface);
            txtcost.setTypeface(typeface);
            txtkilo.setTypeface(typeface);
            txtRyal.setTypeface(typeface);

            return view1;
        }
    }
    public class ListItem {
        String  afandy,one,  four,count;
        int img;

        ListItem( String afandy,String count, String one,String four, int img) {
            this.afandy = afandy;
            this.count=count;
            this.one = one;
            this.four = four;
            this.img = img;
        }
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "din-next-bold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeface("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }
}
