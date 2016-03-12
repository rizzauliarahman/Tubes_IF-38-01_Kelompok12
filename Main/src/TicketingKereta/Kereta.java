/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketingKereta;

/**
 *
 * @author Rizza
 */
public class Kereta {
    private String namaKereta, jenisKereta;
    private int idKereta, tipeKereta, nGerbong;
    private int nKereta = 5000;
    Gerbong[] daftarGerbong;

    public Kereta(String namaKereta, int tipeKereta, int maxGerbong) {
        this.namaKereta = namaKereta;
        daftarGerbong = new Gerbong[maxGerbong];
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
        if (nGerbong < daftarGerbong.length) {
            daftarGerbong[nGerbong] = g;
            nGerbong++;
        } else {
            System.out.println("Gerbong sudah penuh");
        }
    }

    public Gerbong getGerbong (int idx) {
        return daftarGerbong[idx];
    }
    
    public void removeGerbong (int id) {
        int i = 0;
        while ((daftarGerbong[i].getIdGerbong() != id) && (i < nGerbong)) {
            i++;
        }
        if (daftarGerbong[i].getIdGerbong() != id) {
            System.out.println("Gerbong tidak ditemukan");
        } else {
            daftarGerbong[i] = null;
            nGerbong--;
        }
    }
}
