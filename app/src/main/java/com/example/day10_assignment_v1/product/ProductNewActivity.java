package com.example.day10_assignment_v1.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.customer.CustomerNewActivity;

public class ProductNewActivity extends AppCompatActivity {
EditText etNewProdName;

Button btnSaveNewProd, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_new);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNewProdName=findViewById(R.id.etNewProdName);
        btnSaveNewProd=findViewById(R.id.btnSaveNewProd);


        btnSaveNewProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDB.UpdateProduct(null,
                        etNewProdName.getText().toString(),
                        "sait_oosd_2019_updateSecret",
                        DBHelper.apiURL() + "/api/product_add.php",
                        ProductNewActivity.this);
            }
        });

//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sacedIntent = new Intent(ProductNewActivity.this, ProductListActivity.class);
//                ProductNewActivity.this.startActivity(sacedIntent);
//            }
//        });
    }
}
