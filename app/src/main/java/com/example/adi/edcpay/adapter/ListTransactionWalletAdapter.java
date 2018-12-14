package com.example.adi.edcpay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.model.ListTransactionWalletHeader;
import com.example.adi.edcpay.model.ListTransactionWalletItem;
import com.example.adi.edcpay.util.Constant;

import java.util.List;

public class ListTransactionWalletAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ListTransactionWalletHeader header;
    List<ListTransactionWalletItem> listItem;

    public ListTransactionWalletAdapter(Context context, ListTransactionWalletHeader header, List<ListTransactionWalletItem> listItem) {
        this.header = header;
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constant.TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_wallet_header, parent, false);
            return new VHHeader(v);
        } else if (viewType == Constant.TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_wallet_item, parent, false);
            return new VHItem(v);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHHeader) {
            VHHeader VHheader = (VHHeader) holder;
            VHheader.tvTitle.setText(header.getHeader());
        } else if (holder instanceof VHItem) {
            ListTransactionWalletItem currentItem = getItem(position - 1);
            VHItem VHitem = (VHItem) holder;
            VHitem.tvTitle.setText(currentItem.getTitle());
            VHitem.tvDate.setText(currentItem.getDate());
            VHitem.tvAmount.setText(currentItem.getAmount());
            VHitem.imgIcon.setImageResource(currentItem.getImageResource());

            if (currentItem.getStatus() == "fail") {
                VHitem.tvAmount.setTextColor(ContextCompat.getColor(context, R.color.red));
            }

        }
    }

    private ListTransactionWalletItem getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public int getItemCount() {
        return listItem.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return Constant.TYPE_HEADER;
        return Constant.TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    class VHHeader extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public VHHeader(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.transactionListWalletHeaderTitle);
        }
    }

    class VHItem extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDate, tvAmount;
        ImageView imgIcon;

        public VHItem(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.titleTransactionListWalletItem);
            tvDate = itemView.findViewById(R.id.dateTransactionListWalletItem);
            tvAmount = itemView.findViewById(R.id.amountTransactionListWalletItem);
            imgIcon = itemView.findViewById(R.id.iconTransactionListWalletItem);

        }
    }
}
