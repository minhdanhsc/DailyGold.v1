package com.example.danh.dailygold.Model;

public class NgoaiTe {
    // khai bao cac thuoc tinh
    private String mName ;
    private String mPrice;
    // ham khoi tao

    public NgoaiTe(String mName, String mPrice) {
        this.mName = mName;
        this.mPrice = mPrice;
    }
    //cac phuong thuc

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }
}
