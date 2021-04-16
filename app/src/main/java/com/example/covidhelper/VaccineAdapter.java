package com.example.covidhelper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class VaccineAdapter extends RecyclerView.Adapter<VaccineAdapter.StateVaccine> {
    Context context;
    String state;
    ArrayList<VaccineModal> vaccineModalsList;

    public VaccineAdapter(Context context, ArrayList<VaccineModal> vaccineModalsList, String state) {
        this.context = context;
        this.vaccineModalsList = vaccineModalsList;
        this.state = state;
        Log.i("msfasas",vaccineModalsList+"kkkk");
    }

    @NonNull
    @Override
    public StateVaccine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new StateVaccine(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateVaccine holder, int position) {
        final VaccineModal vaccineModal = vaccineModalsList.get(position);
        holder.totalvacc.setText("Today vacine:".concat(String.valueOf(vaccineModal.getTotal_vac())));
        holder.stnam.setText("State:".concat(vaccineModal.getState()));

    }

    @Override
    public int getItemCount() {
        return vaccineModalsList != null && vaccineModalsList.size() > 0 ? vaccineModalsList.size() : 0;
    }

    public class StateVaccine extends RecyclerView.ViewHolder {
        TextView stnam,totalvacc;
        public StateVaccine(@NonNull View itemView) {
            super(itemView);
            stnam =  itemView.findViewById(R.id.state);
            totalvacc = itemView.findViewById(R.id.totat_vac);
        }
    }

}
