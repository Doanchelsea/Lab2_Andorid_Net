package com.example.doannv.lab2_andorid_net;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edUsername;
    private TextInputEditText edPassword;
    private TextInputEditText edName;
    private Button btnLogin;
    String ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = (TextInputEditText) findViewById(R.id.edUsername);
        edPassword = (TextInputEditText) findViewById(R.id.edPassword);
        edName = (TextInputEditText) findViewById(R.id.edName);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        PostTask postTask = new PostTask();
        postTask.execute("http://dotplays.com/android/login.php");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String name = edName.getText().toString().trim();
                if (username.equals("admin") && password.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("USER",username);
                    intent.putExtra("PASS",password);
                    intent.putExtra("NAME",name);
                    startActivity(intent);

                }

            }
        });
    }
}
