package com.example.soyoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.soyoc.views.MainActivity3;
import com.example.soyoc.views2.MedicineActivity;

public class CategoriesProduct extends AppCompatActivity {
    public void onThen(View view) {
    }
    public void onMed(View view) {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_product);

        Button butGroc = findViewById(R.id.butGroc);

        butGroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoriesProduct.this, MainActivity3.class);

                CategoriesProduct.this.startActivity(intent);

            }
        });

        Button butMed = findViewById(R.id.butMed);

        butMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoriesProduct.this, MedicineActivity.class);

                CategoriesProduct.this.startActivity(intent);

            }
        });
    }






}