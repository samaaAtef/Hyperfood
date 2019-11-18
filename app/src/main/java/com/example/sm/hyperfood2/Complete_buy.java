package com.example.sm.hyperfood2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Complete_buy extends AppCompatActivity {
    Button btnshop,btnsure;
    TextView txtMap,txtTimer,selectadd,selectTime,txtSum,txtPrice,txthint,txtsumall,txtnum5,txtnum65,txtnum10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_buy);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.app_bar_for_complete);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
        txtTimer=(TextView) findViewById(R.id.btnTime);
        txtTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                PopActivity pop=new PopActivity();
                pop.show(fragmentTransaction,null);
            }
        });

        btnshop=(Button)findViewById(R.id.btnshopComplete);
        btnshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Complete_buy.this,Section.class);
                startActivity(i);
            }
        });

        txtMap=(TextView) findViewById(R.id.txtMap);
        txtMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Complete_buy.this,Maps.class);
                startActivity(i);
            }
        });
        btnsure=(Button)findViewById(R.id.btnsure);
        selectadd=(TextView)findViewById(R.id.selectadd);
        selectTime=(TextView)findViewById(R.id.selectTime);
        txtSum=(TextView)findViewById(R.id.txtsum);
        txtsumall=(TextView)findViewById(R.id.txtsummall);
        txtnum5=(TextView)findViewById(R.id.txtnum5);
        txtnum10=(TextView)findViewById(R.id.txtnum10);
        txtnum65=(TextView)findViewById(R.id.txtnum65);
        txthint=(TextView)findViewById(R.id.txthint);
        txtPrice=(TextView)findViewById(R.id.txtPrice);

        selectadd.setTypeface(typeface);
        selectTime.setTypeface(typeface);
        txtSum.setTypeface(typeface);
        txtsumall.setTypeface(typeface);
        txtPrice.setTypeface(typeface);
        txthint.setTypeface(typeface);
        txtTimer.setTypeface(typeface);
        txtMap.setTypeface(typeface);
        btnsure.setTypeface(typeface);
        btnshop.setTypeface(typeface);
        txtnum5.setTypeface(typeface);
        txtnum65.setTypeface(typeface);
        txtnum10.setTypeface(typeface);

    }
    public void setDate(String date)
    {
        txtTimer.setText(date);
    }
    public void BackCom(View view) {
        startActivity(new Intent(Complete_buy.this,Salahs.class));
    }

}
