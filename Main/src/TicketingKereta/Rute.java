
package TicketingKereta;
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
public class Rute {
    private String namaRute;
    private Stasiun stasiun1;
    private Stasiun stasiun2;
    Tiket[] daftarTiketDibeli;
    List<Kereta> daftarKereta;
    private int nTiket, nKereta;

    public Rute(String namaRute, int maxTiket) {
        this.namaRute = namaRute;
        daftarTiketDibeli = new Tiket[maxTiket];
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
    
    public void createTicket(Date tanggal, int tipeTiket, long hargaTiket, int idKereta) {
        int i = 0;
        Kereta a = daftarKereta.get(i);
        while ((a.getIdKereta() != idKereta)) {
            i++;
            a = daftarKereta.get(i);
        }
        if (a.getIdKereta() == idKereta) {
            a = daftarKereta.get(i);
            if (nTiket < daftarTiketDibeli.length) { 
                daftarTiketDibeli[nTiket] = new Tiket(tanggal, tipeTiket, hargaTiket, a);
            } else {
                System.out.println("Sudah tidak ada tiket tersedia");
            }
        } else {
            System.out.println("Kereta tsb tidak tersedia dalam rute ini");
        }
        nTiket++;
    }
    
    public void addKereta (Kereta k) {
        daftarKereta.add(k);
    }
    
    /**
     *
     * @param idx
     * @return
     */
    public Tiket getTiket (int idx) {
        return daftarTiketDibeli[idx];
    }
}
