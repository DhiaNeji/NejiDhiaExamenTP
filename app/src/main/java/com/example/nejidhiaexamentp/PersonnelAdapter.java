package com.example.nejidhiaexamentp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonnelAdapter extends RecyclerView.Adapter<PersonnelAdapter.PersonnelViewHolder> {
    ArrayList<Personnel>liste;
    Context ctx;

    public PersonnelAdapter(ArrayList<Personnel> liste, Context ctx) {
        this.liste = liste;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PersonnelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
        PersonnelViewHolder p=new PersonnelViewHolder(view);
        return p;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonnelViewHolder holder, final int position) {
        Personnel p=liste.get(position);
        holder.txtMat.setText(p.getMatricule().toString());
        holder.txtNom.setText(p.getNom().toString());
        holder.txtPrenom.setText(p.getPrenom().toString());
        holder.txtService.setText(p.getService().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(ctx,Main2Activity.class);
            i.putExtra("matricule",liste.get(position).getMatricule());
            i.putExtra("nom",liste.get(position).getNom());
            ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public static class PersonnelViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtMat;
        TextView txtNom;
        TextView txtPrenom;
        TextView txtService;
        public PersonnelViewHolder(View v)
        {
            super(v);
            txtMat=v.findViewById(R.id.txtMat);
            txtNom=v.findViewById(R.id.txtNom);
            txtPrenom=v.findViewById(R.id.txtPrenom);
            txtService=v.findViewById(R.id.txtService);
        }
    }
}
