package com.example.doannv.lab2_andorid_net;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private String user,pass,name,chao;
    Button btnExit;
    TextView tvchao,tvthucdon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GetTask getTask = new GetTask();
        getTask.execute("http://dotplays.com/android/bai1.php?food=today");
        btnExit = findViewById(R.id.btnExit);
        tvchao = findViewById(R.id.tvchao);
        tvthucdon = findViewById(R.id.tvthucdon);
        chao = PostTask.Chao;
        Intent intent = getIntent();
        user = intent.getStringExtra("USER");
        pass = intent.getStringExtra("PASS");
        name = intent.getStringExtra("NAME");
        tvchao.setText(chao+" "+name);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ok = GetTask.ok;
                tvthucdon.setText(ok);
            }
        });
    }
}
