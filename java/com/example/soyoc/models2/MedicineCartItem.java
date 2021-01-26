package com.example.soyoc.models2;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class MedicineCartItem {
    private MedicineProduct medicineProduct;
    int quantity;

    public MedicineCartItem(MedicineProduct medicineProduct, int quantity) {
        this.medicineProduct = medicineProduct;
        this.quantity = quantity;
    }

    public MedicineProduct getMedicineProduct() {
        return medicineProduct;
    }

    public void setMedicineProduct(MedicineProduct medicineProduct) {
        this.medicineProduct = medicineProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MedicineCartItem{" +
                "medicineProduct=" + medicineProduct +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineCartItem that = (MedicineCartItem) o;
        return getQuantity() == that.getQuantity() &&
                getMedicineProduct().equals(that.getMedicineProduct());
    }

    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner, int quantity) {
        spinner.setSelection(quantity - 1, true);

    }

    public static DiffUtil.ItemCallback<MedicineCartItem> itemItemCallback = new DiffUtil.ItemCallback<MedicineCartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull MedicineCartItem oldItem, @NonNull MedicineCartItem newItem) {
            // return oldItem.getMedicineProduct().equals(newItem.getMedicineProduct());
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull MedicineCartItem oldItem, @NonNull MedicineCartItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}