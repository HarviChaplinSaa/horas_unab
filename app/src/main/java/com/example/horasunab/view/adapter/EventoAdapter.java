package com.example.horasunab.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter {

    private List<Evento> listadoEvento;
    private OnItemClickListener OnItemClickListener;

    public EventoAdapter(List<Evento> listadoEventos) {
        this.listadoEvento = listadoEventos;
    }

    public class EventoViewHolder extends RecyclerView.ViewHolder{

        ImageView ivEvento;
        TextView tvTitulo, tvHoras;

        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);

            ivEvento = itemView.findViewById(R.id.iv_list_item);
            tvTitulo = itemView.findViewById(R.id.tv_list_name_item);
            tvHoras = itemView.findViewById(R.id.tv_list_amount_item);

        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mivista = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item, parent, false);

        return new EventoViewHolder(mivista);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Evento miEvento = listadoEvento.get(position);
        EventoViewHolder miHolder = (EventoViewHolder) holder;
        miHolder.tvTitulo.setText(miEvento.getNombreEvento());
        String text = miHolder.itemView.getContext().getString(R.string.txt_detail_hora, String.valueOf(miEvento.getHoraEvento()));
        miHolder.tvHoras.setText(text);
        Glide.with(miHolder.itemView.getContext()).load(miEvento.getUrlImagen()).into(miHolder.ivEvento);

        miHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OnItemClickListener!= null){
                    OnItemClickListener.OnItemClick(miEvento)   ;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoEvento.size();
    }



    public interface OnItemClickListener{
        void OnItemClick(Evento miEvento);
    }


    public void setOnItemClickListener(EventoAdapter.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }


    public void setListadoEvento(List<Evento> listadoEvento) {
        this.listadoEvento = listadoEvento;
        notifyDataSetChanged();
    }
}
