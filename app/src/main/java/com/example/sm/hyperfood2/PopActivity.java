package com.example.sm.hyperfood2;

import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class PopActivity extends DialogFragment implements View.OnClickListener {


    View view;
    TimePicker tp;
    TextView txt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_pop,container,false);
        txt=(TextView)view.findViewById(R.id.txtOk);
        tp=(TimePicker) view.findViewById(R.id.timePicker);
        txt.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        this.dismiss();
        String time= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            time = tp.getHour()+" : "+tp.getMinute();
        }
        Complete_buy complete_buy=(Complete_buy)getActivity();
        complete_buy.setDate(time);
    }
}
