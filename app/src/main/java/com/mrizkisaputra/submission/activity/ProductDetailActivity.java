package com.mrizkisaputra.submission.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mrizkisaputra.submission.CartActivity;
import com.mrizkisaputra.submission.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Product");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvProductTitleName = findViewById(R.id.tv_product_title_name);
        TextView tvProductSubtitleName = findViewById(R.id.tv_product_subtitle_name);
        TextView tvProductDetail = findViewById(R.id.tv_product_detail);
        TextView tvProductPrice = findViewById(R.id.tv_product_price);
        TextView tvSpesification = findViewById(R.id.tv_spesification_merek);
        TextView tvProductSpesificationStok = findViewById(R.id.tv_spesification_stok);
        TextView tvProductSpesificationResolusi = findViewById(R.id.tv_spesification_resolusi);
        TextView tvProductSpesificationSpek = findViewById(R.id.tv_spesification_spek);
        TextView tvProductSpesificationOperatingSystem = findViewById(R.id.tv_spesification_os);
        ImageView imgProductPhoto = findViewById(R.id.productPhoto);

        // menangkap data dari activity tujuan
        String productTitleName = getIntent().getStringExtra("productTitleName");
        final String productSubtitleName = getIntent().getStringExtra("productSubtitleName");
        String productDetail = getIntent().getStringExtra("productDetail");
        final String productPrice = getIntent().getStringExtra("productPrice");
        final int productPhoto = getIntent().getIntExtra("productPhoto",0);
        final int productStok = getIntent().getIntExtra("productStok",0);
        String productOperatingSystem = getIntent().getStringExtra("productOperatingSystem");
        String productResolusi = getIntent().getStringExtra("productResolusi");
        String productSpek = getIntent().getStringExtra("productSpek");

        tvProductTitleName.setText(productTitleName);
        tvProductSubtitleName.setText(productSubtitleName);
        tvProductDetail.setText(productDetail);
        tvProductPrice.setText(productPrice);
        tvSpesification.setText(productSubtitleName);
        tvProductSpesificationStok.setText(String.valueOf(productStok));
        tvProductSpesificationResolusi.setText(productResolusi);
        tvProductSpesificationSpek.setText(productSpek);
        tvProductSpesificationOperatingSystem.setText(productOperatingSystem);
        Glide.with(ProductDetailActivity.this)
                .load(productPhoto)
                .into(imgProductPhoto);


        Button btnBuy = findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailActivity.this, "Membeli "+productSubtitleName, Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton imgBtnCart = findViewById(R.id.btn_cart);
        imgBtnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailActivity.this, "Menambahkan "+productSubtitleName, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ProductDetailActivity.this, CartActivity.class);
                i.putExtra("productName",productSubtitleName);
                i.putExtra("productPrice", productPrice);
                i.putExtra("productStok", productStok);
                i.putExtra("productPhoto", productPhoto);
                startActivity(i);
            }
        });
    }

    // method back actionbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}