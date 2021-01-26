package com.example.soyoc.models2;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

public class MedicineProduct{
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;

    public MedicineProduct(String id, String name, double price, boolean isAvailable, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MedicineProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineProduct that = (MedicineProduct) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                isAvailable() == that.isAvailable() &&
                getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getImageUrl().equals(that.getImageUrl());
    }



    public static DiffUtil.ItemCallback<MedicineProduct>itemCallback=new DiffUtil.ItemCallback<MedicineProduct>() {
        @Override
        public boolean areItemsTheSame(@NonNull MedicineProduct oldItem, @NonNull MedicineProduct newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull MedicineProduct oldItem, @NonNull MedicineProduct newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:MedicineProductImage")
    public static  void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView)
                .load(imageUrl)
                .fitCenter()
                .into(imageView);
    }
}
