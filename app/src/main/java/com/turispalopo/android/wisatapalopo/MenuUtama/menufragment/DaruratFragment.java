package com.turispalopo.android.wisatapalopo.MenuUtama.menufragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turispalopo.android.wisatapalopo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaruratFragment extends Fragment {


    public DaruratFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_darurat, container, false);

        //Tombol Panggilan Darurat
        CardView polisi = (CardView) view.findViewById(R.id.card_polisi);
        polisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047121110"));
                startActivity(intent);
            }
        });

        CardView rumahsakit = (CardView) view.findViewById(R.id.card_rumah_sakit);
        rumahsakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047124356"));
                startActivity(intent);
            }
        });


        CardView pemadam = (CardView) view.findViewById(R.id.card_pemadam);
        pemadam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047122501"));
                startActivity(intent);
            }
        });

        CardView pdam = (CardView) view.findViewById(R.id.card_pdam);
        pdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047121247"));
                startActivity(intent);
            }
        });

        CardView pln = (CardView) view.findViewById(R.id.card_pln);
        pln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047124001"));
                startActivity(intent);
            }
        });

        CardView pmi = (CardView) view.findViewById(R.id.card_pmi);
        pmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047124678"));
                startActivity(intent);
            }
        });

        CardView telkom = (CardView) view.findViewById(R.id.card_telkom);
        telkom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:047123900"));
                startActivity(intent);
            }
        });

        CardView peneranganjalan = (CardView) view.findViewById(R.id.card_penerangan_jalan);
        peneranganjalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0471351188"));
                startActivity(intent);
            }
        });

        return view;
    }
}
