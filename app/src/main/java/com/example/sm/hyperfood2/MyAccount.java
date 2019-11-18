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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.utils.Session;

public class MyAccount extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
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
        TextView myacccount=(TextView)findViewById(R.id.txtmyacco);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
        myacccount.setTypeface(typeface);

        TextView myname=(TextView)findViewById(R.id.txtname);
        myname.setTypeface(typeface);

        TextView myEmail=(TextView)findViewById(R.id.txtemail);
        myEmail.setTypeface(typeface);

        TextView myPhone=(TextView)findViewById(R.id.txtPhone);
        myPhone.setTypeface(typeface);

        TextView myPassword=(TextView)findViewById(R.id.txtpassword);
        myPassword.setTypeface(typeface);
        TextView update1=(TextView)findViewById(R.id.update1);
        update1.setTypeface(typeface);

        update=(ImageView)findViewById(R.id.imgupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MyAccount.this,Update_account.class);
                startActivity(i);
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

    public void logoHome(View view) {
        startActivity(new Intent(MyAccount.this,Section.class));
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
            Intent i=new Intent(MyAccount.this,Section.class);
            startActivity(i);
        } else if (id == R.id.id_myaccont) {
            Intent i=new Intent(MyAccount.this,MyAccount.class);
            startActivity(i);

        } else if (id == R.id.salahShopping) {
            Intent i=new Intent(MyAccount.this,Salahs.class);
            startActivity(i);

        } else if (id == R.id.SectionsMenu) {
            Intent i=new Intent(MyAccount.this,AllOfSections.class);
            startActivity(i);
        }else if (id == R.id.exit)
        {
            try {
                if (Session.getinstance(this).isUserLoggedIn()) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyAccount.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("هل انت متاكد من تسجيل الخروج ؟");
                    alertDialog.setPositiveButton("تسجيل الخروج", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Session.getinstance(MyAccount.this).logoutAndGoToLogin(MyAccount.this);
                        }
                    });
                    alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                } else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyAccount.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("لا بد من تسجيل الدخول اولا !");
                    alertDialog.setPositiveButton("تسجيل ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(MyAccount.this, MainActivity.class));
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
                Toast.makeText(MyAccount.this, "sorry  services stoped :(", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "din-next-bold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeface("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

}
