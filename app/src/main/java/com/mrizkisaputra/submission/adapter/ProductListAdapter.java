package com.mrizkisaputra.submission.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrizkisaputra.submission.Product;
import com.mrizkisaputra.submission.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {
    private ArrayList<Product> listProduct;
    private OnClickItemList onClickItemList;

    public ProductListAdapter(ArrayList<Product> list) {
        this.listProduct = list;
    }

    public void setOnClickItemList(OnClickItemList onClickItemList) {
        this.onClickItemList = onClickItemList;
    }

    @NonNull
    @Override
    public ProductListAdapter.ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product,parent,false);
        return new ProductListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductListAdapter.ProductListViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(listProduct.get(position).getProductPhoto())
                .into(holder.productPhoto);
        holder.tvProductName.setText(listProduct.get(position).getProductSubtitleName());
        holder.tvProductDetail.setText(listProduct.get(position).getProductDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemList.onClick(listProduct.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductDetail;
        ImageView productPhoto;

        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductDetail = itemView.findViewById(R.id.tv_product_detail);
            productPhoto = itemView.findViewById(R.id.img_product);
        }
    }

    public interface OnClickItemList {
        void onClick(Product product);
    }
}
