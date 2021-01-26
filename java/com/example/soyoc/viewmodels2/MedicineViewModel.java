package com.example.soyoc.viewmodels2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soyoc.models2.MedicineCartItem;
import com.example.soyoc.models2.MedicineProduct;
import com.example.soyoc.repositories2.MedicineCartRepo;
import com.example.soyoc.repositories2.MedicineRepo;

import java.util.List;

public class MedicineViewModel extends ViewModel {

    MedicineRepo medicineRepo =  new  MedicineRepo();
    MedicineCartRepo medicineCartRepo = new MedicineCartRepo();

    MutableLiveData<MedicineProduct> mutableMedicineProduct = new MutableLiveData<>();

    public LiveData<List<MedicineProduct>> getMedicine() {

        return medicineRepo.getMedicineProducts();
    }

    public  void setMedicineProduct(MedicineProduct medicineProduct){
        mutableMedicineProduct.setValue(medicineProduct);

    }

    public LiveData<MedicineProduct> getProduct() {
        return  mutableMedicineProduct;
    }

    public LiveData<List<MedicineCartItem>> getCart(){
        return  medicineCartRepo.getCart();
    }

    public boolean addItemToCart(MedicineProduct medicineProduct){
        return medicineCartRepo.addItemToCart(medicineProduct);
    }

    public  void removeItemFromMedicineCart(MedicineCartItem medicineCartItem){
        medicineCartRepo.removeItemFromMedicineCart(medicineCartItem);
    }

    public void  changeQuantity(MedicineCartItem medicineCartItem, int quantity) {
        medicineCartRepo.changeQuantity(medicineCartItem,quantity);
    }

    public  LiveData<Double> getTotalPrice() {
        return medicineCartRepo.getTotalPrice();
    }
    public  void  resetMedicineCart(){
        medicineCartRepo.initCart();
    }
}
