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
        a.daftarStasiun = (List<Stasiun>) a.readFile("Stasiun.txt");
        a.daftarRute = (List<Rute>) a.readFile("Rute.txt");
        a.daftarKereta = (List<Kereta>) a.readFile("Kereta.txt");
        a.daftarGerbong = (List<Gerbong>) a.readFile("Gerbong.txt");
        a.mainMenu();
        a.writeFile(a.daftarStasiun, "Stasiun.txt");
        a.writeFile(a.daftarRute, "Rute.txt");
        a.writeFile(a.daftarKereta, "Kereta.txt");
        a.writeFile(a.daftarGerbong, "Gerbong.txt");
        a.writeFile(Gerbong.getnGerbong(), "objGerbong.txt");
    }
}
