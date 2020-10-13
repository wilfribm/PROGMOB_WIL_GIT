package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MahasiswaCardAdapter extends RecyclerView.Adapter<MahasiswaCardAdapter.ViewHolder> {

    private Context context;
    private List<Mahasiswa> mahasiswaCard;


    public MahasiswaCardAdapter(Context context) {
        this.context = context;
        mahasiswaCard = new ArrayList<>();

    }

    public List<Mahasiswa> getMahasiswaCard() {
        return mahasiswaCard;
    }

    public void setMahasiswaCard(List<Mahasiswa> mahasiswaCard) {
        this.mahasiswaCard = mahasiswaCard;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Mahasiswa m = mahasiswaCard.get(i);

        viewHolder.tvNama.setText(m.getNama());
        viewHolder.tvNim.setText(m.getNim());
        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return mahasiswaCard.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama,tvNim,tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNoTelp  = itemView.findViewById(R.id.tvNoTelp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),tvNama.getText(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
