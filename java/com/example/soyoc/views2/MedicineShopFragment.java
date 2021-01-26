package com.example.soyoc.views2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soyoc.R;
import com.example.soyoc.adapters2.MedicineListAdapter;
import com.example.soyoc.databinding.FragmentMedicineShopBinding;
import com.example.soyoc.models2.MedicineProduct;
import com.example.soyoc.viewmodels2.MedicineViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MedicineShopFragment extends Fragment implements  MedicineListAdapter.MedicineInterface {

    private static final String TAG = "MedicineShopFragment";
    //1.
    FragmentMedicineShopBinding fragmentMedicineShopBinding;

    private MedicineListAdapter medicineListAdapter;

    private MedicineViewModel medicineViewModel;

    private NavController navController;


    public MedicineShopFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //2.
        fragmentMedicineShopBinding = FragmentMedicineShopBinding.inflate(inflater, container, false);
        return fragmentMedicineShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicineListAdapter = new MedicineListAdapter(this);

        fragmentMedicineShopBinding.shopRecyclerView.setAdapter(medicineListAdapter);


        fragmentMedicineShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentMedicineShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        medicineViewModel = new ViewModelProvider(requireActivity()).get(MedicineViewModel.class);
        medicineViewModel.getMedicine().observe(getViewLifecycleOwner(), new Observer<List<MedicineProduct>>() {
            @Override
            public void onChanged(List<MedicineProduct> medicineProducts) {
                medicineListAdapter.submitList(medicineProducts);
            }
        });

        navController = Navigation.findNavController(view);
    }


    @Override
    public void addItem(MedicineProduct medicineProduct) {
        // Log.d(TAG,"addItem" + medicineProduct.toString());
        boolean isAdded = medicineViewModel.addItemToCart(medicineProduct);
        //  Log.d(TAG,"addItem" + medicineProduct.getName() + isAdded);
        if (isAdded) {
            Snackbar.make(requireView(),medicineProduct.getName() + "added to cart" , Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            navController.navigate(R.id.action_medicineShopFragment_to_medicineCartFragment);
                        }
                    })
                    .show();

        } else {
            Snackbar.make(requireView(),"Already have the max quantity in cart." , Snackbar.LENGTH_LONG)
                    .show();

        }

    }

    @Override
    public void onItemClick(MedicineProduct medicineProduct) {
        //Log.d(TAG,"onItemClick:" + medicineProduct.toString());

        medicineViewModel.setMedicineProduct(medicineProduct);

        navController.navigate(R.id.action_medicineShopFragment_to_medicineDetailFragment);

    }


}

