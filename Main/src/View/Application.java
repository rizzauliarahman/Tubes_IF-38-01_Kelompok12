/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.sql.Struct;
import java.util.*;
import java.text.*;

/**
 *
 * @author Rizza
 */
public class Application {
    List<Model.Stasiun> daftarStasiun = new ArrayList<Model.Stasiun>();
    List<Kereta> daftarKereta = new ArrayList<Kereta>();
    List<Rute> daftarRute = new ArrayList<Rute>();
    List<Gerbong> daftarGerbong = new ArrayList<Gerbong>();
    
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
        return daftarStasiun.stream().filter((Stasiun o) -> o.getNomorStasiun() == noStasiun).findFirst().orElse(null);
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
        daftarGerbong.forEach((Gerbong o) -> o.toString());
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
        do {         
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int noStasiun;
            pilih = 0;
            String namaStasiun, alamat, kota, singkatan;
            System.out.println("Edit Data Stasiun");
            System.out.println("1. Tambahkan Stasiun Baru");
            System.out.println("2. Cari Stasiun");
            System.out.println("0. Kembali ke Menu Awal");
            System.out.println();
            System.out.print("Pilihan menu : ");
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.println("Tambahkan Stasiun Baru");
                    System.out.println("Nomor Stasiun : ");
                    noStasiun = s1.nextInt();
                    Stasiun s = menuSearchStasiun(noStasiun);
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
                case 2 :
                    System.out.println("Nomor Stasiun yang ingin dicari : ");
                    noStasiun = s1.nextInt();
                    s = menuSearchStasiun(noStasiun);
                    if (s == null) {
                        System.out.println("Stasiun dengan nomor tersebut tidak ada");
                    } else {
                        System.out.println();
                        tampilMenuCariStasiun(s);
                    }
                case 3 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    break;
            }
        } while (pilih != 0);
    }
    
    public void tampilMenuCariStasiun(Stasiun s) {
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
            pilih = s1.nextInt();
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
                    System.out.print("Masukkan Nomor Stasiun : ");
                    nomor = s1.nextInt();
                    s.setNomorStasiun(nomor);
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
                    System.out.print("Masukkan Jumlah Jalur Dalam Stasiun : ");
                    jmlJalur = s1.nextInt();
                    s.setJumlahJalur(jmlJalur);
                    break;
                case 7 :
                    System.out.print("Masukkan Tahun Pembangunan Stasiun : ");
                    tahun = s1.nextInt();
                    s.setTahunPbangunan(tahun);
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
    
    public void tampilMenuEditKereta () {
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
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.println("Tambahkan Kereta Baru");
                    System.out.println("Nama Kereta : ");
                    namaKereta = s2.nextLine();
                    Kereta k = menuSearchKereta(namaKereta);
                    if (k == null) {
                        System.out.print("Tipe Kereta (1 = Listrik, 2 = Diesel) : ");
                        tipe = s1.nextInt();
                        k = new Kereta(namaKereta, tipe);
                        daftarKereta.add(k);
                    } else {
                        System.out.println();
                        tampilMenuCariKereta(k);
                    }
                    break;
                case 2 :
                    System.out.println("Nama Kereta yang ingin dicari : ");
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
        } while (pilih != 0);
    }
    
    public void tampilMenuCariKereta(Kereta k) {
        int pilih;
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
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.print("Masukkan Nama  Kereta : ");
                    namaKereta = s2.nextLine();
                    k.setNamaKereta(namaKereta);
                    break;
                case 2 :
                    System.out.print("Masukkan Tipe Kereta (1 = Listrik, 2 = Diesel) : ");
                    tipe = s1.nextInt();
                    k.setTipeKereta(tipe);
                    break;
                case 3 :
                    menuViewAllGerbong();
                    System.out.println("Masukkan ID Gerbong yang akan ditambahkan");
                    idGerbong = s1.nextInt();
                    Gerbong g = menuSearchGerbong(idGerbong);
                    if (g != null) {
                        menuDeleteGerbong(g.getIdGerbong());
                        k.addGerbong(g);
                    } else {
                        System.out.println("Tidak ada Gerbong dengan ID tersebut");
                    }
                    break;
                case 4 :
                    k.tampilDetil();
                    System.out.println("Masukkan ID Gerbong yang akan dihapus");
                    idGerbong = s1.nextInt();
                    Gerbong a = k.getGerbong(idGerbong);
                    if (a != null) {
                        k.removeGerbong(idGerbong);  
                    } else {
                        System.out.println("Gerbong dengan ID tersebut tidak ada");
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
    
    public void tampilMenuEditRute () {
        int pilih;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int nomorStasiun1, nomorStasiun2;
            String namaRute;
            System.out.println("Edit Data Rute");
            System.out.println("1. Tambahkan Rute Baru");
            System.out.println("2. Cari Rute");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan menu : ");
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.println("Tambahkan Rute Baru");
                    System.out.println("Nama Rute : ");
                    namaRute = s2.nextLine();
                    Rute r = menuSearchRute(namaRute);
                    if (r == null) {
                        System.out.print("Stasiun 1 : ");
                        nomorStasiun1 = s1.nextInt();
                        Stasiun st1 = menuSearchStasiun(nomorStasiun1);
                        System.out.print("Stasiun 2 : ");
                        nomorStasiun2 = s1.nextInt();
                        Stasiun st2 = menuSearchStasiun(nomorStasiun2);
                        if ((st1 != null) && (st2 != null)) {
                            r.setStasiun1(st1);
                            r.setStasiun2(st2);
                            daftarRute.add(r);    
                        }
                    } else {
                        System.out.println();
                        tampilMenuCariRute(r);
                    }
                    break;
                case 2 :
                    System.out.println("Nama Rute yang ingin dicari : ");
                    namaRute = s2.nextLine();
                    r = menuSearchRute(namaRute);
                    if (r == null) {
                        System.out.println("Stasiun dengan nomor tersebut tidak ada");
                    } else {
                        System.out.println();
                        tampilMenuCariRute(r);
                    }
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default :
                    System.out.println("Pilihan Salah!");
                    break;
            }
        } while (pilih != 0);
    }
    
    public void tampilMenuCariRute (Rute r) {
        int pilih;
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
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.print("Masukkan Nama Rute : ");
                    namaRute = s2.nextLine();
                    r.setNamaRute(namaRute);
                    break;
                case 2 :
                    System.out.print("Masukkan Nomor Stasiun 1 : ");
                    noStasiun1 = s1.nextInt();
                    Stasiun st1 = menuSearchStasiun(noStasiun1);
                    if (st1 != null) {
                        r.setStasiun1(st1);
                    }
                    break;
                case 3 :
                    System.out.print("Masukkan Nomor Stasiun 2 : ");
                    noStasiun2 = s1.nextInt();
                    Stasiun st2 = menuSearchStasiun(noStasiun2);
                    if (st2 != null) {
                        r.setStasiun2(st2);
                    }
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
        int pilih;
        do {            
            
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            int kapasitas, tipe;
            long harga;
            System.out.println("Edit Data Gerbong");
            System.out.println("1. Tambahkan Gerbong Baru");
            System.out.println("2. Lihat Daftar Gerbong");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.print("Pilihan menu : ");
            pilih = s1.nextInt();
            System.out.println();
            switch (pilih) {
                case 1 :
                    System.out.println("Tambahkan Gerbong Baru");
                    System.out.println("Kapasitas : ");
                    kapasitas = s1.nextInt();
                    System.out.println("Tipe Gerbong (1 = Eksekutif, 2 = Bisnis, 3 = Ekonomi)");
                    tipe = s1.nextInt();
                    System.out.println("Harga Tiket : ");
                    harga = s1.nextLong();
                    menuAddGerbong(kapasitas, tipe, harga);
                    break;
                case 2 :
                    menuViewAllGerbong();
                    break;
                case 0 :
                    System.out.println("Selesai!");
                    break;
                default : 
                    System.out.println("Pilihan Salah");
                    break;
            }
        } while (pilih != 0);
    }
    
    public void tampilMenuCreateTiket () {
        
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        
        GregorianCalendar date = new GregorianCalendar(0, 0, 0);
        String namaRute, namaKereta;
        int idGerbong = 0, day, month, year, jmlTiket;
        long inpDate = 0, hargaTiket = 0;
        boolean checkDate, checkHarga = false;
        Rute r;
        Kereta k;
        Gerbong g;
        System.out.println("Daftar Rute");
        daftarRute.forEach((Rute o) -> o.toString());
        System.out.println();
        do {            
            System.out.println("Masukkan Nama Rute yg akan dibuat tiketnya");
            namaRute = s2.nextLine();            
            r = menuSearchRute(namaRute);
            if (r == null) {
                System.out.println("Rute yang anda cari tidak ada!");
            }
        } while (r == null);
        System.out.println();
        r.tampil();
        System.out.println("Daftar Kereta yang Tersedia dalam Rute");
        r.printDaftarKereta();
        System.out.println();
        do {            
            System.out.println("Masukkan nama kereta yg akan dibuat tiketnya");
            namaKereta = s2.nextLine();
            k = menuSearchKereta(namaKereta);
            if (k == null) {
                System.out.println("Kereta yang anda cari tidak ada");
            }
            System.out.println();
        } while (k == null);
        k.tampilDetil();
        System.out.println();
        do {            
            System.out.println("Silahkan masukkan ID gerbong yang anda inginkan");
            try {
                idGerbong = s1.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Salah");
            }
            g = k.getGerbong(idGerbong);
            if (g == null) {
                System.out.println("Gerbong yang anda cari tidak tersedia");
            }
        } while (g == null);
        g.toString();
        System.out.println();
        do {            
            System.out.println("Masukkan tanggal pemberangkatan kereta (YYYYMMDD): ");
            try {
                inpDate = s3.nextLong();            
            } catch (Exception e) {
                System.out.println("Format salah");
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
            }
//            if ((year <= 0) || (year > 2016)) {
//                if ((month <= 0) || (month > 12)) {
//                    if ((month )
//                }
//            }
        } while (!checkDate);
        do {            
            System.out.println("Masukkan Harga Tiket");
            try {
                hargaTiket = s3.nextLong();
                checkHarga = true;
            } catch (Exception e) {
                System.out.println("Input Salah");
            }            
        } while (!checkHarga);
        do {            
            System.out.print("Masukkan jumlah tiket yang akan ditambahkan : ");
            jmlTiket = s1.nextInt();
            if (jmlTiket <= g.getKapasitas()) {
                for (int i = 0; i < jmlTiket; i++) {
                    r.createTicket(date, g.getTipeGerbong(), hargaTiket, k, g);
                }
            }
        } while (jmlTiket > g.getKapasitas());
    }
        
    public void mainMenu () {
        Scanner s1 = new Scanner(System.in);
        int pilihMain;
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
            pilihMain = s1.nextInt();
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
        } while (pilihMain != 0);
        
    }

}
