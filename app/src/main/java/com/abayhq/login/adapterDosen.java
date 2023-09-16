package com.abayhq.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterDosen extends RecyclerView.Adapter<adapterDosen.ViewHolder> {

    private ArrayList<setDosen> dataListDosen;
    public  adapterDosen(ArrayList<setDosen> dataListDosen){
        this.dataListDosen = dataListDosen;
    }

    @NonNull
    @Override
    public adapterDosen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dosencard, parent, false);
        return new adapterDosen.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterDosen.ViewHolder holder, int position) {
        holder.img.setBackgroundResource(dataListDosen.get(position).getterimgDosen());
        holder.dosen.setText(dataListDosen.get(position).getterDosen());
    }

    @Override
    public int getItemCount() {
        return (dataListDosen != null) ? dataListDosen.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView dosen;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgDsn);
            dosen = itemView.findViewById(R.id.Dosen);
        }
    }
}
