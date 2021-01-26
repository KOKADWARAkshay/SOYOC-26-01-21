package com.example.soyoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FrontActivity extends AppCompatActivity {

    public void onShops(View view) {
    }

    public void onProducts(View view) {
    }

    public void openWhatsapp(View view) {
        String text = "WELCOME TO SOYOC FAMILY!!";// Replace with your message.

        String toNumber = "+919307473197"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
        //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.



        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + text));
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);


        Button buttonShops = findViewById(R.id.buttonShops);

        buttonShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FrontActivity.this, CategoriesShop.class);

                FrontActivity.this.startActivity(intent);

            }
        });

        Button buttonProducts = findViewById(R.id.buttonProducts);

        buttonProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FrontActivity.this, CategoriesShop.class);

                FrontActivity.this.startActivity(intent);

            }
        });
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.frontactivity_menu, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.search_item:
                    // do your code
                    return true;
                case R.id.upload_item:
                    // do your code
                    return true;
                case R.id.copy_item:
                    // do your code
                    return true;
                case R.id.print_item:
                    // do your code
                    return true;
                case R.id.share_item:
                    // do your code
                    return true;
                case R.id.bookmark_item:
                    // do your code
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }


    }
