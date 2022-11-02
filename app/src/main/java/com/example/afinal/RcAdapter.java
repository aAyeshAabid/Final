package com.example.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.ViewHolder> {
    Context context;
    List<Model> userlist;
    public  RcAdapter(Context context,List<Model>userlist){
        this.context= context;
        this.userlist= userlist;
    }

    public  void  setUserlist(List<Model>userlist){
        this.userlist=userlist;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.user_row,parent,false);
        ViewHolder viewHolder=  new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(RcAdapter.ViewHolder holder, int position) {
        holder.tvid.setText(userlist.get(position).getId());
        holder.tvnmae.setText(userlist.get(position).getName());
        holder.tvemail.setText(userlist.get(position).getEmail());
        holder.tvgender.setText(userlist.get(position).getGender());
        holder.tvststus.setText(userlist.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        if (userlist !=null){
            return userlist.size();
        }
        return  0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvid;
        TextView tvnmae;
        TextView tvemail;
        TextView tvgender;
        TextView tvststus;

        public ViewHolder( View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.txt_id);
            tvnmae = itemView.findViewById(R.id.txt_name);
            tvemail = itemView.findViewById(R.id.txt_email);
            tvgender = itemView.findViewById(R.id.txt_gender);
            tvststus = itemView.findViewById(R.id.txt_sat);

        }
    }
}
