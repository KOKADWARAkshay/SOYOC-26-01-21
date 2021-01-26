package com.example.soyoc.views2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.soyoc.R;
import com.example.soyoc.models2.MedicineCartItem;
import com.example.soyoc.viewmodels2.MedicineViewModel;

import java.util.List;

public class MedicineActivity extends AppCompatActivity {

    private static final String TAG = "MedicineActivity";
    NavController navController;
    MedicineViewModel medicineViewModel;


    private int medicineCartQuantity = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment2);
        NavigationUI.setupActionBarWithNavController(this,navController);

        medicineViewModel = new ViewModelProvider(this).get(MedicineViewModel.class);
        medicineViewModel.getCart().observe(this, new Observer<List<MedicineCartItem>>() {
            @Override
            public void onChanged(List<MedicineCartItem> medicineCartItems) {
                //  Log.d(TAG,"OnChanged" + medicineCartItems.size());
                int quantity = 0;
                for(MedicineCartItem medicineCartItem: medicineCartItems){
                    quantity += medicineCartItem.getQuantity();

                }
                medicineCartQuantity = quantity;
                invalidateOptionsMenu();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.medicine_menu,menu);
        final MenuItem menuItem = menu.findItem(R.id.medicineCartFragment);
        View MedicineActionView = menuItem.getActionView();

        TextView medicineCartBadgeTextView = MedicineActionView.findViewById(R.id.medicine_cart_badge_text_view);

        medicineCartBadgeTextView.setText(String.valueOf(medicineCartQuantity));
        medicineCartBadgeTextView.setVisibility(medicineCartQuantity ==0 ? View.GONE : View.VISIBLE);
        MedicineActionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);

            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item,navController) || super.onOptionsItemSelected(item);
    }
}
