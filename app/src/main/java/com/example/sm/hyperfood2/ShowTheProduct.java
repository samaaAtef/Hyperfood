package com.example.sm.hyperfood2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShowTheProduct extends AppCompatActivity {
    Button btnAddToSalah,btnminus,btnmore,btnrate;
    TextView txtview,txtquoi,kiloforsalh,oneforsalh,costforsalah,ryalforsalah,countforsalah,txtrate;
    int vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_the_product);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.app_bar_show_prodct);


        txtquoi=(TextView)findViewById(R.id.txtquoi);
        kiloforsalh=(TextView)findViewById(R.id.kiloforsalh);
        oneforsalh=(TextView)findViewById(R.id.oneforsalh);
        costforsalah=(TextView)findViewById(R.id.costforsalah);
        ryalforsalah=(TextView)findViewById(R.id.ryalforsalah);
        countforsalah=(TextView)findViewById(R.id.countforsalah);
        txtview=(TextView) findViewById(R.id.btnView);
        txtrate=(TextView) findViewById(R.id.txtrate);
        btnrate=(Button) findViewById(R.id.btnrate);

        Intent ifromsection=getIntent();
        txtquoi.setText(ifromsection.getStringExtra("afandy"));
        oneforsalh.setText(ifromsection.getStringExtra("one"));
        costforsalah.setText(ifromsection.getStringExtra("four"));
//FOR SENDING AN Image To Activity
        final ImageView img=(ImageView)findViewById(R.id.imgforshow);
        BitmapDrawable drawable= (BitmapDrawable) img.getDrawable();
        Bitmap bit=drawable.getBitmap();
        final byte []arr=bit.getNinePatchChunk();

        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");

        btnAddToSalah=(Button)findViewById(R.id.btnAddtosalah);
        btnAddToSalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ShowTheProduct.this,Salahs.class);

                i.putExtra("quoi",txtquoi.getText());
                i.putExtra("one",oneforsalh.getText());
                i.putExtra("cost",costforsalah.getText());
                i.putExtra("View",txtview.getText());
                i.putExtra("img",arr);
                startActivity(i);
            }
        });

        btnminus=(Button)findViewById(R.id.btnminus);
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vi= Integer.parseInt(txtview.getText().toString());
                if(vi>0)
                {
                    --vi;
                    String s= String.valueOf(vi);
                    txtview.setText(s);
                }

            }
        });

        btnmore=(Button)findViewById(R.id.btnmore);
        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vi= Integer.parseInt(txtview.getText().toString());

                ++vi;
                String s= String.valueOf(vi);
                txtview.setText(s);

            }
        });
        //txtview,txtquoi,txttazeg,kiloforsalh,oneforsalh,costforsalah,ryalforsalah,countforsalah
        TextView txtapp=(TextView)((getLayoutInflater().inflate(R.layout.app_bar_show_prodct,null)).findViewById(R.id.textOneS));
        txtview.setTypeface(typeface);
        kiloforsalh.setTypeface(typeface);
        oneforsalh.setTypeface(typeface);
        costforsalah.setTypeface(typeface);
        ryalforsalah.setTypeface(typeface);
        countforsalah.setTypeface(typeface);
        btnmore.setTypeface(typeface);
        btnminus.setTypeface(typeface);
        btnrate.setTypeface(typeface);
        txtapp.setTypeface(typeface);
        txtrate.setTypeface(typeface);
    }



    public void Back(View view) {
        startActivity(new Intent(ShowTheProduct.this,Section.class));
    }

    public void RateValue(View view) {
        RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar);
        TextView txtvaluerate = (TextView) findViewById(R.id.txtvaluerate);
        if (ratingBar2.getRating() == 0) {
            Toast.makeText(ShowTheProduct.this, "يجب عليك ادخال تقيم صحيح اولا", Toast.LENGTH_SHORT).show();
        } else {
            ratingBar1.setRating(ratingBar2.getRating());
            txtvaluerate.setText(String.valueOf(ratingBar2.getRating()));
            btnrate.setText("تعديل التقيم");
            Toast.makeText(ShowTheProduct.this, "تم التقيم بنجاح", Toast.LENGTH_SHORT).show();
        }
    }
}

