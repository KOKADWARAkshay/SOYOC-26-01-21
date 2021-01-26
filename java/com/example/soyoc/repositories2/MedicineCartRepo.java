package com.example.soyoc.repositories2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.soyoc.models2.MedicineCartItem;
import com.example.soyoc.models2.MedicineProduct;

import java.util.ArrayList;
import java.util.List;

public class MedicineCartRepo {
    private MutableLiveData<List<MedicineCartItem>> mutableCart = new MutableLiveData<>();
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<MedicineCartItem>> getCart(){
        if(mutableCart.getValue() == null){
            initCart();
        }
        return  mutableCart;
    }

    public void initCart() {

        mutableCart.setValue(new ArrayList<MedicineCartItem>());
        calculateMedicineCartTotal();
    }

    public  boolean addItemToCart(MedicineProduct medicineProduct){
        if (mutableCart.getValue()==null){
            initCart();
        }
        List<MedicineCartItem>medicineCartItemList = new ArrayList<>(mutableCart.getValue());
        for(MedicineCartItem medicineCartItem: medicineCartItemList) {
            if (medicineCartItem.getMedicineProduct().getId().equals(medicineProduct.getId())){
                if (medicineCartItem.getQuantity()==5) {
                    return false;
                }

                int index = medicineCartItemList.indexOf(medicineCartItem);
                medicineCartItem.setQuantity(medicineCartItem.getQuantity() + 1);
                medicineCartItemList.set(index,medicineCartItem);


                mutableCart.setValue((medicineCartItemList));
                calculateMedicineCartTotal();

                return  true;
            }
        }


        MedicineCartItem medicineCartItem = new MedicineCartItem(medicineProduct,1);
        medicineCartItemList.add(medicineCartItem);
        mutableCart.setValue(medicineCartItemList);
        calculateMedicineCartTotal();
        return  true;

    }
    public  void  removeItemFromMedicineCart(MedicineCartItem medicineCartItem) {
        if (mutableCart.getValue() == null ) {
            return;
        }

        List<MedicineCartItem> medicineCartItemList = new ArrayList<>(mutableCart.getValue());

        medicineCartItemList.remove(medicineCartItem);

        mutableCart.setValue(medicineCartItemList);
        calculateMedicineCartTotal();
    }

    public  void changeQuantity(MedicineCartItem medicineCartItem,int quantity) {
        if(mutableCart.getValue() == null ) return;

        List<MedicineCartItem> medicineCartItemList = new ArrayList<>(mutableCart.getValue());

        MedicineCartItem updatedItem = new MedicineCartItem(medicineCartItem.getMedicineProduct(),quantity);
        medicineCartItemList.set(medicineCartItemList.indexOf(medicineCartItem) , updatedItem);

        mutableCart.setValue(medicineCartItemList);
        calculateMedicineCartTotal();
    }

    private  void calculateMedicineCartTotal() {
        if (mutableCart.getValue() == null) return;
        double total = 0.0;
        List<MedicineCartItem> medicineCartItemList = mutableCart.getValue();
        for (MedicineCartItem medicineCartItem : medicineCartItemList){
            total += medicineCartItem.getMedicineProduct().getPrice() * medicineCartItem.getQuantity();
        }
        mutableTotalPrice.setValue(total);

    }

    public  LiveData<Double> getTotalPrice() {
        if (mutableTotalPrice.getValue() == null) {
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }



}
