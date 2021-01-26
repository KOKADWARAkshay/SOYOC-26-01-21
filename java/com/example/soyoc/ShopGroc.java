package com.example.soyoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.soyoc.views.MainActivity3;

public class ShopGroc extends AppCompatActivity {

    ListView listView;
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_groc);

        listView = findViewById(R.id.listview);

        String[] Headline = {"SHRINIWAS OIL SHOWROOM", "SAPTGIRI SUPER MARKET", "YASH GROCERIES", "SRINATH GROCERIES",
                "INDORE GROCERIES", "JK KIRANA SHOP", "JAIN SUPER MARKET", "AMAAN GROCERIES", "INDOREWALE KIRANA MERCHANT",
                "MP KIRANA STORES", "INDORE SUPERMARKET", "NCR GROCERIES", "NAMAN KIRANASTORES",
                "ARYAN KIRANA STORES", "LAXMI GROCERIEWS STORES", "SK KIRANA", "SHRADDHA KIRANA",

        };
        ListAdapter myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Headline);
        listView.setAdapter(myadapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position==0)

                {
                    Intent intent = new Intent(ShopGroc.this, MainActivity3.class);
                    startActivity(intent);
                }

                if (position==1)

                {
                    Intent intent = new Intent(ShopGroc.this,MainActivity3.class);
                    startActivity(intent);
                }

            };
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }
}