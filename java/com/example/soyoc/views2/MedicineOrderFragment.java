package com.example.soyoc.views2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soyoc.R;
import com.example.soyoc.databinding.FragmentMedicineOrderBinding;
import com.example.soyoc.viewmodels2.MedicineViewModel;

public class MedicineOrderFragment extends Fragment {

    NavController navController;
    FragmentMedicineOrderBinding fragmentMedicineOrderBinding;
    MedicineViewModel medicineViewModel;



    public MedicineOrderFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMedicineOrderBinding = FragmentMedicineOrderBinding.inflate(inflater,container,false);
        return fragmentMedicineOrderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        medicineViewModel = new ViewModelProvider(requireActivity()).get(MedicineViewModel.class);

        fragmentMedicineOrderBinding.continueShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medicineViewModel.resetMedicineCart();
                navController.navigate(R.id.action_medicineOrderFragment_to_paymentActivity2);
            }
        });
    }
}