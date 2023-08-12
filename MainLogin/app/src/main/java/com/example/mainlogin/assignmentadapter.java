package com.example.mainlogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class assignmentadapter extends FirebaseRecyclerAdapter<adminaddassi, assignmentadapter.myviewholder> {
    public assignmentadapter(@NonNull FirebaseRecyclerOptions<adminaddassi> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull adminaddassi model) {
        holder.sub.setText(model.getSubject());
        holder.desc.setText(model.getDesc());
        holder.mark.setText(model.getMark());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singleassignment, parent, false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView sub,desc,mark;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            sub=itemView.findViewById(R.id.assignsub);
            desc=itemView.findViewById(R.id.assigndesc);
            mark=itemView.findViewById(R.id.assignremark);
        }
    }
}
