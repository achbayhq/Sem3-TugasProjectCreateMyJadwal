package com.abayhq.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterMatkul extends RecyclerView.Adapter<adapterMatkul.ViewHolder> {

    private ArrayList<setMatkul> dataList;

    private OnItemClickListener listener;
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(setMatkul item);
    }

    public  adapterMatkul(Context context ,ArrayList<setMatkul> dataList, OnItemClickListener listener){
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public adapterMatkul.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new adapterMatkul.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterMatkul.ViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getterIdMatkul());
        holder.matkul.setText(dataList.get(position).getterMatkul());

        final setMatkul item = dataList.get(position);

        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(item);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView matkul;
        public ViewHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.idMatkul);
            matkul = itemView.findViewById(R.id.Matkul);
        }

        public void bind(setMatkul item) {
            id.setText(item.getterIdMatkul());
            matkul.setText(item.getterMatkul());
        }
    }


}
