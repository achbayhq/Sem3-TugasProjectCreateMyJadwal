package com.abayhq.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterIPK extends RecyclerView.Adapter<adapterIPK.ViewHolder>{

    private ArrayList<setIPK> dataListIPK;

    public adapterIPK(ArrayList<setIPK> dataListIPK) {
        this.dataListIPK = dataListIPK;
    }
    @NonNull
    @Override
    public adapterIPK.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.ipkcard, parent, false);
        return new adapterIPK.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterIPK.ViewHolder holder, int position) {
        holder.matkul.setText(dataListIPK.get(position).getterMatkulIPK());
        holder.predikat.setText(dataListIPK.get(position).getterPredikat());
        holder.nilai.setText(dataListIPK.get(position).getterNilai());
    }

    @Override
    public int getItemCount() {
        return (dataListIPK != null) ? dataListIPK.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView matkul;
        TextView predikat;
        TextView nilai;

        public ViewHolder(View itemView) {
            super(itemView);
            matkul = itemView.findViewById(R.id.mkIPK);
            predikat = itemView.findViewById(R.id.predikat);
            nilai = itemView.findViewById(R.id.nilai);
        }
    }
}
