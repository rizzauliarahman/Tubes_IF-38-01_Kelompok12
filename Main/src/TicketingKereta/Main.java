/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketingKereta;

import java.util.*;
import java.text.*;

/**
 *
 * @author Rizza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat formDate = new SimpleDateFormat("yyyy, MMMM dd");
        Gerbong g1 = new Gerbong(1);
        g1.setKapasitas(40);
        Gerbong g2 = new Gerbong(1);
        g2.setKapasitas(50);
        Gerbong g3 = new Gerbong(1);
        g3.setKapasitas(40);
        Gerbong g4 = new Gerbong(2);
        g4.setKapasitas(60);
        Gerbong g5 = new Gerbong(2);
        g5.setKapasitas(50);
        Gerbong g6 = new Gerbong(3);
        g6.setKapasitas(60);
        Gerbong g7 = new Gerbong(3);
        g7.setKapasitas(60);
        Kereta k1 = new Kereta("Argo Lawu",2);
        k1.addGerbong(g1);
        k1.addGerbong(g2);
        k1.addGerbong(g3);
        k1.addGerbong(g4);
        k1.addGerbong(g5);
        k1.addGerbong(g6);
        k1.addGerbong(g7);
        Stasiun s1 = new Stasiun("Semarang Tawang","SMT",4099);
        s1.setAlamat("Ronggowarsito");
        s1.setJumlahJalur(7);
        s1.setKota("Semarang");
        s1.setTahunPbangunan(1881);
        Stasiun s2 = new Stasiun("Irian Amoy","IAY",3669);
        s2.setAlamat("Merauke");
        s2.setJumlahJalur(5);
        s2.setKota("Merauke");
        s2.setTahunPbangunan(2000);
        Rute r1 = new Rute("Pantura",350);
        Date dt1 = new Date(((16)+100), 2, 28);
        r1.setStasiun1(s1);
        r1.setStasiun2(s2);
        r1.addKereta(k1);
        r1.createTicket(dt1, 1, 400000, k1.getIdKereta());
        
        System.out.println("Rute");
        System.out.println("Nama Rute : "+r1.getNamaRute());
        System.out.println("Stasiun 1 : "+r1.getStasiun1().getNamaStasiun());
        System.out.println("Alamat : "+r1.getStasiun1().getAlamat());
        System.out.println("Kota : "+r1.getStasiun1().getKota());
        System.out.println("==========================================");
        System.out.println("Stasiun 2 : "+r1.getStasiun2().getNamaStasiun());
        System.out.println("Alamat : "+r1.getStasiun2().getAlamat());
        System.out.println("Kota : "+r1.getStasiun2().getKota());
        System.out.println();
        for (int i = 0; i < r1.getnTiket(); i++) {
            System.out.println("Tiket "+(i+1));
            System.out.println("ID Tiket : "+r1.daftarTiketDibeli[i].getIdTiket());
            System.out.println("Tgl Berangkat : "+formDate.format(r1.daftarTiketDibeli[i].getTglBerangkat()));
            System.out.println("Kereta : "+r1.daftarTiketDibeli[i].getKereta().getNamaKereta());
            System.out.println("Jenis Kereta : "+r1.daftarTiketDibeli[i].getKereta().getJenisKereta());
            System.out.println("Jenis Gerbong : "+r1.daftarTiketDibeli[i].getJenisTiket());
            System.out.println("Harga : "+r1.daftarTiketDibeli[i].getHargaTiket());
        }
    }
    
}
