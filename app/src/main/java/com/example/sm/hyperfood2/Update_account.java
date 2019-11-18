package com.example.sm.hyperfood2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Update_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        getSupportActionBar().hide();
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");

        TextView txtnameU= (TextView)findViewById (R.id.txtnameU);
        TextView txtpassU= (TextView)findViewById (R.id.txtpassU);
        TextView txtemailU= (TextView)findViewById (R.id.txtemailU);
        TextView txtphoneU= (TextView)findViewById (R.id.txtphoneU);
        TextView txtnewpassU= (TextView)findViewById (R.id.txtnewpassU);
        EditText nameU= (EditText)findViewById (R.id.nameU);
        EditText passU= (EditText)findViewById (R.id.passU);
        EditText newpassU= (EditText)findViewById (R.id.newpassU);
        EditText phoneU= (EditText)findViewById (R.id.phoneU);
        EditText emailU= (EditText)findViewById (R.id.emailU);
        Button btnsave= (Button) findViewById (R.id.btnsave);


        txtnameU.setTypeface(typeface);
        txtemailU.setTypeface(typeface);
        txtnewpassU.setTypeface(typeface);
        txtpassU.setTypeface(typeface);
        txtphoneU.setTypeface(typeface);
        nameU.setTypeface(typeface);
        phoneU.setTypeface(typeface);
        newpassU.setTypeface(typeface);
        passU.setTypeface(typeface);
        emailU.setTypeface(typeface);
        btnsave.setTypeface(typeface);
    }
}

