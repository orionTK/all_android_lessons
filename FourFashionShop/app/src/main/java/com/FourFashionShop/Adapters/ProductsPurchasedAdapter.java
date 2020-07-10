package com.FourFashionShop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.FourFashionShop.Models.ProductModel;
import com.FourFashionShop.R;

import java.util.List;

public class ProductsPurchasedAdapter extends RecyclerView.Adapter<ProductsPurchasedAdapter.MyViewHolder> {

    private List<ProductModel> productModelList;
    private Context context;

    private OnItemProductsPurchasedClickListener mListener;

    public interface OnItemProductsPurchasedClickListener{
        void onItemClick(int position);
    }

    public void setOnIteamClickListener(OnItemProductsPurchasedClickListener listener) {
        mListener = listener;
    }

    public ProductsPurchasedAdapter(List<ProductModel> productModelList, Context context) {
        this.productModelList = productModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.products_purchased_item, parent, false);

        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgProduct.setImageResource(productModelList.get(position).getImage());
        holder.txtName.setText(productModelList.get(position).getName());
        holder.txtPrice.setText(productModelList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView txtName, txtPrice;
        ImageButton imgBtnRemove;

        public MyViewHolder(@NonNull View itemView, final ProductsPurchasedAdapter.OnItemProductsPurchasedClickListener listener) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.card_image);
            txtName = itemView.findViewById(R.id.card_item_name);
            txtPrice = itemView.findViewById(R.id.card_item_price);
            imgBtnRemove = itemView.findViewById(R.id.imgBtnRemoveCart);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });

        }
    }
}
