package com.example.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView tvout = (TextView) findViewById(R.id.tvOut);
    Button btOk = (Button) findViewById(R.id.btnOk);
    Button btCancel = (Button) findViewById(R.id.btnCancel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }


}
