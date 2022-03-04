package com.example.study;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAdapter extends ArrayAdapter<Annonce> {
    public ListAdapter(Context context, ArrayList<Annonce> annonceArrayList) {
        super(context, R.layout.item_annonce,annonceArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Annonce annonce = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_annonce,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.trans_image);
        TextView typeTrans = convertView.findViewById(R.id.typeTrans);
        TextView tauTrans = convertView.findViewById(R.id.tauxTrans);
        TextView dateTrans = convertView.findViewById(R.id.dateTrans);
        TextView boujam3aAge = convertView.findViewById(R.id.boujem3aAge);


        imageView.setImageResource(annonce.getImageId());
        typeTrans.setText(annonce.getTitreAnnonce());
        tauTrans.setText(annonce.getFirstName());
        dateTrans.setText(annonce.getDateAnnonce());
        boujam3aAge.setText(annonce.getPrix());
        return convertView;
    }
}


