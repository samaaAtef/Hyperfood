package com.example.sm.hyperfood2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.utils.Session;

public class Main2Activity extends AppCompatActivity {
    TextView txtHello, txtHello2;
    Button btnRegister, btnformain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Din next arabic light.otf");
        txtHello = (TextView) findViewById(R.id.txthello);
        txtHello2 = (TextView) findViewById(R.id.txthello2);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnformain = (Button) findViewById(R.id.btnformain);

        txtHello.setTypeface(typeface);
        txtHello2.setTypeface(typeface);
        btnformain.setTypeface(typeface);
        btnRegister.setTypeface(typeface);
    }

    public void btnRegister(View view) {
        try{
        if (Session.getinstance(this).isUserLoggedIn()) {
            Intent i = new Intent(Main2Activity.this, Section.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }catch (Exception e)
        {
            Toast.makeText(Main2Activity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void btn(View view){
        Intent intent=new Intent(Main2Activity.this,Section.class);
        startActivity(intent);
    }
}
