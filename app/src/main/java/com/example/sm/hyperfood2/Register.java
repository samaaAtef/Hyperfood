package com.example.sm.hyperfood2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sm.hyperfood2.WebServices.WebServices;
import com.example.sm.hyperfood2.model.MainResponce;
import com.example.sm.hyperfood2.model.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    TextView txtfirstforReg, txtfirstforReg2, txtnotaccforRe;
    @Bind(R.id.firstname)
    EditText fname;
    @Bind(R.id.phone)
    EditText phone;
    @Bind(R.id.secondname)
    EditText sname;
    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.passwordconf)
    EditText passwordconf;
    @Bind(R.id.address)
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "Din next arabic light.otf");
        txtfirstforReg = (TextView) findViewById(R.id.txtfirstforreg);
        txtfirstforReg2 = (TextView) findViewById(R.id.txtfirstforreg2);

        txtnotaccforRe = (TextView) findViewById(R.id.txtnotaccoforReg);

        TextView txt = (TextView) findViewById(R.id.txtREGISTER);
        ImageView imgBack = (ImageView) findViewById(R.id.imgBackforRegister);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        txt.setTypeface(typeface);
        txtfirstforReg.setTypeface(typeface);
        txtfirstforReg2.setTypeface(typeface);
        txtnotaccforRe.setTypeface(typeface);

        fname.setTypeface(typeface);
        sname.setTypeface(typeface);
        email.setTypeface(typeface);
        password.setTypeface(typeface);
        passwordconf.setTypeface(typeface);
        phone.setTypeface(typeface);

        Button register = (Button) findViewById(R.id.bt);
        register.setTypeface(typeface);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final User user = new User();
                user.name = fname.getText().toString() + sname.getText().toString();
                user.email = email.getText().toString();
                user.phone = phone.getText().toString();
                user.address = address.getText().toString();
                user.password = password.getText().toString();
                user.password_confirmation = passwordconf.getText().toString();
                WebServices.getInstance().getApi().registerUser(user).enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                     try {
                         if (response.body().success == 2) {
                             Toast.makeText(Register.this, "2", Toast.LENGTH_SHORT).show();
                         } else if (response.body().success == 1) {
                             Toast.makeText(Register.this, "success", Toast.LENGTH_SHORT).show();
                             Intent gotToLogin = new Intent(Register.this, MainActivity.class);
                             gotToLogin.putExtra("email", user.email);
                             gotToLogin.putExtra("pass", user.password);
                             startActivity(gotToLogin);
                             finish();
                         } else {
                             Toast.makeText(Register.this, "يوجد بيانات خطأ", Toast.LENGTH_SHORT).show();

                         }
                     }catch (Exception e){
                         Toast.makeText(Register.this, "sorry  services stoped :(", Toast.LENGTH_SHORT).show();

                     }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        Toast.makeText(Register.this, "لا يوجد اتصال بالانترنت", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
