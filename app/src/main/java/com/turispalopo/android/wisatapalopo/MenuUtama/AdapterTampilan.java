package com.turispalopo.android.wisatapalopo.MenuUtama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.turispalopo.android.wisatapalopo.R;

import java.util.List;

public class AdapterTampilan extends RecyclerView.Adapter<AdapterTampilan.MyHolder> {

    Context mContext;
    List<WisataModel> mData;

    public AdapterTampilan(Context mContext, List<WisataModel> mData) {
        this.mContext = mContext;
        this.mData = mData;


    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.item_row_wisata, parent, false);
        return new MyHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.tvNamaWisata.setText(mData.get(position).getWisata());
        Glide.with(mContext)
                .load(mData.get(position)
                .getFoto())
                .into(holder.imgFoto);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNamaWisata;
        ImageView imgFoto;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaWisata = itemView.findViewById(R.id.tvNamaWisata);
            imgFoto = itemView.findViewById(R.id.imgFoto);
        }


    }
}