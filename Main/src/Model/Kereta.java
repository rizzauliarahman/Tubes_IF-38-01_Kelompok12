/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Rizza
 */
public class Kereta implements Serializable {
    private String namaKereta, jenisKereta;
    private int idKereta, tipeKereta, nGerbong;
    private static int nKereta = 5000;
    List<Gerbong> daftarGerbong = new ArrayList<Gerbong>();

    public Kereta(String namaKereta, int tipeKereta) {
        this.namaKereta = namaKereta;
        this.idKereta = nKereta;
        nKereta++;
        this.tipeKereta = tipeKereta;
        if (this.tipeKereta == 1) {
            jenisKereta = "Kereta Listrik";
        } else jenisKereta = "Kereta Diesel";
    }

    /**
     * @return the namaKereta
     */
    public String getNamaKereta() {
        return namaKereta;
    }

    /**
     * @param namaKereta the namaKereta to set
     */
    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    /**
     * @return the jenisKereta
     */
    public String getJenisKereta() {
        return jenisKereta;
    }

    /**
     * @return the idKereta
     */
    public int getIdKereta() {
        return idKereta;
    }

    /**
     * set idKereta with the amount of nKereta and increment idKereta
     * @param idKereta
     */
    public void setIdKereta(int idKereta) {
        this.idKereta = nKereta;
        nKereta++;
    }

    /**
     * @return the tipeKereta
     */
    public int getTipeKereta() {
        return tipeKereta;
    }

    /**
     * @param tipeKereta the tipeKereta to set
     */
    public void setTipeKereta(int tipeKereta) {
        this.tipeKereta = tipeKereta;
    }

    /**
     * @return the nKereta
     */
    public int getnKereta() {
        return nKereta;
    }
    
    public void addGerbong (Gerbong g) {
        daftarGerbong.add(g);
        nGerbong++;
    }

    public Gerbong getGerbong (int id) {
        return daftarGerbong.stream().filter((Gerbong o) -> o.getIdGerbong() == id).findFirst().orElse(null);
    }
    
    public void removeGerbong (int id) {
          daftarGerbong.removeIf(o -> o.getIdGerbong() == id);
    }
    
    public void tampil () {
        System.out.println("Nama Kereta : "+this.namaKereta);
        System.out.println("Jenis Kereta : "+this.jenisKereta);
        System.out.println("Jumlah Gerbong : "+this.nGerbong);
        System.out.println();
    }
    
    public void tampilDetil () {
        System.out.println("Nama Kereta : "+this.namaKereta);
        System.out.println("Jenis Kereta : "+this.jenisKereta);
        System.out.println("ID : "+this.idKereta);
        System.out.println("Jumlah Gerbong : "+this.nGerbong);
        daftarGerbong.forEach((Gerbong o) -> System.out.println(o));
    }
    
    @Override
    public String toString() {
        return "ID : "+this.idKereta+", Kereta "+this.namaKereta+" Jumlah Gerbong "+this.nGerbong;
    }
    
}
