package com.example.day10_assignment_v1.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.supplier.Supplier;
import com.example.day10_assignment_v1.supplier.SupplierDB;
import com.example.day10_assignment_v1.supplier.SupplierDetailActivity;
import com.example.day10_assignment_v1.supplier.SupplierNewActivity;

public class ProductSuppliersListActivity extends AppCompatActivity {

    ListView  lvSuppliers;
    Button btnNewSupplier;
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_suppliers_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvSuppliers=findViewById(R.id.lvSuppliers);
        btnNewSupplier=findViewById(R.id.btnNewSupplier);
//        Product productObj = getIntent().getParcelableExtra("product");
//        Integer productId=productObj.getProductId();
//        String prodName=productObj.getProdName();
//
//        Uri.Builder productsURL = new Uri.Builder();
//        productsURL.scheme("https").authority(DBHelper.apiAuth())
//                .appendPath("api")
//                .appendPath("product_data.php")
//                .appendQueryParameter("ProductId", String.valueOf(productObj.getProductId()));
//        String productsAPI = productsURL.build().toString();
//
//        ProductDB.GetProductSupplierText(productsAPI,ProductSuppliersListActivity.this,lvSuppliers);
//
//
//        ProductDB.GetProductSupplierText(productsAPI,ProductSuppliersListActivity.this,lvSuppliers);








        Intent intent = getIntent();
        Product prod = intent.getParcelableExtra("product");
        String prodId = String.valueOf(prod.getProductId());

        //Supplier supplierObj = intent.getParcelableExtra("supplier");

//        Intent supplierIntent = new Intent(this, ProductListActivity.class);
//        ArrayList<Product> prodList = new ArrayList<Product>();
//
//        Integer productId = supplierObj.getProductId();
//       String prodName =supplierObj.getProdName();
//      Integer supplierId = supplierObj.getSupplierId();
//     Integer supplierContactId = supplierObj.getSupplierContactId();
//        String SupConFirstName = supplierObj.getSupConFirstName();
//         String SupConLastName = supplierObj.getSupConLastName();
//        String SupConCompany = supplierObj.getSupConCompany();
//       String SupConAddress = supplierObj.getSupConAddress();
//        String SupConCity = supplierObj.getSupConCity();
//         String SupConProv  =supplierObj.getSupConProv();
//         String SupConPostal = supplierObj.getSupConPostal();
//        String SupConCountry = supplierObj.getSupConCountry();
//        String SupConBusPhone = supplierObj.getSupConBusPhone();
//        String SupConFax = supplierObj.getSupConFax();
//        String SupConEmail = supplierObj.getSupConEmail();
//        String SupConURL = supplierObj.getSupConURL();
//        String AffiliationId = supplierObj.getAffiliationId();

        Uri.Builder suppliersURL = new Uri.Builder();
        suppliersURL.scheme("https").authority(DBHelper.apiAuth())
                .appendPath("api")
                .appendPath("suppliercontacts_data.php")
                .appendQueryParameter("ProductId", prodId);
        String suppliersAPI = suppliersURL.build().toString();

        //ProductDB.GetProductSupplierText(suppliersAPI,this,lvSuppliers);
        SupplierDB.SelectedSupplierData(suppliersAPI,getApplicationContext(),lvSuppliers);

        lvSuppliers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductSuppliersListActivity.this, SupplierDetailActivity.class);
                intent.putExtra("supplier",(Supplier) lvSuppliers.getItemAtPosition(position));
                ProductSuppliersListActivity.this.startActivity(intent);
                //startActivity(intent);
            }
        });
        btnNewSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSupplierIntent = new Intent(ProductSuppliersListActivity.this, SupplierNewActivity.class);
                ProductSuppliersListActivity.this.startActivity(addSupplierIntent);
            }
        });

    }
}
