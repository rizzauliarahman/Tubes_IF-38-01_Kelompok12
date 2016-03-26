package Model;

import java.io.Serializable;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rizza
 */
public class Tiket implements Serializable {
    private int tipeTiket, idTiket;
    private long hargaTiket;
    private String jenisTiket;
    private GregorianCalendar tglBerangkat;
    private static int nTiket = 3000;
    private Kereta kereta;
    private Gerbong gerbong;

    public Tiket(GregorianCalendar tanggal, int tipeTiket, long hargaTiket, Kereta kereta, Gerbong gerbong) {
        this.tipeTiket = tipeTiket;
        this.hargaTiket = hargaTiket;
        this.tglBerangkat = tanggal;
        this.kereta = kereta;
        this.gerbong = gerbong;
        idTiket = nTiket;
        nTiket++;
        if (this.tipeTiket == 1) {
            jenisTiket = "Eksekutif";
        } else if (this.tipeTiket == 2) {
            jenisTiket = "Bisnis";
        } else {
            jenisTiket = "Ekonomi";
        }
    }

    public Gerbong getGerbong() {
        return gerbong;
    }

    public void setGerbong(Gerbong gerbong) {
        this.gerbong = gerbong;
    }

    /**
     * @return the tipeTiket
     */
    public int getTipeTiket() {
        return tipeTiket;
    }

    /**
     * @param tipeTiket the tipeTiket to set
     */
    public void setTipeTiket(int tipeTiket) {
        this.tipeTiket = tipeTiket;
        if (this.tipeTiket == 1) {
            jenisTiket = "Eksekutif";
        } else if (this.tipeTiket == 2) {
            jenisTiket = "Bisnis";
        } else {
            jenisTiket = "Ekonomi";
        }
    }

    /**
     * @return the hargaTiket
     */
    public long getHargaTiket() {
        return hargaTiket;
    }

    /**
     * @param hargaTiket the hargaTiket to set
     */
    public void setHargaTiket(long hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    /**
     * @return the tglBerangkat
     */
    public GregorianCalendar getTglBerangkat() {
        return tglBerangkat;
    }

    /**
     * @param tglBerangkat the tglBerangkat to set
     */
    public void setTglBerangkat(GregorianCalendar tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    /**
     * @return the idTiket
     */
    public int getIdTiket() {
        return idTiket;
    }

    /**
     * set idTiket with amount of nTiket and increment nTiket
     */
    public void setIdTiket() {
        idTiket = nTiket;
        nTiket++;
    }

    /**
     * @return the kereta
     */
    public Kereta getKereta() {
        return kereta;
    }

    /**
     * @return the jenisTiket
     */
    public String getJenisTiket() {
        return jenisTiket;
    }
}
