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

public class DealsAndPromoAdapter extends RecyclerView.Adapter<DealsAndPromoAdapter.ViewHolder> {

    Context context;
    private List<Integer> mImageSource;
    private List<String> mTitle;
    private List<String> mDescription;
    private DealsAndPromoAdapter.ItemClickListener mClickListener;

    public DealsAndPromoAdapter(Context context, List<Integer> mImageSource, List<String> mTitle, List<String> mDescription) {
        this.context = context;
        this.mImageSource = mImageSource;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    @NonNull
    @Override
    public DealsAndPromoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dealsnpromo_recycler_item, parent, false);
        return new DealsAndPromoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAndPromoAdapter.ViewHolder holder, int position) {
        holder.imgView.setImageResource(mImageSource.get(position));
        holder.tvTitle.setText(mTitle.get(position));
        holder.tvDesc.setText(mDescription.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public void setClickListener(DealsAndPromoAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgView;
        TextView tvTitle, tvDesc;


        public ViewHolder(View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgPromo);
            tvTitle = itemView.findViewById(R.id.tvPromoTitle);
            tvDesc = itemView.findViewById(R.id.tvPromoDescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
