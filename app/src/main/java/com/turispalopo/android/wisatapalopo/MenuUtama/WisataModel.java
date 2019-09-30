package com.turispalopo.android.wisatapalopo.MenuUtama;

public class WisataModel {
     String Wisata, Alamat, Deskripsi, Foto;

    public WisataModel(String wisata, String alamat, String deskripsi, String foto) {
        Wisata = wisata;
        Alamat = alamat;
        Deskripsi = deskripsi;
        Foto = foto;
    }

    //constructor
    public WisataModel(){}

    public String getWisata() {
        return Wisata;
    }

    public void setWisata(String wisata) {
        Wisata = wisata;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }
}