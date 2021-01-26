package com.example.soyoc.adapters2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soyoc.databinding.MedicinecartRowBinding;
import com.example.soyoc.models2.MedicineCartItem;

public class MedicineCartListAdapter extends ListAdapter<MedicineCartItem, MedicineCartListAdapter.MedicineCartVH> {

    private  MedicineCartInterface medicineCartInterface;
    public MedicineCartListAdapter(MedicineCartInterface medicineCartInterface) {
        super(MedicineCartItem.itemItemCallback);
        this.medicineCartInterface = medicineCartInterface;
    }

    @NonNull
    @Override
    public MedicineCartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MedicinecartRowBinding  medicinecartRowBinding = MedicinecartRowBinding.inflate(layoutInflater,parent,false);
        return new MedicineCartVH(medicinecartRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineCartVH holder, int position) {
        holder.medicinecartRowBinding.setMedicineCartItem(getItem(position));
        holder.medicinecartRowBinding.executePendingBindings();

    }

    class  MedicineCartVH extends RecyclerView.ViewHolder{

        MedicinecartRowBinding medicinecartRowBinding;

        public MedicineCartVH(@NonNull MedicinecartRowBinding medicinecartRowBinding) {
            super(medicinecartRowBinding.getRoot());
            this.medicinecartRowBinding =medicinecartRowBinding;


            medicinecartRowBinding.deleteProductButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    medicineCartInterface.deleteItem(getItem(getAdapterPosition()));
                }
            });

            medicinecartRowBinding.quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position , long id) {
                    int quantity = position + 1;
                    if (quantity == getItem(getAdapterPosition()).getQuantity()){
                        return;
                    }
                    medicineCartInterface.changeQuantity(getItem(getAdapterPosition()) , quantity);


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    public interface MedicineCartInterface  {
        void deleteItem(MedicineCartItem medicineCartItem);
        void changeQuantity(MedicineCartItem medicineCartItem, int quantity );

    }
}

