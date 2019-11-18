package com.example.sm.hyperfood2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.WebServices.WebServices;
import com.example.sm.hyperfood2.model.ListCatogry;
import com.example.sm.hyperfood2.model.ListCatogry6;
import com.example.sm.hyperfood2.utils.Session;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Section extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView list;
    TextView txtmore,txtsections,txt_title;
    ArrayList<ListItem2> Items;

    Button btnfruit,btnmaoud,btnmashrobat,btnmatger;
    TextView one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);



        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");

        list = (GridView) findViewById(R.id.list_section);
        Items = new ArrayList<ListItem2>();
        Items.add(new ListItem2( "تين", "1","14.00",R.drawable.single_cart_image));
        Items.add(new ListItem2( "برتقال", "1","14.00",R.drawable.image_cart));
        Items.add(new ListItem2( "تفاح", "1","14.00",R.drawable.images_home));
        Items.add(new ListItem2( "تين", "1","14.00",R.drawable.single_cart_image));
        Items.add(new ListItem2( "برتقال", "1","14.00",R.drawable.image_cart));
        Items.add(new ListItem2( "تفاح", "1","14.00",R.drawable.images_home));
        Items.add(new ListItem2( "تين", "1","14.00",R.drawable.single_cart_image));
        Items.add(new ListItem2( "برتقال", "1","14.00",R.drawable.image_cart));
        Items.add(new ListItem2( "تفاح", "1","14.00",R.drawable.images_home));

        MyAdapter2 myAdapter = new MyAdapter2(Items);
        list.setAdapter(myAdapter);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setNavigationItemSelectedListener(this);
        Menu m = navigationView.getMenu();
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

        txtmore=(TextView)

                findViewById(R.id.txtMore);

        txtmore.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick (View view){
                                           Intent i = new Intent(Section.this, AllOfSections.class);
                                           startActivity(i);
                                       }
                                   }

        );
        txtsections=(TextView)findViewById(R.id.txtsections);

        btnfruit=(Button) findViewById(R.id.btnveg);
        btnmaoud=(Button) findViewById(R.id.btnmaoud);
        btnmashrobat=(Button) findViewById(R.id.btnmash);
        btnmatger=(Button) findViewById(R.id.btnmakhbos);
        TextView kind=(TextView)findViewById(R.id.kind);
        TextView txtmoresection=(TextView)findViewById(R.id.txtmoresection);

        txtmore.setTypeface(typeface);
        txtmoresection.setTypeface(typeface);
        kind.setTypeface(typeface);
        txtsections.setTypeface(typeface);
        btnfruit.setTypeface(typeface);
        btnmashrobat.setTypeface(typeface);
        btnmatger.setTypeface(typeface);
        btnmaoud.setTypeface(typeface);
    }
    public void Showproductquoi(View view) {
        TextView txtafandy=(TextView)findViewById(R.id.afandyc);
        TextView txtone=(TextView)findViewById(R.id.onec);
        TextView txtfour=(TextView)findViewById(R.id.fourc);
        Intent i = new Intent(Section.this, ShowTheProduct.class);
        i.putExtra("afandy",txtafandy.getText());
        i.putExtra("one",txtone.getText());
        i.putExtra("four",txtfour.getText());
        startActivity(i);
    }


    public void Increase1(View view) {

    }
    

    public void BtnSearch(View v)
    { Intent i=new Intent(Section.this,SearchResult.class);
        startActivity(i);}

    public void logoHome(View view) {
        startActivity(new Intent(Section.this,Section.class));
    }

    public void MenuHome(View view){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);

        }
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "din-next-bold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypeface("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);

    }
    public class MyAdapter2 extends BaseAdapter {
        ArrayList<ListItem2> arrayList;

        public MyAdapter2(ArrayList<ListItem2> items) {
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
            TextView four=(TextView)view1.findViewById(R.id.fourc);
            ImageView img=(ImageView)view1.findViewById(R.id.img1c);
            TextView kilo=(TextView)view1.findViewById(R.id.kiloc);
            TextView ryal=(TextView)view1.findViewById(R.id.ryalc);
            afandy.setText(arrayList.get(i).afandy);
            one.setText(arrayList.get(i).one);
            four.setText(arrayList.get(i).four);
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
        getMenuInflater().inflate(R.menu.section, menu);
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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i=new Intent(Section.this,Section.class);
            startActivity(i);
        } else if (id == R.id.id_myaccont) {
            Intent i=new Intent(Section.this,MyAccount.class);
            startActivity(i);

        } else if (id == R.id.salahShopping) {
            Intent i=new Intent(Section.this,Salahs.class);
            startActivity(i);

        } else if (id == R.id.SectionsMenu) {
            Intent i=new Intent(Section.this,AllOfSections.class);
            startActivity(i);
        }else if (id == R.id.exit)
        {
            try {
                if (Session.getinstance(this).isUserLoggedIn()) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Section.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("هل انت متاكد من تسجيل الخروج ؟");
                    alertDialog.setPositiveButton("تسجيل الخروج", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Session.getinstance(Section.this).logoutAndGoToLogin(Section.this);
                        }
                    });
                    alertDialog.setNegativeButton("رجوع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                } else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Section.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage("لا بد من تسجيل الدخول اولا !");
                    alertDialog.setPositiveButton("تسجيل ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(Section.this, MainActivity.class));
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
                Toast.makeText(Section.this, "sorry  services stoped :(", Toast.LENGTH_SHORT).show();

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class ListItem {
        String  afandy, one,  four;
        int img;

        ListItem( String afandy,  String one, String four, int img ) {
            this.afandy = afandy;
            this.one = one;
            this.four = four;
            this.img = img;
        }
    }

    public class ListItem2
    {
        String  afandy,one,four;
        int img;
        ListItem2(String afandy,String one,String four,int img) {

            this.afandy = afandy;
            this.one = one;
            this.four = four;
            this.img = img;
        }

    }
}
