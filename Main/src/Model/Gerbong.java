/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Rizza
 */
public class Gerbong implements Serializable {
    private int kapasitas, tipeGerbong, idGerbong;
    private String jenisGerbong;
    private static int nGerbong = 1000;
    private long harga;

    public static int getnGerbong() {
        return nGerbong;
    }

    public static void setnGerbong(int nGerbong) {
        Gerbong.nGerbong = nGerbong;
    }
    
    public Gerbong (int kapasitas, int tipe, long harga) {
        tipeGerbong = tipe;
        if (tipeGerbong == 1) {
            jenisGerbong = "Eksekutif";
        } else if (tipeGerbong == 2) {
            jenisGerbong = "Bisnis";
        } else {
            jenisGerbong = "Ekonomi";
        }
        idGerbong = nGerbong;
        this.kapasitas = kapasitas;
        this.harga = harga;
        nGerbong++;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    /**
     * @return the kapasitas
     */
    public int getKapasitas() {
        return kapasitas;
    }

    /**
     * @param kapasitas the kapasitas to set
     */
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    /**
     * @return the tipeGerbong
     */
    public int getTipeGerbong() {
        return tipeGerbong;
    }

    /**
     * @param tipeGerbong the tipeGerbong to set
     */
    public void setTipeGerbong(int tipeGerbong) {
        this.tipeGerbong = tipeGerbong;
        if (tipeGerbong == 1) {
            jenisGerbong = "Eksekutif";
        } else if (tipeGerbong == 2) {
            jenisGerbong = "Bisnis";
        } else {
            jenisGerbong = "Ekonomi";
        }
    }

    /**
     * @return the jenisGerbong
     */
    public String getJenisGerbong() {
        return jenisGerbong;
    }

    /**
     * @return the idGerbong
     */
    public int getIdGerbong() {
        return idGerbong;
    }

    /**
     * @set the idGerbong with the amount of nGerbong and increment nGerbong
     */
    public void setIdGerbong() {
        this.idGerbong = nGerbong;
        nGerbong++;
    }
    
    public void tampil() {
        System.out.println("ID Gerbong : "+this.idGerbong);
        System.out.println("Jenis Gerbong : "+this.jenisGerbong);
        System.out.println("Kapasitas : "+this.kapasitas);
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "ID Gerbong : "+this.idGerbong+", Jenis Gerbong : "+this.jenisGerbong+", Kapasitas : "+this.kapasitas;
    }
}
