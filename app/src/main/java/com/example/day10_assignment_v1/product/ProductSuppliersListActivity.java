package com.example.day10_assignment_v1.product;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.supplier.Supplier;
import com.example.day10_assignment_v1.supplier.SupplierDB;
import com.example.day10_assignment_v1.supplier.SupplierDetailActivity;
import com.example.day10_assignment_v1.supplier.SupplierNewActivity;

public class ProductSuppliersListActivity extends Fragment {

    ListView  lvSuppliers;
    Button btnNewSupplier;
    public ProductSuppliersListActivity(){

    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_product_suppliers_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lvSuppliers=getActivity().findViewById(R.id.lvSuppliers);
        btnNewSupplier=getActivity().findViewById(R.id.btnNewSupplier);


        Intent intent = getActivity().getIntent();



        Product prod = intent.getParcelableExtra("product");
        if(prod !=null){
        String prodId = String.valueOf(prod.getProductId());


        Uri.Builder suppliersURL = new Uri.Builder();
        suppliersURL.scheme("http").encodedAuthority(DBHelper.apiAuth())
                .appendPath("api")
                .appendPath("suppliercontacts_data.php")
                .appendQueryParameter("ProductId", prodId);
        String suppliersAPI = suppliersURL.build().toString();

            lvSuppliers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), SupplierDetailActivity.class);
                intent.putExtra("supplier",(Supplier) lvSuppliers.getItemAtPosition(position));
                ProductSuppliersListActivity.this.startActivity(intent);
                //startActivity(intent);
            }
        });




            btnNewSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSupplierIntent = new Intent(getActivity(), SupplierNewActivity.class);
                ProductSuppliersListActivity.this.startActivity(addSupplierIntent);
            }
        });
        //ProductDB.GetProductSupplierText(suppliersAPI,this,lvSuppliers);
        SupplierDB.SelectedSupplierData(suppliersAPI,getActivity().getApplicationContext(),lvSuppliers);}

    }
    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product_suppliers_list);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        lvSuppliers=findViewById(R.id.lvSuppliers);
//        btnNewSupplier=findViewById(R.id.btnNewSupplier);
//
//        Intent intent = getIntent();
//        Product prod = intent.getParcelableExtra("product");
//        String prodId = String.valueOf(prod.getProductId());
//
//
//        Uri.Builder suppliersURL = new Uri.Builder();
//        suppliersURL.scheme("https").authority(DBHelper.apiAuth())
//                .appendPath("api")
//                .appendPath("suppliercontacts_data.php")
//                .appendQueryParameter("ProductId", prodId);
//        String suppliersAPI = suppliersURL.build().toString();
//
//        //ProductDB.GetProductSupplierText(suppliersAPI,this,lvSuppliers);
//        SupplierDB.SelectedSupplierData(suppliersAPI,getApplicationContext(),lvSuppliers);
//
//        lvSuppliers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(ProductSuppliersListActivity.this, SupplierDetailActivity.class);
//                intent.putExtra("supplier",(Supplier) lvSuppliers.getItemAtPosition(position));
//                ProductSuppliersListActivity.this.startActivity(intent);
//                //startActivity(intent);
//            }
//        });
//        btnNewSupplier.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent addSupplierIntent = new Intent(ProductSuppliersListActivity.this, SupplierNewActivity.class);
//                ProductSuppliersListActivity.this.startActivity(addSupplierIntent);
//            }
//        });
//
//    }
}
