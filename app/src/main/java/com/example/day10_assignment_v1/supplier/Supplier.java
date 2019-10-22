package com.example.day10_assignment_v1.supplier;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.day10_assignment_v1.product.Product;

public class Supplier  implements Parcelable {
    private Integer ProductId;
    private String ProdName;
    private Integer SupplierId;
    private Integer SupplierContactId;
    private String SupConFirstName;
    private String SupConLastName;
    private String SupConCompany;
    private String SupConAddress;
    private String SupConCity;
    private String SupConProv;
    private String SupConPostal;
    private String SupConCountry;
    private String SupConBusPhone;
    private String SupConFax;
    private String SupConEmail;
    private String SupConURL;
    private String AffiliationId;
    private static final String TAG = "MyActivitySupplier";

    public Supplier(Integer productId, String prodName, Integer supplierId,
                    Integer supplierContactId, String supConFirstName, String supConLastName,
                    String supConCompany, String supConAddress, String supConCity,String supConProv,
                    String supConPostal, String supConCountry, String supConBusPhone,
                    String supConFax, String supConEmail, String supConURL, String affiliationId)
    {
        ProductId = productId;
        ProdName = prodName;
        SupplierId = supplierId;
        SupplierContactId = supplierContactId;
        SupConFirstName = supConFirstName;
        SupConLastName = supConLastName;
        SupConCompany = supConCompany;
        SupConAddress = supConAddress;
        SupConCity = supConCity;
        SupConProv = supConProv;
        SupConPostal = supConPostal;
        SupConCountry = supConCountry;
        SupConBusPhone = supConBusPhone;
        SupConFax = supConFax;
        SupConEmail = supConEmail;
        SupConURL = supConURL;
        AffiliationId = affiliationId;
    }

//    public Supplier(String prodName, String supConCompany) {
//        ProdName = prodName;
//        SupConCompany = supConCompany;
//    }

    public Supplier(Parcel source){
        Log.v(TAG,"Supplier(Parcel Source)");
        ProductId=source.readInt();
        ProdName=source.readString();
        SupplierId=source.readInt();
        SupplierContactId=source.readInt();
        SupConFirstName = source.readString();
        SupConLastName = source.readString();
        SupConCompany = source.readString();
        SupConAddress = source.readString();
        SupConCity = source.readString();
        SupConProv = source.readString();
        SupConPostal = source.readString();
        SupConCountry = source.readString();
        SupConBusPhone = source.readString();
        SupConFax = source.readString();
        SupConEmail = source.readString();
        SupConURL = source.readString();
        AffiliationId = source.readString();
    }

//    protected Supplier(Parcel in) {
//        if (in.readByte() == 0) {
//            ProductId = null;
//        } else {
//            ProductId = in.readInt();
//        }
//        ProdName = in.readString();
//        if (in.readByte() == 0) {
//            SupplierId = null;
//        } else {
//            SupplierId = in.readInt();
//        }
//        if (in.readByte() == 0) {
//            SupplierContactId = null;
//        } else {
//            SupplierContactId = in.readInt();
//        }
//        SupConFirstName = in.readString();
//        SupConLastName = in.readString();
//        SupConCompany = in.readString();
//        SupConAddress = in.readString();
//        SupConCity = in.readString();
//        SupConProv = in.readString();
//        SupConPostal = in.readString();
//        SupConCountry = in.readString();
//        SupConBusPhone = in.readString();
//        SupConFax = in.readString();
//        SupConEmail = in.readString();
//        SupConURL = in.readString();
//        AffiliationId = in.readString();
//    }

    public static final Parcelable.Creator<Supplier> CREATOR= new Parcelable.Creator<Supplier>(){
        @Override
        public Supplier createFromParcel(Parcel source) {
            return new Supplier(source);
        }

        @Override
        public Supplier[] newArray(int size) {
            return new Supplier[size];
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

    public Integer getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Integer supplierId) {
        SupplierId = supplierId;
    }

    public Integer getSupplierContactId() {
        return SupplierContactId;
    }

    public void setSupplierContactId(Integer supplierContactId) {
        SupplierContactId = supplierContactId;
    }

    public String getSupConFirstName() {
        return SupConFirstName;
    }

    public void setSupConFirstName(String supConFirstName) {
        SupConFirstName = supConFirstName;
    }

    public String getSupConLastName() {
        return SupConLastName;
    }

    public void setSupConLastName(String supConLastName) {
        SupConLastName = supConLastName;
    }

    public String getSupConCompany() {
        return SupConCompany;
    }

    public void setSupConCompany(String supConCompany) {
        SupConCompany = supConCompany;
    }

    public String getSupConAddress() {
        return SupConAddress;
    }

    public void setSupConAddress(String supConAddress) {
        SupConAddress = supConAddress;
    }

    public String getSupConProv() {
        return SupConProv;
    }

    public void setSupConProv(String supConProv) {
        SupConProv = supConProv;
    }


    public String getSupConCity() {
        return SupConCity;
    }

    public void setSupConCity(String supConCity) {
        SupConCity = supConCity;
    }


    public String getSupConPostal() {
        return SupConPostal;
    }

    public void setSupConPostal(String supConPostal) {
        SupConPostal = supConPostal;
    }

    public String getSupConCountry() {
        return SupConCountry;
    }

    public void setSupConCountry(String supConCountry) {
        SupConCountry = supConCountry;
    }

    public String getSupConBusPhone() {
        return SupConBusPhone;
    }

    public void setSupConBusPhone(String supConBusPhone) {
        SupConBusPhone = supConBusPhone;
    }

    public String getSupConFax() {
        return SupConFax;
    }

    public void setSupConFax(String supConFax) {
        SupConFax = supConFax;
    }

    public String getSupConEmail() {
        return SupConEmail;
    }

    public void setSupConEmail(String supConEmail) {
        SupConEmail = supConEmail;
    }

    public String getSupConURL() {
        return SupConURL;
    }

    public void setSupConURL(String supConURL) {
        SupConURL = supConURL;
    }

    public String getAffiliationId() {
        return AffiliationId;
    }

    public void setAffiliationId(String affiliationId) {
        AffiliationId = affiliationId;
    }

    @Override
    public String toString() {
        return SupConCompany;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v(TAG,"write suppliers to parcel..."+flags);
        dest.writeInt(this.ProductId);
        dest.writeString(this.ProdName);
        dest.writeInt(this.SupplierId);
        dest.writeInt(this.SupplierContactId);
        dest.writeString(this.SupConFirstName);
        dest.writeString(this.SupConLastName);
        dest.writeString(this.SupConCompany);
        dest.writeString(this.SupConAddress);
        dest.writeString(this.SupConCity);
        dest.writeString(this.SupConProv);
        dest.writeString(this.SupConPostal);
        dest.writeString(this.SupConCompany);
        dest.writeString(this.SupConBusPhone);
        dest.writeString(this.SupConFax);
        dest.writeString(this.SupConEmail);
        dest.writeString(this.SupConURL);
        dest.writeString(this.AffiliationId);



    }
}
