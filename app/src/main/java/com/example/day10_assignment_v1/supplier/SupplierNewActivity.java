package com.example.day10_assignment_v1.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.Validation.Validation;

public class SupplierNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_new);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




//    public boolean validateSup(){
//        String alpha = etSupFirstName.getText().toString();
//        if (!Validation.isValidAlphaOrNull(alpha)) {
//            etSupFirstName.setError(getString(R.string.Alpha));
//            return false;
//        }
//        alpha = etSupLastName.getText().toString();
//        if(!Validation.isValidAlphaOrNull(alpha)) {
//            etSupLastName.setError(getString(R.string.Alpha));
//            return false;
//        }
//        String address = etSupAddress.getText().toString();
//        if(!Validation.isValidAlphaOrNull(address)){
//            etSupAddress.setError(getString(R.string.Address));
//            return false;
//        }
//        alpha = etSupCity.getText().toString();
//        if(!Validation.isValidAlphaOrNull(alpha)) {
//            etSupCity.setError(getString(R.string.Alpha));
//            return false;
//        }
//        alpha = etSupProv.getText().toString();
//        if(!Validation.isValidAlphaOrNull(alpha)){
//            etSupProv.setError(getString(R.string.Alpha));
//            return false;
//        }
//        String postal = etSupPostal.getText().toString();
//        if(!Validation.isValidPhoneNumOrNull(postal)){
//            etSupPostal.setError(getString(R.string.Postal));
//            return false;
//        }
//        alpha = etSupCountry.getText().toString();
//        if(!Validation.isValidAlphaOrNull(alpha)){
//            etSupCountry.setError(getString(R.string.Alpha));
//            return false;
//        }
//        String phone = etSupBusPhone.getText().toString();
//        if(!Validation.isValidPhoneNumOrNull(phone)){
//            etSupBusPhone.setError(getString(R.string.Phone));
//            return false;
//        }
//        phone = etSupFax.getText().toString();
//        if(!Validation.isValidPhoneNumOrNull(phone)){
//            etSupFax.setError(getString(R.string.Fax));
//            return false;
//        }
//        String email = etSupEmail.getText().toString();
//        if(!Validation.isValidEmailOrNull(email)){
//            etSupEmail.setError(getString(R.string.Email));
//            return false;
//        }
//        String url = etSupURL.getText().toString();
//        if(!Validation.isValidUrlOrNull(url)){
//            etSupURL.setError(getString(R.string.Url));
//            return false;
//        }
//        else
//        {
//            return true;
//        }
//
//
//
//
//
//
//
//
//
//
//
//    }
}
