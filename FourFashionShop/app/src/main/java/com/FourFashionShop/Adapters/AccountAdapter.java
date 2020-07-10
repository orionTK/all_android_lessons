package com.FourFashionShop.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.FourFashionShop.R;
import com.FourFashionShop.Models.AccountModel;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {

    private List<AccountModel> accountModels;
    private Context context;

    public AccountAdapter(List<AccountModel> accountModels, Context context) {
        this.accountModels = accountModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.account_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(accountModels.get(position).getImage());
        holder.textView.setText(accountModels.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return accountModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        //ConstraintLayout constraintLayout;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_start_icon);
            textView = itemView.findViewById(R.id.textView_content);
            linearLayout = itemView.findViewById(R.id.fragment_account_layout);
            itemView.setOnTouchListener(itemTouchListener);
        }
    }

    private View.OnTouchListener itemTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setBackgroundResource(R.color.grey_200);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    // CANCEL triggers when you press the view for too long
                    // It prevents UP to trigger which makes the 'pressed' background permanent which isn't what we want
                case MotionEvent.ACTION_OUTSIDE:
                    // OUTSIDE triggers when the user's finger moves out of the view
                case MotionEvent.ACTION_UP:
                    v.setBackgroundResource(R.color.white);
                    break;
                default:
                    break;
            }
            return true;
        }
    };
}
