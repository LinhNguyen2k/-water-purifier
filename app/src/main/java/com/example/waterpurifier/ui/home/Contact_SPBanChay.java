package com.example.waterpurifier.ui.home;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Contact_SPBanChay implements Parcelable, Serializable{
    private String price;
    private String image;
    private String name_product;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Contact_SPBanChay(String price, String image, String name_product) {
        this.price = price;
        this.image = image;
        this.name_product = name_product;
    }

    public static final Parcelable.Creator<Contact_SPBanChay> CREATOR = new Parcelable.Creator<Contact_SPBanChay>() {
        @Override
        public Contact_SPBanChay createFromParcel(Parcel in) {
            return new Contact_SPBanChay(in);
        }

        @Override
        public Contact_SPBanChay[] newArray(int size) {
            return new Contact_SPBanChay[size];
        }
    };

      protected Contact_SPBanChay(Parcel in) {
        price = in.readString();
        image = in.readString();
        name_product = in.readString();

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_product);
        dest.writeString(image);
        dest.writeString(price);
    }
}
