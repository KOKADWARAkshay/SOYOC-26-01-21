package com.example.soyoc.repositories2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.soyoc.models2.MedicineProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MedicineRepo {

    private MutableLiveData<List<MedicineProduct>> mutableMedicineProductList;

    public LiveData<List<MedicineProduct>> getMedicineProducts() {
        if (mutableMedicineProductList == null){
            mutableMedicineProductList= new MutableLiveData<>();
            loadMedicineProducts();
        }
        return  mutableMedicineProductList;
    }

    private  void loadMedicineProducts() {
        List<MedicineProduct> productList = new ArrayList<>();

        productList.add(new MedicineProduct(UUID.randomUUID().toString(), "CARROT 1kg", 40, true, "https://soyocofficial-238dd.firebaseio.com/" ));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "iPad Air", 799, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fipadair.jpeg?alt=media&token=da387155-bd8f-4343-954b-e46da7d252ae"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "CORN 1kg", 60, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F23-corn-png-image-thumb.png?alt=media&token=46aa03ce-1de1-4520-b5ee-f3ed4e09bcc7"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "RED CHILLII 1kg", 60, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F37-red-chili-pepper-png-image-thumb.png?alt=media&token=c1fe157f-a76b-4533-9a04-bc4f283715b8"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "CABAGE 1kg", 30, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F6-cabbage-png-image-thumb.png?alt=media&token=b1afdefc-cd0d-4804-8e6e-bfcd90a1e881"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "TOMATO 1kg", 90, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F6-tomato-png-image-thumb.png?alt=media&token=db0e1232-ce87-48f1-a205-c5b1fdc789df"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "POTATO 1kg", 30, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F7-potato-png-images-pictures-download-thumb.png?alt=media&token=66f3b486-96a9-4991-92ed-a709c62d199d"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "ONION 1kg", 60, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2F8-onion-png-image-thumb.png?alt=media&token=45909f3a-50dd-48ad-8e84-4c7ff278853a"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "MAGII ", 40, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2FMAgiie%20noodles.jpg?alt=media&token=735ee10e-7e09-4e0a-b4fb-106f6e380cda"));

        productList.add(new MedicineProduct (UUID.randomUUID().toString(), "YIPEE", 20, true, "https://firebasestorage.googleapis.com/v0/b/soyoc-844b1.appspot.com/o/GROCERIES%20PRODUCT%2FYIPEE.jpg?alt=media&token=72b45417-5f4b-42e9-8780-f48a0ac44897"));


        mutableMedicineProductList.setValue(productList);
    }

}
