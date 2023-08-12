package com.example.mainlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class notificationadapter extends FirebaseRecyclerAdapter<adminaddnoti, notificationadapter.myviewholder> {
    public notificationadapter(@NonNull FirebaseRecyclerOptions<adminaddnoti> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull adminaddnoti model) {
        holder.sub.setText(model.getSubject());
        holder.desc.setText(model.getDesc());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlenotification, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView sub,desc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            sub=itemView.findViewById(R.id.notisub);
            desc=itemView.findViewById(R.id.notidescription);
        }
    }
}
