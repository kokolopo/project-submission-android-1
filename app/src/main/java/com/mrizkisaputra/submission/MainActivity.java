package com.mrizkisaputra.submission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mrizkisaputra.submission.activity.ProductDetailActivity;
import com.mrizkisaputra.submission.activity.ProfileActivity;
import com.mrizkisaputra.submission.adapter.ProductGridAdapter;
import com.mrizkisaputra.submission.adapter.ProductListAdapter;
import com.mrizkisaputra.submission.data.ProductDataset;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myRecyclerview;
    private ArrayList<Product> list = new ArrayList<>();
    private String titleActionBar = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerview = findViewById(R.id.myRecyclerview);
        myRecyclerview.setHasFixedSize(true);
        list.addAll(ProductDataset.getDataProduct());

        setTitleActionBar(titleActionBar);
        showRecyclerviewList();

        // menangani kejadian klik pada bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_list:
                        item.setChecked(true);
                        titleActionBar = "Home";
                        showRecyclerviewList();
                        break;
                    case R.id.menu_cart:
                        item.setChecked(true);
                        Intent iCart = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(iCart);
                        break;
                    case R.id.menu_profile:
                        item.setChecked(true);
                        Intent iProfile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(iProfile);
                        break;
                }
                setTitleActionBar(titleActionBar);
                return false;
            }
        });
    }

    private void showRecyclerviewList() {
        myRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter productListAdapter = new ProductListAdapter(list);
        myRecyclerview.setAdapter(productListAdapter);
        productListAdapter.setOnClickItemList(new ProductListAdapter.OnClickItemList() {
            @Override
            public void onClick(Product product) {
                Intent i = new Intent(MainActivity.this, ProductDetailActivity.class);
                i.putExtra("productTitleName", product.getProductTitleName());
                i.putExtra("productSubtitleName", product.getProductSubtitleName());
                i.putExtra("productDetail", product.getProductDetail());
                i.putExtra("productPhoto", product.getProductPhoto());
                i.putExtra("productPrice", product.getProductPrice());
                i.putExtra("productStok", product.getProductStok());
                i.putExtra("productOperatingSystem", product.getProductOperatingSystem());
                i.putExtra("productResolusi", product.getProductResolusi());
                i.putExtra("productSpek", product.getProductSpek());
                startActivity(i);
            }
        });
    }

    private void showRecyclerviewGrid() {
        myRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        ProductGridAdapter productGridAdapter = new ProductGridAdapter(list);
        myRecyclerview.setAdapter(productGridAdapter);
        productGridAdapter.setOnClickItemGrid(new ProductGridAdapter.OnClickItemGrid() {
            @Override
            public void onClick(Product product) {
                Intent i = new Intent(MainActivity.this, ProductDetailActivity.class);
                i.putExtra("productTitleName", product.getProductTitleName());
                i.putExtra("productSubtitleName", product.getProductSubtitleName());
                i.putExtra("productDetail", product.getProductDetail());
                i.putExtra("productPhoto", product.getProductPhoto());
                i.putExtra("productPrice", product.getProductPrice());
                i.putExtra("productStok", product.getProductStok());
                i.putExtra("productOperatingSystem", product.getProductOperatingSystem());
                i.putExtra("productResolusi", product.getProductResolusi());
                i.putExtra("productSpek", product.getProductSpek());
                startActivity(i);
            }
        });
    }

    private void setTitleActionBar(String titleActionBar) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleActionBar);
        }
    }

    // memasang menu pada actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // method menangani kejadian click pada menu actionbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_list:
                titleActionBar = "Home";
                showRecyclerviewList();
                break;
            case R.id.menu_grid:
                titleActionBar = "Grid";
                showRecyclerviewGrid();
                break;
            case R.id.menu_card:
                Toast.makeText(MainActivity.this, "Menunggu Pembaruan!", Toast.LENGTH_SHORT).show();
                break;
        }
        setTitleActionBar(titleActionBar);
        return super.onOptionsItemSelected(item);
    }
}