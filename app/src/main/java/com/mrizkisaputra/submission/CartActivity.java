package com.mrizkisaputra.submission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CartActivity extends AppCompatActivity {
    private ImageView imgPhotoProductCart;
    private TextView tvProductStokCart, tvProductPriceCart, tvProductNameCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Keranjang");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imgPhotoProductCart = findViewById(R.id.img_product_cart);
        tvProductNameCart = findViewById(R.id.tv_product_name_cart);
        tvProductPriceCart = findViewById(R.id.tv_product_price_cart);
        tvProductStokCart = findViewById(R.id.tv_product_stok_cart);

        productCart();
    }

    private void productCart() {
        String productNameCart = getIntent().getStringExtra("productName");
        String productPriceCart = getIntent().getStringExtra("productPrice");
        int productStokCart = getIntent().getIntExtra("productStok",0);
        int productPhotoCart = getIntent().getIntExtra("productPhoto", 0);

        Glide.with(this)
                .load(productPhotoCart)
                .into(imgPhotoProductCart);
        tvProductNameCart.setText(productNameCart);
        tvProductPriceCart.setText(productPriceCart);
        tvProductStokCart.setText(String.valueOf(productStokCart));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}