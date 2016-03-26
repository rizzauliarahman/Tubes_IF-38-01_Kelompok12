/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rizza
 */
public class Stasiun {
    private String namaStasiun, alamat, kota, singkatan;
    private int nomorStasiun, jumlahJalur, tahunPbangunan;
    
    public Stasiun (String name, String singkatan, int nomor) {
        namaStasiun = name;
        this.singkatan = singkatan;
        nomorStasiun = nomor;    
    }

    /**
     * @return the namaStasiun
     */
    public String getNamaStasiun() {
        return namaStasiun;
    }

    /**
     * @param namaStasiun the namaStasiun to set
     */
    public void setNamaStasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the kota
     */
    public String getKota() {
        return kota;
    }

    /**
     * @param kota the kota to set
     */
    public void setKota(String kota) {
        this.kota = kota;
    }

    /**
     * @return the singkatan
     */
    public String getSingkatan() {
        return singkatan;
    }

    /**
     * @param singkatan the singkatan to set
     */
    public void setSingkatan(String singkatan) {
        this.singkatan = singkatan;
    }

    /**
     * @return the nomorStasiun
     */
    public int getNomorStasiun() {
        return nomorStasiun;
    }

    /**
     * @param nomorStasiun the nomorStasiun to set
     */
    public void setNomorStasiun(int nomorStasiun) {
        this.nomorStasiun = nomorStasiun;
    }

    /**
     * @return the jumlahJalur
     */
    public int getJumlahJalur() {
        return jumlahJalur;
    }

    /**
     * @param jumlahJalur the jumlahJalur to set
     */
    public void setJumlahJalur(int jumlahJalur) {
        this.jumlahJalur = jumlahJalur;
    }

    /**
     * @return the tahunPbangunan
     */
    public int getTahunPbangunan() {
        return tahunPbangunan;
    }

    /**
     * @param tahunPbangunan the tahunPbangunan to set
     */
    public void setTahunPbangunan(int tahunPbangunan) {
        this.tahunPbangunan = tahunPbangunan;
    }

    public void tampil() {
        System.out.println("Nama Stasiun : "+this.namaStasiun);
        System.out.println("Nomor Stasiun : "+this.nomorStasiun);
        System.out.println("Alamat : "+this.alamat);
        System.out.println("Kota : "+this.kota);
        System.out.println();
    }
    
    public void tampilDetil() {
        System.out.println("Nama Stasiun : "+this.namaStasiun);
        System.out.println("Singkatan : "+this.singkatan);
        System.out.println("Nomor Stasiun : "+this.nomorStasiun);
        System.out.println("Alamat : "+this.alamat);
        System.out.println("Kota : "+this.kota);
        System.out.println("Jumlah Jalur : "+this.jumlahJalur);
        System.out.println("Tahun Pembangunan : "+this.tahunPbangunan);
        System.out.println();
    }
}
