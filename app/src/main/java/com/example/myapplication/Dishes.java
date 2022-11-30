package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Dishes implements Parcelable {
    private int id;
    private String category;
    private String nameDish;
    private int price;
    private String icon;
    private String version;

    public Dishes(int id, String category, String nameDish, int price, String icon, String version) {
        this.id = id;
        this.category = category;
        this.nameDish = nameDish;
        this.price = price;
        this.icon = icon;
        this.version = version;
    }

    protected Dishes(Parcel in){
        id=in.readInt();
        category=in.readString();
        nameDish=in.readString();
        price=in.readInt();
        icon=in.readString();
        version=in.readString();
    }

    public static final Creator<Dishes> CREATOR = new Creator<Dishes>() {
        @Override
        public Dishes createFromParcel(Parcel in) {
            return new Dishes(in);
        }

        @Override
        public Dishes[] newArray(int size) {
            return new Dishes[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(category);
        parcel.writeString(nameDish);
        parcel.writeInt(price);
        parcel.writeString(icon);
        parcel.writeString(version);
    }
}
