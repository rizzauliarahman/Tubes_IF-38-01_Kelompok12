package Model;

import java.util.*;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizza
 */
public class Rute implements Serializable {
    private String namaRute;
    private Stasiun stasiun1;
    private Stasiun stasiun2;
    List<Tiket> daftarTiket = new ArrayList<Tiket>();
    List<Kereta> daftarKereta =  new ArrayList<Kereta>();
    private int nTiket, nKereta;

    public Rute(String namaRute) {
        this.namaRute = namaRute;
    }

    /**
     * @return the namaRute
     */
    public String getNamaRute() {
        return namaRute;
    }

    /**
     * @param namaRute the namaRute to set
     */
    public void setNamaRute(String namaRute) {
        this.namaRute = namaRute;
    }

    /**
     * @return the stasiun1
     */
    public Stasiun getStasiun1() {
        return stasiun1;
    }

    /**
     * @param stasiun1 the stasiun1 to set
     */
    public void setStasiun1(Stasiun stasiun1) {
        this.stasiun1 = stasiun1;
    }

    /**
     * @return the stasiun2
     */
    public Stasiun getStasiun2() {
        return stasiun2;
    }

    /**
     * @param stasiun2 the stasiun2 to set
     */
    public void setStasiun2(Stasiun stasiun2) {
        this.stasiun2 = stasiun2;
    }

    /**
     * @return the nTiket
     */
    public int getnTiket() {
        return nTiket;
    }
    
    public void createTicket(GregorianCalendar tanggal, int tipeTiket, long hargaTiket, Kereta kereta, Gerbong gerbong) {
        Tiket t = new Tiket(tanggal, tipeTiket, hargaTiket, kereta, gerbong);
        daftarTiket.add(t);
        nTiket++;
    }
    
    public void addKereta (Kereta k) {
        daftarKereta.add(k);
    }
    
    public Kereta getKereta (String namaKereta) {
        return daftarKereta.stream().filter((Kereta o) -> (o.getNamaKereta().toUpperCase()).equals((namaKereta).toUpperCase())).findFirst().orElse(null);
    }
    
    /**
     *
     * @param idx
     * @return
     */
    public Tiket getTiket (int idx) {
        return daftarTiket.get(idx);
    }
    
    public void tampil() {
        System.out.println("Nama Rute : "+this.namaRute);
        System.out.println("Stasiun 1");
        this.stasiun1.tampil();
        System.out.println("Stasiun 2");
        this.stasiun2.tampil();
        System.out.println("Jumlah Tiket Total : "+daftarTiket.size());
        daftarKereta.forEach((Kereta o) -> System.out.println(o));
    }
    
    public void printDaftarKereta () {
        daftarKereta.forEach((Kereta o) -> System.out.println(o));
    }
}
