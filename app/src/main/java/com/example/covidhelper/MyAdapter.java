package com.example.covidhelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<model, MyAdapter.myViewHolder> {

        public String status;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *

     * @param options
     */
    public MyAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull MyAdapter.myViewHolder holder, int position, @NonNull model model) {
       status= model.getTotal_vac();
        Log.i("STATUS",status);
       holder.total.setText(model.getTotal_vac());


    }

    @NonNull
    @Override
    public MyAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView total;
        TextView tableNum;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            total = (TextView)itemView.findViewById(R.id.totat_vac);


        }
    }
}
