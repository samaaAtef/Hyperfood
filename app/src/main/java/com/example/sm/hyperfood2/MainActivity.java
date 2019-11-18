package com.example.sm.hyperfood2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.WebServices.WebServices;
import com.example.sm.hyperfood2.model.LoginResponce;
import com.example.sm.hyperfood2.model.User;
import com.example.sm.hyperfood2.utils.Session;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtforget,txt_register,txtfirst,txtfirst2,txtnoacco,khedma,khedmanum;
    Button btnenter;
    @Bind(R.id.btnphone)EditText Email;
    @Bind(R.id.btnpassword)EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Typeface typeface=Typeface.createFromAsset(getAssets(),"Din next arabic light.otf");
        ButterKnife.bind(this);

        if (getIntent() != null) {
            String etEmail = getIntent().getStringExtra("email");
            String etPassword = getIntent().getStringExtra("pass");
            Email.setText(etEmail);
            Password.setText(etPassword);
        }
        txtfirst=(TextView)findViewById(R.id.txtfirst);
        txtfirst2=(TextView)findViewById(R.id.txtfirst2);
        txtnoacco=(TextView)findViewById(R.id.txtnotacco);
        khedma=(TextView)findViewById(R.id.khedma);
        khedmanum=(TextView)findViewById(R.id.khedmanum);
        btnenter=(Button)findViewById(R.id.btnenter);

        ImageView imageView=(ImageView)findViewById(R.id.imgBackforMain);
        txtforget=(TextView)findViewById(R.id.txtforget);
        txt_register=(TextView)findViewById(R.id.txtRegister);
        txtforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final User user=new User();

                user.email=Email.getText().toString();
                user.password=Password.getText().toString();

                WebServices.getInstance().getApi().loginUser(user).enqueue(new Callback<LoginResponce>() {
                    @Override
                    public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                        try {

                         if (response.body().success == 1) {
                                Session.getinstance(MainActivity.this).LoginUser(user);
                                Intent goToMain = new Intent(MainActivity.this, Section.class);
                                startActivity(goToMain);
                                finish();

                            } else {
                                String s = String.valueOf(response.body().success);
                                Toast.makeText(MainActivity.this, "تاكد من ادخال بيانات صحيحه", Toast.LENGTH_SHORT).show();

                            }
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "sorry  services stoped :(", Toast.LENGTH_SHORT).show();
                        }

                    }


                    @Override
                    public void onFailure(Call<LoginResponce> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "لا يوجد اتصال بالانترنت", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



        txtfirst.setTypeface(typeface);
        txtfirst2.setTypeface(typeface);
        txtforget.setTypeface(typeface);
        txt_register.setTypeface(typeface);
        btnenter.setTypeface(typeface);
        txtnoacco.setTypeface(typeface);
        Email.setTypeface(typeface);
        Password.setTypeface(typeface);
        khedma.setTypeface(typeface);
        khedmanum.setTypeface(typeface);

    }

}
