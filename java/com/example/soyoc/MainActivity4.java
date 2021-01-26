package com.example.soyoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity4 extends AppCompatActivity implements
        View.OnClickListener {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mSignOutButton = findViewById(R.id.sign_out_button);
        TextView fireBaseId = findViewById(R.id.detail);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth!=null) fireBaseId.setText(mAuth.getCurrentUser().getPhoneNumber());
        mSignOutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sign_out_button) {
            mAuth.signOut();
            startActivity(new Intent(MainActivity4.this, MainActivity.class));
            finish();
        }
    }
}
