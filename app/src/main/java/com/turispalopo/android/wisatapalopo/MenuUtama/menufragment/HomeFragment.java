package com.turispalopo.android.wisatapalopo.MenuUtama.menufragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.turispalopo.android.wisatapalopo.MenuUtama.AdapterTampilan;
import com.turispalopo.android.wisatapalopo.MenuUtama.WisataModel;
import com.turispalopo.android.wisatapalopo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView postRecyclerView;
    AdapterTampilan adapterTampilan;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<WisataModel>  postList;
    TextView tvNamaWisata;
    ImageView imgFoto;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        postRecyclerView = view.findViewById(R.id.postsRecycleView);
        postRecyclerView.setHasFixedSize(true);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("WisataPalopo");

        tvNamaWisata = view.findViewById(R.id.tvNamaWisata);
        imgFoto = view.findViewById(R.id.imgFoto);



        return view;
    }
    @Override
    public void onStart(){
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList = new ArrayList<>();
                for (DataSnapshot postsnap : dataSnapshot.getChildren()){

                    WisataModel wisataModel = postsnap.getValue(WisataModel.class);
                    postList.add(wisataModel);
                }

                adapterTampilan = new AdapterTampilan(getActivity(), postList);
                postRecyclerView.setAdapter(adapterTampilan);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
