package com.uts.sukma.aplikasichat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Sukma on 03/11/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.CAdapter> {
    JSONArray jsonArray;


    @Override
    public ChatAdapter.CAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daftar_chat,parent,false);
        return new CAdapter(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.CAdapter holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.gambar.setImageResource(jsonObject.getInt("Foto"));
            holder.nama.setText(jsonObject.getString("Pengirim"));
            holder.pesan.setText(jsonObject.getString("Content"));
            holder.tanggal.setText(jsonObject.getString("Waktu"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class CAdapter {
        ImageView gambar;
        TextView nama, pesan, tanggal;
        public CAdapter(View itemView) {
            super(itemView);
            gambar = (ImageView) itemView.findViewById(R.id.gambar2);
            nama = (TextView) itemView.findViewById(R.id.pengirim);
            pesan = (TextView) itemView.findViewById(R.id.pesan);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
        }
    }
}
