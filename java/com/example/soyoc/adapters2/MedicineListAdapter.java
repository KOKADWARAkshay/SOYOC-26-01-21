package com.example.soyoc.adapters2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soyoc.databinding.MedicineRowBinding;
import com.example.soyoc.models2.MedicineProduct;

public class MedicineListAdapter extends ListAdapter<MedicineProduct, MedicineListAdapter.MedicineViewHolder> {

    MedicineInterface medicineInterface;
    public MedicineListAdapter(MedicineInterface medicineInterface)
    {
        super(MedicineProduct.itemCallback);
        this.medicineInterface = medicineInterface;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        MedicineRowBinding medicineRowBinding = MedicineRowBinding.inflate(layoutInflater,parent,false);
        medicineRowBinding.setMedicineInterface(medicineInterface);

        return new MedicineViewHolder(medicineRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        MedicineProduct medicineProduct = getItem(position);
        holder.medicineRowBinding.setMedicineProduct(medicineProduct);
        holder.medicineRowBinding.executePendingBindings();

    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {

        MedicineRowBinding medicineRowBinding;

        public MedicineViewHolder(MedicineRowBinding binding) {
            super(binding.getRoot());
            this.medicineRowBinding =binding;


        }
    }

    public interface MedicineInterface{
        void addItem(MedicineProduct medicineProduct);
        void onItemClick(MedicineProduct medicineProduct);
    }
}



