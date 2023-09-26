package com.abayhq.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterJadwal extends RecyclerView.Adapter<adapterJadwal.ViewHolder> {

    private ArrayList<setJadwal> dataListJadwal;

    public adapterJadwal(ArrayList<setJadwal> dataListJadwal) {
        this.dataListJadwal = dataListJadwal;
    }

    @NonNull
    @Override
    public adapterJadwal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.jadwalcard, parent, false);
        return new adapterJadwal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterJadwal.ViewHolder holder, int position) {
        holder.ruang.setText(dataListJadwal.get(position).getterRuang());
        holder.matkul.setText(dataListJadwal.get(position).getterMatkul());
        holder.jam.setText(dataListJadwal.get(position).getterJam());
    }

    @Override
    public int getItemCount() {
        return (dataListJadwal != null) ? dataListJadwal.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ruang;
        TextView matkul;
        TextView jam;

        public ViewHolder(View itemView) {
            super(itemView);
            ruang = itemView.findViewById(R.id.R);
            matkul = itemView.findViewById(R.id.jwMatkul);
            jam = itemView.findViewById(R.id.jwJam);
        }
    }
}
