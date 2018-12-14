package com.example.adi.edcpay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adi.edcpay.R;

import java.util.List;

public class ListWalletAdapter extends RecyclerView.Adapter<ListWalletAdapter.ViewHolder> {

    Context context;
    List<String> title;
    List<String> amount;
    List<String> status;
    ItemClickListener itemClickListener;

    public ListWalletAdapter(Context context, List<String> title, List<String> amount, List<String> status) {
        this.context = context;
        this.title = title;
        this.amount = amount;
        this.status = status;
    }

    @NonNull
    @Override
    public ListWalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wallet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListWalletAdapter.ViewHolder holder, int position) {
        String textTitle = title.get(position);
        String amounts = amount.get(position);

        holder.tvTitle.setText(textTitle + " Wallet");
        holder.tvBalance.setText(textTitle + " " + amounts);
        holder.tvAvailable.setText(textTitle + " " + amounts);

        if (status.get(position) == "send") {
            holder.tvSend.setVisibility(View.VISIBLE);
        } else if (status.get(position) == "sell") {
            holder.tvSell.setVisibility(View.VISIBLE);
            holder.tvBuy.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvBalance, tvAvailable, tvSend, tvSell, tvBuy;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvListWalletTitle);
            tvBalance = itemView.findViewById(R.id.tvListWalletBalance);
            tvAvailable = itemView.findViewById(R.id.tvListWalletAvailable);
            cardView = itemView.findViewById(R.id.cardViewWallet);
            tvSend = itemView.findViewById(R.id.tvSend);
            tvSell = itemView.findViewById(R.id.tvSell);
            tvBuy = itemView.findViewById(R.id.tvBuy);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
