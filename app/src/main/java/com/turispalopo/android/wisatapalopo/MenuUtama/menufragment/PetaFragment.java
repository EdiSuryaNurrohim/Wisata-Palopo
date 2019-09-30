package com.turispalopo.android.wisatapalopo.MenuUtama.menufragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.turispalopo.android.wisatapalopo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetaFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment mapFrag;

    public PetaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peta, container, false);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.peta_lokasi_activity);
        mapFrag.getMapAsync(this);
        return view;

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //Saat Load Peta Sukses
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapLoaded() {
                //Kode Lokasi Untuk Marker
                List<LatLng> locations = new ArrayList<>();
                //locations.add(new LatLng(24.5572298, 67.8388739)); // GPS Lokasi Saya
                locations.add(new LatLng(-3.0093063, 120.2004605)); // Lapangan Pancasila
                locations.add(new LatLng(-3.0350633, 120.180282)); //Lereng Cinta
                locations.add(new LatLng(-3.008611,  120.1387969)); //Bukit Kambo Highland Benteng
                locations.add(new LatLng(-2.9865556, 120.1548342)); //Bukit 513
                locations.add(new LatLng(-2.9306074, 120.1325063)); //Batu Papan
                locations.add(new LatLng(-2.9941707, 120.1951648)); //Masjid Jami' Tua Palopo
                locations.add(new LatLng(-3.0255439, 120.1313698)); //Air Terjun Latuppa
                locations.add(new LatLng(-2.994425,  120.1963429)); //Istana Kedatuan Luwu
                locations.add(new LatLng(-3.005971,  120.147198));  //Bukit Puncak Kambo
                locations.add(new LatLng(-3.0014498, 120.2154088)); //Pantai Labombo
                locations.add(new LatLng(-2.9649115, 120.2006998)); //Pulau Libukang
                locations.add(new LatLng(-2.986131,  120.2035848)); //Pelabuhan Tanjung Ringgit
                locations.add(new LatLng(-3.0240356, 120.1739357)); //Kolam Renang Agro Wisata
                locations.add(new LatLng(-3.0122749, 120.2051765)); //Taman I Love City Palopo
                locations.add(new LatLng(-2.9925,    120.19694)); //Pusat Kota Palopo
                locations.add(new LatLng(-2.994466,  120.196483)); // Museum Batara Guru

                for (LatLng latLng : locations) {
                    //GPS Lokasi
                    // LatLng gps = new LatLng(24.5572298, 67.8388739);
                    // mMap.addMarker(new MarkerOptions().position(gps).title("Lokasi Saya"));
                    //Lapangan Pancasila
                    LatLng pancasila = new LatLng(-3.0086047, 120.1954107);
                    mMap.addMarker(new MarkerOptions().position(pancasila).title("Lapangan Pancasila"));
                    //Lereng Cinta
                    LatLng lerengcinta = new LatLng(-3.0351591, 120.1787253);
                    mMap.addMarker(new MarkerOptions().position(lerengcinta).title("Lereng Cinta"));
                    //Benteng Bukit Kambo Resort
                    LatLng bentengkambo = new LatLng(-3.0143725, 120.1534828);
                    mMap.addMarker(new MarkerOptions().position(bentengkambo).title("Benteng Bukit Kambo Resort"));
                    //Bukit513
                    LatLng bukit513 = new LatLng(-2.9865905, 120.1528032);
                    mMap.addMarker(new MarkerOptions().position(bukit513).title("Bukit 513"));
                    //Batu Papan
                    LatLng batupapan = new LatLng(-2.9281895, 120.1163215);
                    mMap.addMarker(new MarkerOptions().position(batupapan).title("Batu Papan"));
                    //Masjid Jami' Tua Palopo
                    LatLng masjidjamitua = new LatLng(-2.9941211, 120.1931182);
                    mMap.addMarker(new MarkerOptions().position(masjidjamitua).title("Masjid Jami' Tua"));
                    //Air Terjun Latuppa
                    LatLng airterjunlatuppa = new LatLng(-3.0256939, 120.1297256);
                    mMap.addMarker(new MarkerOptions().position(airterjunlatuppa).title("Air Terjun Latuppa"));
                    //Istana Kedatuan Luwu
                    LatLng istanakedatuan = new LatLng(-2.9944785, 120.1942937);
                    mMap.addMarker(new MarkerOptions().position(istanakedatuan).title("Istana Kedatuan Luwu"));
                    //Bukit Puncak Kambo
                    LatLng puncakkambo = new LatLng(-3.047549, 120.2086682);
                    mMap.addMarker(new MarkerOptions().position(puncakkambo).title("Bukit Puncak Kambo"));
                    //Pantai Labombo
                    LatLng pantailabombo = new LatLng(-3.0014444, 120.2132201);
                    mMap.addMarker(new MarkerOptions().position(pantailabombo).title("Pantai Labombo"));
                    //Pulau Libukang
                    LatLng pulaulibukang = new LatLng(-2.9649785, 120.1920785);
                    mMap.addMarker(new MarkerOptions().position(pulaulibukang).title("Pulau Libukang"));
                    //Pelabuhan Tanjung Ringgit
                    LatLng pelabuhantanjungringgit = new LatLng(-2.9881689, 120.1998637);
                    mMap.addMarker(new MarkerOptions().position(pelabuhantanjungringgit).title("Pelabuhan Tanjung Ringgit"));
                    //Kolam Renang Agrowisata
                    LatLng kolamrenangagro = new LatLng(-3.0243858, 120.1740937);
                    mMap.addMarker(new MarkerOptions().position(kolamrenangagro).title("Kolam Renang Agrowisata"));
                    //Taman I Love City Palopo
                    LatLng tamanilove = new LatLng(-3.0122857, 120.2053022);
                    mMap.addMarker(new MarkerOptions().position(tamanilove).title("Taman I Love City Palopo"));
                    // Kota Palopo Pusat
                    LatLng Palopo = new LatLng(-2.9925, 120.19694);
                    mMap.addMarker(new MarkerOptions().position(Palopo).title("Titik Nol Kota Palopo"));
                    //Museum Batara Guru
                    LatLng MuseumBatara = new LatLng(-2.9954447,120.1923036);
                    mMap.addMarker(new MarkerOptions().position(MuseumBatara).title("Museum Batara Guru"));

                }

                //LatLngBound will cover all your marker on Google Maps
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(locations.get(0)); //Taking Point A (First LatLng)
                builder.include(locations.get(locations.size() - 1)); //Taking Point B (Second LatLng)
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.getUiSettings().setZoomGesturesEnabled(true);
                mMap.getUiSettings().setCompassEnabled(true);
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                mMap.moveCamera(cu);
                mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

            }
        });
    }
}
