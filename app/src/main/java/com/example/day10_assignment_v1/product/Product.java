package com.example.day10_assignment_v1.product;

import android.nfc.Tag;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Product implements Parcelable {
    private Integer ProductId;
    private String ProdName;
    private static final String TAG = "MyActivityProduct";



    public Product(Parcel source) {
       Log.v(TAG,"Product(Parcel source) : time to put back parcel data");
       ProductId=source.readInt();
       ProdName=source.readString();

    }

    public Product(Integer productId, String prodName) {
        ProductId = productId;
        ProdName = prodName;
    }

    public static final Parcelable.Creator<Product> CREATOR= new Parcelable.Creator<Product>(){
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }



    @Override
    public String toString() {
        return ProdName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v(TAG,"writeToParcel..."+ flags);
        //dest.writeStringArray(new String[]{String.valueOf(ProductId),ProdName});
        dest.writeInt(this.ProductId);
        dest.writeString(this.ProdName);

    }
}
