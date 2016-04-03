/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import java.io.*;
import View.*;
import Model.*;
import java.io.ObjectOutputStream;

/**
 *
 * @author Rizza
 */
public class Driver implements Serializable {
    public static void main(String[] args) throws Exception {
        Application a = new Application();
        a.daftarStasiun = (List<Stasiun>) a.readFile("Stasiun.dat");
        a.daftarRute = (List<Rute>) a.readFile("Rute.dat");
        a.daftarKereta = (List<Kereta>) a.readFile("Kereta.dat");
        a.daftarGerbong = (List<Gerbong>) a.readFile("Gerbong.dat");
        Kereta.setnKereta((int) a.readFile("nKereta.dat"));
        Gerbong.setnGerbong((int) a.readFile("nGerbong.dat"));
        Tiket.setnTiket((int) a.readFile("nTiket.dat"));
        a.mainMenu();
        a.writeFile(a.daftarStasiun, "Stasiun.dat");
        a.writeFile(a.daftarRute, "Rute.dat");
        a.writeFile(a.daftarKereta, "Kereta.dat");
        a.writeFile(a.daftarGerbong, "Gerbong.dat");
        a.writeFile(Gerbong.getnGerbong(), "nGerbong.dat");
        a.writeFile(Kereta.getnKereta(), "nKereta.dat");
        a.writeFile(Tiket.getnTiket(), "nTiket.dat");
    }
}
