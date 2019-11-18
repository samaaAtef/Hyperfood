package com.example.sm.hyperfood2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgetPassword extends AppCompatActivity {
    TextView txtenter,txtenter2;
    Button btnsend,btncancle;
    EditText ephone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget_password);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
        txtenter=(TextView)findViewById(R.id.txtenter);
        txtenter2=(TextView)findViewById(R.id.txtenter2);
        btnsend=(Button) findViewById(R.id.btnsend);
        btncancle=(Button) findViewById(R.id.btncancle);
        ephone=(EditText)findViewById(R.id.buttonF);

        txtenter.setTypeface(typeface);
        txtenter2.setTypeface(typeface);
        btnsend.setTypeface(typeface);
        btncancle.setTypeface(typeface);
        ephone.setTypeface(typeface);
    }
}
