package com.example.soyoc.views2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soyoc.databinding.FragmentMedicineDetailBinding;
import com.example.soyoc.viewmodels2.MedicineViewModel;

public class MedicineDetailFragment extends Fragment {

    FragmentMedicineDetailBinding fragmentMedicineDetailBinding;
    MedicineViewModel medicineViewModel;



    public MedicineDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMedicineDetailBinding = FragmentMedicineDetailBinding.inflate(inflater,container,false);
        return  fragmentMedicineDetailBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicineViewModel = new ViewModelProvider(requireActivity()).get(MedicineViewModel.class);
        fragmentMedicineDetailBinding.setMedicineViewModel(medicineViewModel);
    }
}