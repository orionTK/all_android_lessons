package com.FourFashionShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.FourFashionShop.R;
import com.FourFashionShop.Models.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<CartModel> cartModelList;
    Context context;
    public int sluong;

    private OnItemCartClickListener mListener;

    //interface
    public interface OnItemCartClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onAddNumberClick(int position);
        void onRemoveNumberClick(int position);
    }

    public void setOnIteamClickListener(OnItemCartClickListener listener) {
        mListener = listener;
    }

    public CartAdapter(List<CartModel> cartModelList, Context context) {
        this.cartModelList = cartModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_list_item, parent, false);

        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.MyViewHolder holder, int position) {
        holder.txtName.setText(cartModelList.get(position).getName());
        holder.txtPrice.setText(cartModelList.get(position).getTotalPrice() + " đ");
        holder.imageView.setImageResource(cartModelList.get(position).getImg());
        holder.txtSoLuong.setText(String.valueOf(cartModelList.get(position).getTxtSoLuong()));





    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtName, txtPrice, txtSoLuong;
        public ImageButton imgBtnCloseCart, imgBtnAddPro, imgBtnRemovePro;
        public CardView cardView;

        public MyViewHolder(@NonNull View itemView, final OnItemCartClickListener listener) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_container);
            txtSoLuong = (TextView) itemView.findViewById(R.id.txtSoLuong);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imagePro);

            imgBtnAddPro = (ImageButton) itemView.findViewById(R.id.imgBtnAddPro);
            imgBtnRemovePro = (ImageButton) itemView.findViewById(R.id.imgBtnRemovePro);
            imgBtnCloseCart = (ImageButton) itemView.findViewById(R.id.imgBtnCloseCart);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {

                            listener.onItemClick(position);
                        }
                    }
                }
            });

            imgBtnCloseCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onDeleteClick(position);
                    }
                }
            });

            imgBtnAddPro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onAddNumberClick(position);
                    }
                }
            });

            imgBtnRemovePro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onRemoveNumberClick(position);
                    }
                }
            });
        }


    }


}
