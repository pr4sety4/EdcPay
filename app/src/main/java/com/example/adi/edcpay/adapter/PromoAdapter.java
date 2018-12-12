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

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    Context context;
    private List<Integer> mImageSource;
    private ItemClickListener mClickListener;

    public PromoAdapter(List<Integer> mImageSource, Context context) {
        this.mImageSource = mImageSource;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promo_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int source = mImageSource.get(position);

        holder.imgPromo.setImageResource(source);
    }


    @Override
    public int getItemCount() {
        return mImageSource.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgPromo;
        TextView tvPromoTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPromo = itemView.findViewById(R.id.imgPromo);
            tvPromoTitle = itemView.findViewById(R.id.tvPromoTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

}
