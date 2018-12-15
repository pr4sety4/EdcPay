package com.example.adi.edcpay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adi.edcpay.R;

import java.util.List;

public class WithdrawAdapter extends RecyclerView.Adapter<WithdrawAdapter.ViewHolder> {

    Context context;
    private List<Integer> mImageSource;
    private List<String> mTitle;
    private WithdrawAdapter.ItemClickListener mClickListener;

    public WithdrawAdapter(Context context, List<Integer> mImageSource, List<String> mTitle) {
        this.context = context;
        this.mImageSource = mImageSource;
        this.mTitle = mTitle;
    }

    public void setClickListener(WithdrawAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public WithdrawAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.withdraw_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WithdrawAdapter.ViewHolder holder, int position) {
        holder.imgIcon.setImageResource(mImageSource.get(position));
        holder.tvTitle.setText(mTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgIcon;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.titleWithdrawItem);
            imgIcon = itemView.findViewById(R.id.iconWithdrawItem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
