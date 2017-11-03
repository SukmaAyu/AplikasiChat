package com.uts.sukma.aplikasichat;

/**
 * Created by Sukma on 03/11/2017.
 */

public class Chat {
    private String Pengirim;
    private String Pesan;
    private String Tanggal;
    private int Gambar;

    public String getPengirim() {
        return Pengirim;
    }

    public void setPengirim(String pengirim) {
        Pengirim = pengirim;
    }

    public String getPesan() {
        return Pesan;
    }

    public void setPesan(String pesan) {
        Pesan = pesan;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public class Chat(String pesan, pengirim, tanggal, int gambar){
        this.Pesan = pesan;
        this.Pengirim = pengirim;
        this.Tanggal = tanggal;
        this.Gambar = gambar;
    }
}
