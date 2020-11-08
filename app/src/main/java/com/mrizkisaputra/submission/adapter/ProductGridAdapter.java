package com.mrizkisaputra.submission.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrizkisaputra.submission.Product;
import com.mrizkisaputra.submission.R;

import java.util.ArrayList;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductGridViewHolder> {
    private ArrayList<Product> listProduct;
    private OnClickItemGrid onClickItemGrid;

    public ProductGridAdapter(ArrayList<Product> list) {
        this.listProduct = list;
    }

    public void setOnClickItemGrid(OnClickItemGrid onClickItemGrid) {
        this.onClickItemGrid = onClickItemGrid;
    }

    @NonNull
    @Override
    public ProductGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product,parent,false);
        return new ProductGridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductGridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listProduct.get(position).getProductPhoto())
                .into(holder.imgProduct);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemGrid.onClick(listProduct.get(holder.getAdapterPosition()));
            }
        });
    }


    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ProductGridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        public ProductGridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.img_product);
        }
    }

    public interface OnClickItemGrid {
        void onClick(Product product);
    }
}
