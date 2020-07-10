package com.FourFashionShop.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.FourFashionShop.R;
import com.FourFashionShop.Fragments.mall_Item_Fragment.Item;

import java.util.List;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.MyViewHolder> {

    Context mContext;
    List<Item> mData;
    Dialog mDialog;

    public MallAdapter(Context mContext, List<Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.mall_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.text_Title.setText(mData.get(position).getTitle());
        holder.text_Price.setText(mData.get(position).getPrice());
        holder.imageView.setImageResource(mData.get(position).getImg());

        mDialog = new Dialog(mContext);
        mDialog.setContentView(R.layout.mall_product);
        mDialog.getWindow().setGravity(Gravity.BOTTOM);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        holder.mall_list_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView price = mDialog.findViewById(R.id.text_Price_Item);
                TextView soLuongItem = mDialog.findViewById(R.id.text_SoLuong_Item);
                ImageView img = mDialog.findViewById(R.id.img_item_id);

                price.setText(mData.get(holder.getAdapterPosition()).getPrice());
                soLuongItem.setText(mData.get(holder.getAdapterPosition()).getSoLuong());
                img.setImageResource(mData.get(holder.getAdapterPosition()).getImg());
                mDialog.show();
                //dem so luong
                ImageButton imgBtnAdd = mDialog.findViewById(R.id.imgBtnAdd);
                ImageButton imgBtnRemove = mDialog.findViewById(R.id.imgBtnRemove);
                Button addCart = mDialog.findViewById(R.id.add_Cart);
                final TextView txSoLuong = mDialog.findViewById(R.id.txtSoLuong);
                txSoLuong.setText(String.valueOf(1));
                imgBtnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int soLuong = Integer.parseInt(txSoLuong.getText().toString()) + 1;
                        txSoLuong.setText(String.valueOf(soLuong));
                    }
                });

                imgBtnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int soLuong = Integer.parseInt(txSoLuong.getText().toString());
                        if (soLuong > 1)
                            soLuong = soLuong - 1;
                        txSoLuong.setText(String.valueOf(soLuong));
                    }
                });

                addCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.cancel();
                    }
                });

                //xu li button chon size
                final Button btSizeS = mDialog.findViewById(R.id.sizeS);
                btSizeS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btSizeS.setBackgroundResource(R.drawable.button1);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text_Price;
        private TextView text_Title;
        private TextView text_SoLuong;
        private ImageView imageView;
        private LinearLayout mall_list_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_Title = itemView.findViewById(R.id.text_Title);
            text_Price = itemView.findViewById(R.id.text_Price);
            imageView = itemView.findViewById(R.id.imgItem);
            mall_list_item = itemView.findViewById(R.id.mall_list_item);
        }
    }

}





