/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Struct;
import java.util.*;
import java.text.*;

/**
 *
 * @author Rizza
 */
public class Application {
    public List<Stasiun> daftarStasiun = new ArrayList<Stasiun>();
    public List<Kereta> daftarKereta = new ArrayList<Kereta>();
    public List<Rute> daftarRute = new ArrayList<Rute>();
    public List<Gerbong> daftarGerbong = new ArrayList<Gerbong>();
    
    public void writeFile (Object o, String filename) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(filename)){
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(o);
            oout.close();
        }
    }
    
    public void writeFile (List o, String filename) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(filename)){
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(o);
            oout.close();
        }
    }
    
    public Object readFile (String filename) throws Exception {
        Object o;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            o = (ArrayList) ois.readObject();
            ois.close();
        }
        return o;
    }
    
    public void menuAddRute (Rute r) {
        daftarRute.add(r);
    }
    
    public Rute menuSearchRute (String namaRute) {
        return daftarRute.stream().filter((Rute o) -> ((o.getNamaRute().toUpperCase()).equals((namaRute).toUpperCase()))).findFirst().orElse(null);
    }
    
    public void menuDeleteRute (Rute r) {
        daftarRute.remove(r);
    }
    
    public void menuAddStasiun (Stasiun s) {
        daftarStasiun.add(s);        
    }
        
    public Stasiun menuSearchStasiun(int noStasiun) {
        return daftarStasiun.stream().filter((Stasiun o) -> (o.getNomorStasiun() == noStasiun)).findFirst().orElse(null);
    }
    
    public void menuDeleteStasiun (Stasiun s) {
        daftarStasiun.remove(s);
    }
    
    public void menuAddKereta (String nama, int tipe) {
        Kereta k = new Kereta(nama,tipe);
        daftarKereta.add(k);
    }
    
    public Kereta menuSearchKereta (String str) {
        return daftarKereta.stream().filter((Kereta o) -> (o.getNamaKereta().toUpperCase()).equals((str).toUpperCase())).findFirst().orElse(null);
    }
    
    public void menuDeleteKereta (Kereta k) {
        daftarKereta.remove(k);
    }
    
    public void menuAddGerbong (int kapasitas, int tipe, long harga) {
        Gerbong g = new Gerbong(kapasitas,tipe,harga);
        daftarGerbong.add(g);
    }
    
    public Gerbong menuSearchGerbong (int id) {
        return daftarGerbong.stream().filter((Gerbong o) -> o.getIdGerbong() == id).findFirst().orElse(null);
    }
    
    public void menuDeleteGerbong (int id) {
        daftarGerbong.removeIf(o -> o.getIdGerbong() == id);
    }
    
    public void menuViewAllGerbong () {
        daftarGerbong.forEach((Gerbong o) -> System.out.println(o));
    }
    
    public boolean isValidFormat (String format, long value) {
        Date date = null;
        String strValue = Long.toString(value);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(strValue);
            if (!strValue.equals(sdf.format(date))) {
                date = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date != null;
    }
    
    public void tampilMenuEditStasiun() {
        int pilih;
        boolean check = false;
        do {         
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int noStasiun = 0;
            Stasiun s;
            pilih = 0;
            String namaStasiun, alamat, kota, singkatan;
            System.out.println("Edit Data Stasiun");
            System.out.println("1. Tambahkan Stasiun Baru");
            System.out.println("2. Cari Stasiun");
            System.out.println("0. Kembali ke Menu Awal");
            System.out.println();                
            System.out.print("Pilihan menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah");
                continue;
            }                
            System.out.println();
            switch (pilih) {
                case 1 :
                {       
                    System.out.println("Tambahkan Stasiun Baru");
                    do {
                        check = false;
                        System.out.print("Nomor Stasiun : ");
                        try {
                            s1 = new Scanner(System.in);
                            noStasiun = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                    } while (!check);
                    s = menuSearchStasiun(noStasiun);
                    if (s == null) {
                        System.out.print("Nama Stasiun : ");
                        namaStasiun = s2.nextLine();
                        System.out.print("Singkatan : ");
                        singkatan = s2.nextLine();
                        System.out.print("Alamat : ");
                        alamat = s2.nextLine();
                        System.out.print("Kota : ");
                        kota = s2.nextLine();
                        s = new Stasiun(namaStasiun, singkatan, noStasiun);
                        s.setAlamat(alamat);
                        s.setKota(kota);
                        daftarStasiun.add(s);
                    } else {
                        System.out.println();
                        tampilMenuCariStasiun(s);
                    }
                    break;
                }
                case 2 :
                {
                    do {                        
                        System.out.println("Edit Data Stasiun");
                        daftarStasiun.forEach((Stasiun o) -> o.tampil());
                        check = false;
                        System.out.print("Nomor Stasiun yang ingin di-edit : ");
                        try {
                            s1 = new Scanner(System.in);
                            noStasiun = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        s = menuSearchStasiun(noStasiun);
                        if (s == null) {
                            System.out.println("Stasiun dengan nomor tersebut tidak ada");
                        } else {
                            System.out.println();
                            tampilMenuCariStasiun(s);
                        }
                    } while (!check);
                    break;
                }
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    System.out.println();
                    break;
            }
            //check = s1.hasNextInt();
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuCariStasiun(Stasiun s) {
        boolean check = false;
        int pilih;
        do {         
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int nomor, jmlJalur, tahun;
            pilih = 0;
            String namaStasiun, singkatan, alamat, kota;
            System.out.println("Edit Stasiun");
            s.tampilDetil();
            System.out.println();
            System.out.println("1. Ubah Nama Stasiun");
            System.out.println("2. Ubah Singkatan");
            System.out.println("3. Ubah Nomor Stasiun");
            System.out.println("4. Ubah Alamat Stasiun");
            System.out.println("5. Ubah Kota Lokasi Stasiun");
            System.out.println("6. Ubah Jumlah Jalur");
            System.out.println("7. Ubah Tahun Pembangunan");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan Menu : ");
            try {
                s1.reset();
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah!");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.print("Masukkan Nama Stasiun : ");
                    namaStasiun = s2.nextLine();
                    s.setNamaStasiun(namaStasiun);
                    break;
                case 2 :
                    System.out.print("Masukkan Singkatan Stasiun : ");
                    singkatan = s2.nextLine();
                    s.setSingkatan(singkatan);
                    break;
                case 3 :
                    do {                        
                        check = false;
                        System.out.print("Masukkan Nomor Stasiun : ");
                        try {
                            s1 = new Scanner(System.in);
                            nomor = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }    
                        s.setNomorStasiun(nomor);
                    } while (!check);
                    break;
                case 4 :
                    System.out.print("Masukkan Alamat Stasiun : ");
                    alamat = s2.nextLine();
                    s.setAlamat(alamat);
                    break;
                case 5 :
                    System.out.print("Masukkan Kota Lokasi Stasiun : ");
                    kota = s2.nextLine();
                    s.setKota(kota);
                    break;
                case 6 :
                    do {                        
                        check = false;
                        System.out.print("Masukkan Jumlah Jalur Dalam Stasiun : ");
                        try {
                            s1 = new Scanner(System.in);
                            jmlJalur = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Pilihan Salah!");
                            continue;
                        }
                        s.setJumlahJalur(jmlJalur);
                    } while (!check);
                    break;
                case 7 :
                    do {                        
                        check = false;
                        System.out.print("Masukkan Tahun Pembangunan Stasiun : ");
                        tahun = s1.nextInt();
                        s.setTahunPbangunan(tahun);
                    } while (!check);
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    System.out.println();
                    break;
            }
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuEditKereta () {
        boolean check = false;
        int pilih;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int tipe;
            pilih = 0;
            String namaKereta;
            System.out.println("Edit Data Kereta");
            System.out.println("1. Tambahkan Kereta Baru");
            System.out.println("2. Cari Kereta");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.println("Tambahkan Kereta Baru");
                    System.out.print("Nama Kereta : ");
                    namaKereta = s2.nextLine();
                    Kereta k = menuSearchKereta(namaKereta);
                    if (k == null) {
                        do {                            
                            check = false;
                            System.out.print("Tipe Kereta (1 = Listrik, 2 = Diesel) : ");
                            try {
                                s1 = new Scanner(System.in);
                                tipe = s1.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Input Salah!");
                                continue;
                            }
                            if ((tipe != 1) && (tipe != 2)) {
                                System.out.println("Tipe Kereta Salah!");
                                check = false;
                            } else {                                
                                k = new Kereta(namaKereta, tipe);
                            }
                        } while (!check);
                        daftarKereta.add(k);
                    } else {
                        System.out.println();
                        tampilMenuCariKereta(k);
                    }
                    break;
                case 2 :
                    System.out.print("Nama Kereta yang ingin dicari : ");
                    namaKereta = s2.nextLine();
                    k = menuSearchKereta(namaKereta);
                    if (k == null) {
                        System.out.println("Kereta dengan nama tersebut tidak ada");
                    } else {
                        System.out.println();
                        tampilMenuCariKereta(k);
                    }
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah!");
                    break;
            }
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuCariKereta(Kereta k) {
        boolean check = false;
        int pilih = 0;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int tipe, idGerbong;
            String namaKereta;
            System.out.println("Edit Kereta");
            k.tampilDetil();
            System.out.println();
            System.out.println("1. Ubah Nama Kereta");
            System.out.println("2. Ubah Tipe Kereta");
            System.out.println("3. Tambahkan Gerbong");
            System.out.println("4. Hapus Gerbong");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan Menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah!");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.print("Masukkan Nama  Kereta : ");
                    namaKereta = s2.nextLine();
                    k.setNamaKereta(namaKereta);
                    break;
                case 2 :
                    do {                        
                        check = false;
                        System.out.print("Masukkan Tipe Kereta (1 = Listrik, 2 = Diesel) : ");
                        try {
                            s1 = new Scanner(System.in);
                            tipe = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        if ((tipe != 1) && (tipe != 2)) {
                            System.out.println("Tipe Kereta Salah!");
                            check = false;
                        } else {                            
                            k.setTipeKereta(tipe);
                        }
                    } while (!check);
                    break;
                case 3 :
                    menuViewAllGerbong();
                    Gerbong g = null;
                    do {                        
                        check = false;
                        System.out.print("Masukkan ID Gerbong yang akan ditambahkan : ");
                        try {
                            s1 = new Scanner(System.in);
                            idGerbong = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        g = menuSearchGerbong(idGerbong);
                        if (g != null) {
                            menuDeleteGerbong(g.getIdGerbong());
                            k.addGerbong(g);
                        } else {
                            System.out.println("Tidak ada Gerbong dengan ID tersebut");
                        }
                    } while (!check);
                    break;
                case 4 :
                    k.tampilDetil();
                    Gerbong a = null;
                    do {                        
                        check = false;
                        System.out.print("Masukkan ID Gerbong yang akan dihapus : ");
                        try {
                            s1 = new Scanner(System.in);
                            idGerbong = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        a = k.getGerbong(idGerbong);
                        if (a != null) {
                            menuAddGerbong(a.getKapasitas(), a.getTipeGerbong(), a.getHarga());
                            k.removeGerbong(idGerbong);
                        } else {
                            System.out.println("Gerbong dengan ID tersebut tidak ada");
                        }
                    } while (!check);
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    System.out.println();
                    break;
            }
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuEditRute () {
        boolean check = false;
        int pilih = 0;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int nomorStasiun1 = 0, nomorStasiun2 = 0;
            String namaRute;
            System.out.println("Edit Data Rute");
            System.out.println("1. Tambahkan Rute Baru");
            System.out.println("2. Cari Rute");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah!");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                    Stasiun st1, st2;
                    System.out.println("Tambahkan Rute Baru");
                    System.out.print("Nama Rute : ");
                    namaRute = s2.nextLine();
                    Rute r = menuSearchRute(namaRute);
                    if (r == null) {
                        r = new Rute(namaRute);
                        daftarStasiun.forEach((Stasiun o) -> System.out.println(o));
                        System.out.println();
                        do {                            
                            check = false;
                            System.out.print("Nomor Stasiun 1 : ");
                            try {
                                s1 = new Scanner(System.in);
                                nomorStasiun1 = s1.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Input Salah!");
                                continue;
                            }
                        } while (!check);
                        st1 = menuSearchStasiun(nomorStasiun1);
                        do {                            
                            check = false;
                            System.out.print("Nomor Stasiun 2 : ");
                            try {
                                s1 = new Scanner(System.in);
                                nomorStasiun2 = s1.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Input Salah!");
                                continue;
                            }
                            st2 = menuSearchStasiun(nomorStasiun2);
                            if ((st1 != null) && (st2 != null)) {
                                r.setStasiun1(st1);
                                r.setStasiun2(st2);
                            } else {
                                check = false;
                            }
                        } while (!check);
                        daftarRute.add(r);    
                    } else {
                        System.out.println();
                        tampilMenuCariRute(r);
                    }
                    break;
                case 2 :
                    System.out.print("Nama Rute yang ingin dicari : ");
                    namaRute = s2.nextLine();
                    r = menuSearchRute(namaRute);
                    if (r == null) {
                        System.out.println("Rute dengan nama tersebut tidak ada");
                    } else {
                        System.out.println();
                        tampilMenuCariRute(r);
                    }
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah!");
                    break;
            }
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuCariRute (Rute r) {
        boolean check;
        int pilih = 0;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int noStasiun1, noStasiun2;
            String namaRute, namaKereta;
            System.out.println("Edit Rute");
            r.tampil();
            System.out.println();
            System.out.println("1. Ubah Nama Rute");
            System.out.println("2. Ubah Stasiun 1");
            System.out.println("3. Ubah Stasiun 2");
            System.out.println("4. Tambahkan Kereta yang Tersedia");
            System.out.println();
            System.out.print("Pilihan Menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah!");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.print("Masukkan Nama Rute : ");
                    namaRute = s2.nextLine();
                    r.setNamaRute(namaRute);
                    break;
                case 2 :
                    Stasiun st1 = null;
                    do {
                        daftarStasiun.forEach((Stasiun o) -> System.out.println(o));
                        System.out.println();
                        check = false;
                        System.out.print("Masukkan Nomor Stasiun 1 : ");
                        try {
                            s1 = new Scanner(System.in);
                            noStasiun1 = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah");
                            continue;
                        }
                        st1 = menuSearchStasiun(noStasiun1);
                        if (st1 != null) {
                            r.setStasiun1(st1);
                        } else {
                            System.out.println("Stasiun tidak ditemukan!");
                            System.out.println();
                        }
                    } while ((!check) || (st1 == null));
                    break;
                case 3 :
                    Stasiun st2 = null;
                    do {
                        daftarStasiun.forEach((Stasiun o) -> System.out.println(o));
                        System.out.println();
                        check = false;
                        System.out.print("Masukkan Nomor Stasiun 2 : ");
                        try {
                            s1 = new Scanner(System.in);
                            noStasiun2 = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        st2 = menuSearchStasiun(noStasiun2);
                        if (st2 != null) {
                            r.setStasiun2(st2);
                        } else {
                            System.out.println("Stasiun tidak ditemukan!");
                            System.out.println();
                        }
                    } while ((!check) || (st2 == null));
                    break;
                case 4 :
                    daftarKereta.forEach((Kereta o) -> o.toString());
                    System.out.println();
                    System.out.print("Masukkan Nama Kereta yang ingin ditambahkan : ");
                    namaKereta = s2.nextLine();
                    Kereta k = menuSearchKereta(namaKereta);
                    if (k != null) {
                        menuDeleteKereta(k);
                        r.addKereta(k);
                    } else {
                        System.out.println("Kereta tidak ditemukan");
                    }
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    System.out.println();
                    break;
            }
        } while (pilih != 0);
    }
    
    public void tampilMenuEditGerbong () {
        boolean check = false;
        int pilih = 0;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int kapasitas = 0, tipe = 0;
            long harga = 0;
            System.out.println("Edit Data Gerbong");
            System.out.println("1. Tambahkan Gerbong Baru");
            System.out.println("2. Lihat Daftar Gerbong");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan menu : ");
            try {
                s1 = new Scanner(System.in);
                pilih = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Pilihan Salah!");
                continue;
            }
            System.out.println();
            switch (pilih) {
                case 1 :
                {
                    System.out.println("Tambahkan Gerbong Baru");
                    do {                        
                        check = false;
                        System.out.print("Kapasitas : ");
                        try {
                            s1 = new Scanner(System.in);
                            kapasitas = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                    } while (!check);
                    do {                        
                        check = false;
                        System.out.print("Tipe Gerbong (1 = Eksekutif, 2 = Bisnis, 3 = Ekonomi) : ");
                        try {
                            s1 = new Scanner(System.in);
                            tipe = s1.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                        if ((tipe != 1) && (tipe != 2) && (tipe != 3)) {
                            System.out.println("Tipe Gerbong Salah!");
                            check = false;
                        }
                    } while (!check);
                    do {                        
                        check = false;
                        System.out.print("Harga Tiket : ");
                        try {
                            s1 = new Scanner(System.in);
                            harga = s1.nextLong();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Input Salah!");
                            continue;
                        }
                    } while (!check);
                    menuAddGerbong(kapasitas, tipe, harga);
                    break;
                }
                case 2 :
                    menuViewAllGerbong();
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    check = true;
                    break;
                default : 
                    System.out.println("Pilihan Salah");
                    break;
            }
        } while ((pilih != 0) || (!check));
    }
    
    public void tampilMenuCreateTiket () {
        boolean check = false;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        
        GregorianCalendar date = new GregorianCalendar(0, 0, 0);
        String namaRute, namaKereta;
        int idGerbong = 0, day, month, year, jmlTiket = 0;
        long inpDate = 0, hargaTiket = 0;
        boolean checkDate = false, checkHarga = false;
        Rute r;
        Kereta k;
        Gerbong g = null;
        System.out.println("Daftar Rute");
        daftarRute.forEach((Rute o) -> o.toString());
        System.out.println();
        do {            
            System.out.print("Masukkan Nama Rute yg akan dibuat tiketnya : ");
            namaRute = s2.nextLine();            
            r = menuSearchRute(namaRute);
            if (r == null) {
                System.out.println("Rute yang anda cari tidak ada!");
            }
        } while (r == null);
        System.out.println();
        r.tampil();
//        System.out.println("Daftar Kereta yang Tersedia dalam Rute");
//        r.printDaftarKereta();
        System.out.println();
        do {            
            System.out.print("Masukkan nama kereta yg akan dibuat tiketnya : ");
            namaKereta = s2.nextLine();
            k = r.getKereta(namaKereta);
            if (k == null) {
                System.out.println("Kereta yang anda cari tidak ada");
            }
            System.out.println();
        } while (k == null);
        k.tampilDetil();
        System.out.println();
        do {            
            check = false;
            System.out.println("Silahkan masukkan ID gerbong yang anda inginkan : ");
            try {
                s1 = new Scanner(System.in);
                idGerbong = s1.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Input Salah");
                continue;
            }
            g = k.getGerbong(idGerbong);
            if (g == null) {
                System.out.println("Gerbong yang anda cari tidak tersedia");
            }
        } while ((g == null) || (!check));
        g.toString();
        System.out.println();
        do {            
            check = false;
            System.out.println("Masukkan tanggal pemberangkatan kereta (YYYYMMDD): ");
            try {
                s3 = new Scanner(System.in);
                inpDate = s3.nextLong();
                check = true;
            } catch (Exception e) {
                System.out.println("Format salah");
                continue;
            }
            checkDate = isValidFormat("yyyyMMdd", inpDate);
            year = (int) (long) inpDate/1000;
            month = (int) (long) (inpDate - (year*1000))/100;
            day = (int) (long) inpDate - ((year*1000) + (month*100));
            date.setLenient(false);
            date.set(year, month, day);
            try {
                date.getTime();
            } catch (Exception e) {
                System.out.println("Tanggal tidak valid");
                continue;
            }
//            if ((year <= 0) || (year > 2016)) {
//                if ((month <= 0) || (month > 12)) {
//                    if ((month )
//                }
//            }
        } while ((!checkDate) || (!check));
        
        for (int i = 0; i < g.getKapasitas(); i++) {
            r.createTicket(date, g.getTipeGerbong(), hargaTiket, k, g);
        }
    }
        
    public void mainMenu () {
        boolean check = false;
        Scanner s1 = new Scanner(System.in);
        int pilihMain = 0;
        do {
            Scanner s2 = new Scanner(System.in);
            int pilsub;
            System.out.println("Main Menu");
            System.out.println("1. Edit Data Stasiun");
            System.out.println("2. Edit Data Kereta");
            System.out.println("3. Edit Data Rute");
            System.out.println("4. Edit Data Gerbong");
            System.out.println("5. Buat Tiket Perjalanan");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Pilihan menu : ");
            do {                
                check = false;
                try {
                    s1 = new Scanner(System.in);
                    pilihMain = s1.nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Pilihan Salah!");
                    continue;
                }
            } while (!check);
            System.out.println();
            switch (pilihMain) {
                case 1 :
                    tampilMenuEditStasiun();
                    break;
                case 2 :
                    tampilMenuEditKereta();
                    break;
                case 3 :
                    tampilMenuEditRute();
                    break;
                case 4 :
                    tampilMenuEditGerbong();
                    break;
                case 5 :
                    tampilMenuCreateTiket();
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    break;
            }
        } while ((pilihMain != 0) || (!check));
        
    }

}
