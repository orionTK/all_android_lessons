package com.FourFashionShop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.FourFashionShop.R;
import com.FourFashionShop.Models.CartModel;

import java.util.List;

public class BeforeOrderAdapter extends RecyclerView.Adapter<BeforeOrderAdapter.MyViewHolder> {

    List<CartModel> cartModelList;
    Context context;
    public int num;



    public BeforeOrderAdapter(List<CartModel> cartModelList, Context context) {
        this.cartModelList = cartModelList;
        this.context = context;
    }

    public int getItemCount() {
        return cartModelList.size();
    }


    @NonNull
    @Override
    public BeforeOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_product_order, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BeforeOrderAdapter.MyViewHolder holder, int position) {
        holder.txtNameProductOrder.setText(cartModelList.get(position).getName());
        holder.txtPricaOrder.setText(String.valueOf(cartModelList.get(position).getTotalPrice()));
        holder.imageProOrder.setImageResource(cartModelList.get(position).getImg());
        holder.txtNumPro.setText(String.valueOf(cartModelList.get(position).getTxtSoLuong()));





    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageProOrder;
        public TextView txtNameProductOrder, txtNumPro, txtPricaOrder;
        public CardView cardViewOrder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewOrder = itemView.findViewById(R.id.cardViewOrder);
            txtNameProductOrder = (TextView) itemView.findViewById(R.id.txtNameProductOrder);
            txtNumPro = (TextView) itemView.findViewById(R.id.txtNumPro);
            txtPricaOrder = (TextView) itemView.findViewById(R.id.txtPricaOrder);
            imageProOrder = (ImageView) itemView.findViewById(R.id.imageProOrder);
        }
    }


}
