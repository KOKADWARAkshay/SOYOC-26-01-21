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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soyoc.R;
import com.example.soyoc.adapters2.MedicineCartListAdapter;
import com.example.soyoc.databinding.FragmentMedicineCartBinding;
import com.example.soyoc.models2.MedicineCartItem;
import com.example.soyoc.viewmodels2.MedicineViewModel;

import java.util.List;

public class MedicineCartFragment extends Fragment implements MedicineCartListAdapter.MedicineCartInterface {


    private static final String TAG = "MedicineCartFragment";
    MedicineViewModel medicineViewModel;
    FragmentMedicineCartBinding fragmentMedicineCartBinding;
    NavController navController;

    public MedicineCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMedicineCartBinding = FragmentMedicineCartBinding.inflate(inflater,container,false);
        return  fragmentMedicineCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        final MedicineCartListAdapter medicineCartListAdapter = new MedicineCartListAdapter(this);

        fragmentMedicineCartBinding.cartRecyclerView.setAdapter(medicineCartListAdapter);
        fragmentMedicineCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));



        medicineViewModel = new ViewModelProvider(requireActivity()).get(MedicineViewModel.class);
        medicineViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<MedicineCartItem>>() {
            @Override
            public void onChanged(List<MedicineCartItem> medicineCartItems) {
                medicineCartListAdapter.submitList(medicineCartItems);
                fragmentMedicineCartBinding.placeOrderButton.setEnabled(medicineCartItems.size()>0);

            }
        });

        medicineViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                fragmentMedicineCartBinding.orderTotalTextView.setText("Total: ₹ "+ aDouble.toString());

            }
        });

        fragmentMedicineCartBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_medicineCartFragment_to_medicineOrderFragment);
            }
        });
    }

    @Override
    public void deleteItem(MedicineCartItem medicineCartItem) {
        Log.d(TAG, "deleteItem: "+ medicineCartItem.getMedicineProduct().getName());
        medicineViewModel.removeItemFromMedicineCart(medicineCartItem);

    }

    @Override
    public void changeQuantity(MedicineCartItem medicineCartItem, int quantity) {
        medicineViewModel.changeQuantity(medicineCartItem,quantity);

    }
}