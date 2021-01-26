//Jai Siya Ram
package com.example.soyoc;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public void onOtp(View view) {
    }

    public void onLog(View view) {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonnm = findViewById(R.id.buttonm);

        buttonnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, FrontActivity.class);

                MainActivity.this.startActivity(intent);

            }
        });


        Button butOTP = findViewById(R.id.butOTP);

        butOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,GoogleLogIn.class);

                MainActivity.this.startActivity(intent);

            }
        });
        Button butLog = findViewById(R.id.butLog);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, GoogleLogIn.class);

                MainActivity.this.startActivity(intent);

            }
        });

    }


    }



