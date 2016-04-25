/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rizza
 */
public class Controller extends MouseAdapter implements ActionListener {
    menuList menu;
    JPanel currentView = new JPanel();
    Application app;
    Gerbong g = null;
    Kereta k = null;
    Rute r = null;
    String ruteName;
    int idx;

    public Controller() throws Exception {
        app = new Application();
        menu = new menuList();
        currentView = menu.getMainMenu();
        currentView.setSize(400,300);
        menu.setVisible(true);
        currentView.setVisible(true);
        menu.addListener(this);
        menu.addAdapter(this);
        app.daftarStasiun = (List<Stasiun>) app.readFile("Stasiun.dat");
        app.daftarRute = (List<Rute>) app.readFile("Rute.dat");
        app.daftarKereta = (List<Kereta>) app.readFile("Kereta.dat");
        app.daftarGerbong = (List<Gerbong>) app.readFile("Gerbong.dat");
        Kereta.setnKereta((int) app.readFile("nKereta.dat"));
        Gerbong.setnGerbong((int) app.readFile("nGerbong.dat"));
        Tiket.setnTiket((int) app.readFile("nTiket.dat"));
    }   
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (currentView.equals(menu.getMainMenu())) {
            mainMenu mm = menu.getMainMenu();
            if (source.equals(mm.getBtnMenuEditStasiun())) {
                currentView.setVisible(false);
                menuEditStasiun es = menu.getMenuEditStasiun();
                currentView = menu.getMenuEditStasiun();
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuEditKereta())) {
                currentView.setVisible(false);
                menuEditKereta ek = menu.getMenuEditKereta();
                currentView = ek;
                currentView.setSize(402, 300);
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuEditRute())) {
                currentView.setVisible(false);
                menuEditRute er = menu.getMenuEditRute();
                currentView = er;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuBuatTiket())) {
                currentView.setVisible(false);
                menuCreateTiket ct = menu.getMenuCreateTiket();
                ct.setTableRute(app.daftarRute);
                currentView = ct;
                currentView.setSize(400,300);
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnExit())) {
                try {
                    app.writeFile(app.daftarGerbong, "Gerbong.dat");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    app.writeFile(app.daftarRute, "Rute.dat");
                    app.writeFile(app.daftarStasiun, "Stasiun.dat");
                    app.writeFile(Gerbong.getnGerbong(), "nGerbong.dat");
                    app.writeFile(Kereta.getnKereta(), "nKereta.dat");
                    app.writeFile(Tiket.getnTiket(), "nTiket.dat");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            }
        } else if (currentView.equals(menu.getMenuEditStasiun())) {
            menuEditStasiun es = menu.getMenuEditStasiun();
            if (source.equals(es.getBtnTambahStasiun())) {
                currentView.setVisible(false);
                menuAddStasiun as = menu.getMenuAddStasiun();
                currentView =  as;
                currentView.setSize(400, 289);
                currentView.setVisible(true);
            } else if (source.equals(es.getBtnEditStasiun())) {
                currentView.setVisible(false);
                menuEditStasiun2 es2 = menu.getMenuEditStasiun2();
                es2.setTabelStasiun(app.daftarStasiun);
                currentView =  es2;
                currentView.setSize(423, 339);
                currentView.setVisible(true);
            } else if (source.equals(es.getBtnBacktoMainMenu())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView =  mm;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditKereta())) {
            menuEditKereta ek = menu.getMenuEditKereta();
            if (source.equals(ek.getBtnMenuAddKereta())) {
                currentView.setVisible(false);
                menuAddKereta ak = menu.getMenuAddKereta();
                ak.reset();
                currentView = ak;
                currentView.setSize(400, 181);
                currentView.setVisible(true);
            } else if (source.equals(ek.getBtnMenuEditKereta())) {
                currentView.setVisible(false);
                menuEditKereta2 ek2 = menu.getMenuEditKereta2();
                ek2.setTableKereta(app.daftarKereta);
                currentView = ek2;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            } else if (source.equals(ek.getBtnBack())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView = mm;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRute())) {
            menuEditRute er = menu.getMenuEditRute();
            if (source.equals(er.getBtnTambahRute())) {
                currentView.setVisible(false);
                menuAddRute ar = menu.getMenuAddRute();
                ar.setComBoxSt(app.daftarStasiun);
                currentView = ar;
                currentView.setSize(400, 240);
                currentView.setVisible(true);
            } else if (source.equals(er.getBtnEditRute())) {
                try {
                    currentView.setVisible(false);
                    menuEditRute2 er2 = menu.getMenuEditRute2();
                    er2.setTableRute(app.daftarRute);
                    currentView = er2;
                    currentView.setSize(400, 300);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                    e.printStackTrace();
                }
            } else if (source.equals(er.getBtnKembali())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView = mm;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuAddStasiun())) {
            menuAddStasiun as = menu.getMenuAddStasiun();
            int nomor;
            if (source.equals(as.getBtnOk())) {
                try {
                    nomor = as.getTxFieldNoStasiun();
                    Stasiun a = app.menuSearchStasiun(nomor) ;
                    if (a == null) {
                        Stasiun s = new Stasiun(as.getTxFieldNamaStasiun(), as.getTxFieldSingkatan(), as.getTxFieldNoStasiun());
                        s.setAlamat(as.getTxFieldAlamat());
                        s.setKota(as.getTxFieldKota());
                        try {
                            app.menuAddStasiun(s);
                            JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                            app.writeFile(app.daftarStasiun, "Stasiun.dat");
                            currentView.setVisible(false);
                            menuEditStasiun es = menu.getMenuEditStasiun();
                            currentView = es;
                            currentView.setSize(400, 300);
                            currentView.setVisible(true);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(currentView, "Error dalam Menyimpan Data!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(currentView, "Nomor Stasiun sudah Digunakan!");
                        as.setTxFieldNoStasiun(0);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Nomor Stasiun Harus Berupa Angka!");
                    as.setTxFieldNoStasiun(0);
                }
            } else if (source.equals(as.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditStasiun es = menu.getMenuEditStasiun();
                currentView = es;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditStasiun2())) {
            menuEditStasiun2 es2 = menu.getMenuEditStasiun2();
            if (source.equals(es2.getBtnEdit())) {
                Stasiun s = app.daftarStasiun.stream().filter((Stasiun o) -> o.getNomorStasiun() == es2.getSelectedStasiun()).findFirst().orElse(null);
                int n = app.daftarStasiun.indexOf(s);
                currentView.setVisible(false);
                menuEditStasiunDetil esd = menu.getMenuEditStasiunDetil();
                esd.setComponent(s);
                currentView = esd;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(es2.getBtnHapus())) {
                app.daftarStasiun.removeIf((Stasiun o) -> o.getNomorStasiun() == es2.getSelectedStasiun());
                JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                es2.setTabelStasiun(app.daftarStasiun);
                currentView.setVisible(true);
                try {
                    app.writeFile(app.daftarStasiun, "Stasiun.dat");
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (source.equals(es2.getBtnKembali())) {
                currentView.setVisible(false);
                menuEditStasiun es = menu.getMenuEditStasiun();
                currentView = es;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditStasiunDetil())) {
            menuEditStasiunDetil esd = menu.getMenuEditStasiunDetil();
            if (source.equals(esd.getBtnOk())) {
                try {
                    Stasiun s = app.menuSearchStasiun(esd.getTxFieldNoStasiun());
                    idx = app.daftarStasiun.indexOf(s);
                    s.setNamaStasiun(esd.getTxFieldNamaStasiun());
                    s.setAlamat(esd.getTxFieldAlamat());
                    s.setSingkatan(esd.getTxFieldSingkatan());
                    s.setKota(esd.getTxFieldKota());
                    app.daftarStasiun.set(idx, s);
                    JOptionPane.showMessageDialog(currentView, "Data Stasiun Berhasil Diubah!");
                    currentView.setVisible(false);
                    menuEditStasiun2 es2 = menu.getMenuEditStasiun2();
                    es2.setTabelStasiun(app.daftarStasiun);
                    currentView = es2;
                    currentView.setSize(423, 339);
                    currentView.setVisible(true);
                    try {
                        app.writeFile(app.daftarStasiun, "Stasiun.dat");
                    } catch (Exception ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(esd.getBtnCancel())) {
                currentView.setVisible(false);
                menuEditStasiun2 es2 = menu.getMenuEditStasiun2();
                currentView = es2;
                currentView.setSize(423, 339);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditKereta2())) {
            menuEditKereta2 ek2 = menu.getMenuEditKereta2();
            if (source.equals(ek2.getBtnEdit())) {
                k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == ek2.getSelectedKereta()).findFirst().orElse(null);
                int n = app.daftarKereta.indexOf(k);
                currentView.setVisible(false);
                menuEditKeretaDetil ekd = menu.getMenuEditKeretaDetil();
                ekd.setData(k);
                currentView = ekd;
                currentView.setSize(412, 241);
                currentView.setVisible(true);
            } else if (source.equals(ek2.getBtnHapus())) {
                app.daftarKereta.removeIf((Kereta o) -> o.getIdKereta() == ek2.getSelectedKereta());
                JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                ek2.setTableKereta(app.daftarKereta);
                currentView.setVisible(true);
                try {
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (source.equals(ek2.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditKereta ek = menu.getMenuEditKereta();
                currentView = ek;
                currentView.setSize(402, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuAddKereta())) {
            menuAddKereta ak = menu.getMenuAddKereta();
            if (source.equals(ak.getBtnTambah())) {
                try {
                    k = new Kereta(ak.getTxFieldNamaKereta(), ak.getComBoxJenisKereta() + 1);
                    app.daftarKereta.add(k);
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    currentView.setVisible(false);
                    menuEditKereta ek = menu.getMenuEditKereta();
                    currentView = ek;
                    currentView.setSize(402, 300);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(ak.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditKereta ek = menu.getMenuEditKereta();
                currentView = ek;
                currentView.setSize(402, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditKeretaDetil())) {
            menuEditKeretaDetil edk = menu.getMenuEditKeretaDetil();
            if (source.equals(edk.getBtnSimpan())) {
                try {
                    k = null;
                    int i = 0;
                    while ((i < app.daftarKereta.size()) && (app.daftarKereta.get(i).getIdKereta() != edk.getTxFieldNoKereta())) {
                        i++;
                    }
                    if (app.daftarKereta.get(i).getIdKereta() == edk.getTxFieldNoKereta()) {
                        k = app.daftarKereta.get(i);
                    }
                    idx = app.daftarKereta.indexOf(k);
                    k.setNamaKereta(edk.getTxFieldNamaKereta());
                    k.setTipeKereta(edk.getComBoxJenisKereta() + 1);
                    app.daftarKereta.set(idx, k);
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Diubah!");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    currentView.setVisible(false);
                    menuEditKereta2 ek2 = menu.getMenuEditKereta2();
                    ek2.setTableKereta(app.daftarKereta);
                    currentView = ek2;
                    currentView.setSize(401, 304);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(edk.getBtnEditGerbong())) {
                k = null;
                int i = 0;
                while ((i < app.daftarKereta.size()) && (app.daftarKereta.get(i).getIdKereta() != edk.getTxFieldNoKereta())) {
                    i++;
                }
                if (app.daftarKereta.get(i).getIdKereta() == edk.getTxFieldNoKereta()) {
                    k = app.daftarKereta.get(i);
                }
                currentView.setVisible(false);
                menuEditGerbong2 eg2 = menu.getMenuEditGerbong2();
                eg2.setTableGerbong(k.getListGerbong());
                currentView = eg2;
                currentView.setSize(400, 303);
                currentView.setVisible(true);
            } else if (source.equals(edk.getBtnTambahGerbong())) {
                int i = 0;
                k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == edk.getTxFieldNoKereta()).findFirst().orElse(null);
                currentView.setVisible(false);
                menuAddGerbong ag = menu.getMenuAddGerbong();
                ag.reset();
                currentView = ag;
                currentView.setSize(400, 214);
                currentView.setVisible(true);
            } else if (source.equals(edk.getBtnBatal())) { 
                currentView.setVisible(false);
                menuEditKereta2 ek2 = menu.getMenuEditKereta2();
                currentView = ek2;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuAddGerbong())) {
            menuAddGerbong ag = menu.getMenuAddGerbong();
            if (source.equals(ag.getBtnTambah())) {
                try {
                    for (int i = 0; i < ag.getTxFieldJumlah(); i++) {
                        g = new Gerbong(ag.getTxFieldKapasitas(), ag.getComBoxJenisGerbong() + 1);
                        k.addGerbong(g);
                    }
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    currentView.setVisible(false);
                    menuEditKeretaDetil ekd = menu.getMenuEditKeretaDetil();
                    ekd.setData(k);
                    currentView = ekd;
                    currentView.setSize(412, 241);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                    e.printStackTrace();
                }
            } else if (source.equals(ag.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditKeretaDetil ekd = menu.getMenuEditKeretaDetil();
                currentView = ekd;
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditGerbong2())) {
            menuEditGerbong2 eg2 = menu.getMenuEditGerbong2();
            if (source.equals(eg2.getBtnEdit())) {
                g = k.getGerbong(eg2.getTableGerbong());
                idx = k.getListGerbong().indexOf(g);
                currentView.setVisible(false);
                menuEditGerbongDetil egd = menu.getMenuEditGerbongDetil();
                egd.setComponentsData(g);
                currentView = egd;
                currentView.setSize(400, 210);
                currentView.setVisible(true);
            } else if (source.equals(eg2.getBtnHapus())) {
                k.removeGerbong(eg2.getTableGerbong());
                JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                eg2.setTableGerbong(k.getListGerbong());
                currentView.setVisible(true);
            } else if (source.equals(eg2.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditKeretaDetil edk = menu.getMenuEditKeretaDetil();
                currentView = edk;
                currentView.setSize(412, 241);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditGerbongDetil())) {
            menuEditGerbongDetil egd = menu.getMenuEditGerbongDetil();
            if (source.equals(egd.getBtnSimpan())) {
                try {
                    g.setKapasitas(egd.getTxFieldKapasitas());
                    g.setTipeGerbong(egd.getComBoxJenisGerbong() + 1);
                    k.getListGerbong().set(idx, g);
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Diubah!");
                    currentView.setVisible(false);
                    menuEditGerbong2 eg2 = menu.getMenuEditGerbong2();
                    eg2.setTableGerbong(k.getListGerbong());
                    currentView = eg2;
                    currentView.setSize(400, 303);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(egd.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditGerbong2 eg2 = menu.getMenuEditGerbong2();
                currentView = eg2;
                currentView.setSize(400, 303);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRute2())) {
            menuEditRute2 er2 = menu.getMenuEditRute2();
            if (source.equals(er2.getBtnEdit())) {
                String name = er2.getSelectedRute();
                r = app.menuSearchRute(name);
                ruteName = name;
                menuEditRuteDetil erd = menu.getMenuEditRuteDetil();
                erd.setComBoxSt(app.daftarStasiun);
                erd.setTxFieldNama(r);
                erd.setTxFieldJmlKereta(r.getListKereta().size());
                int jml = 0;
                for (int i = 0; i < r.getListTiket().size(); i++) {
                    jml = jml + r.getListTiket().get(i).getGerbong().getKapasitas();
                }
                erd.setTxFieldJmlTiket(jml);
                currentView.setVisible(false);
                currentView = erd;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(er2.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditRute er = menu.getMenuEditRute();
                currentView = er;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(er2.getBtnHapus())) {
                try {
                    String name = er2.getSelectedRute();
                    r = app.menuSearchRute(name);
                    app.menuDeleteRute(r);
                    app.writeFile(app.daftarRute, "Rute.dat");
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                    er2.setTableRute(app.daftarRute);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            }
        } else if (currentView.equals(menu.getMenuEditRuteDetil())) {
            menuEditRuteDetil erd = menu.getMenuEditRuteDetil();
            if (source.equals(erd.getBtnSimpan())) {
                try {
                    r = app.menuSearchRute(ruteName);
                    idx = app.daftarRute.indexOf(r);
                    r.setNamaRute(erd.getTxFieldNama());
                    r.setStasiun1(app.daftarStasiun.get(erd.getComBoxSt1()));
                    r.setStasiun2(app.daftarStasiun.get(erd.getComBoxSt2()));
                    app.daftarRute.set(idx, r);
                    app.writeFile(app.daftarRute, "Rute.dat");
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                    currentView.setVisible(false);
                    menuEditRute2 er2 = menu.getMenuEditRute2();
                    er2.setTableRute(app.daftarRute);
                    currentView = er2;
                    currentView.setSize(400, 300);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(erd.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditRute2 er2 = menu.getMenuEditRute2();
                currentView = er2;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(erd.getBtnEditDaftarKereta())) {
                menuEditRuteEditKereta erk = menu.getMenuEditRuteEditKereta();
                System.out.println(ruteName);
                r = app.menuSearchRute(ruteName);
                erk.setTableKereta(r.getListKereta());
                currentView.setVisible(false);
                currentView = erk;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            } else if (source.equals(erd.getBtnViewTiket())) {
                currentView.setVisible(false);
                menuEditRuteViewTiket erv = menu.getMenuEditRuteViewTiket();
                r = app.menuSearchRute(ruteName);
                erv.setTableData(r.getListTiket());
                currentView = erv;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRuteEditKereta())) {
            menuEditRuteEditKereta erk = menu.getMenuEditRuteEditKereta();
            if (source.equals(erk.getBtnHapus())) {
                try {
//                    int i = 0;
//                    while ((r.getListKereta().get(i).getIdKereta() != erk.getSelectedKereta()) && (i < r.getListKereta().size())) {
//                        i++;
//                    }
//                    if (r.getListKereta().get(i).getIdKereta() == erk.getSelectedKereta()) {
                    k = r.getListKereta().stream().filter((Kereta o) -> o.getIdKereta() == erk.getSelectedKereta()).findFirst().orElse(null);
                    app.daftarKereta.add(k);
                    r.getListKereta().remove(k);
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    app.writeFile(app.daftarRute, "Rute.dat");
                    erk.setTableKereta(r.getListKereta());
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(erk.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditRuteDetil erd = menu.getMenuEditRuteDetil();
                r = app.menuSearchRute(ruteName);
                erd.setComBoxSt(app.daftarStasiun);
                erd.setTxFieldNama(r);
                erd.setTxFieldJmlKereta(r.getListKereta().size());
                int jml = 0;
                for (int i = 0; i < r.getListTiket().size(); i++) {
                    jml = jml + r.getListTiket().get(i).getGerbong().getKapasitas();
                }
                erd.setTxFieldJmlTiket(jml);
                currentView = erd;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            } else if (source.equals(erk.getBtnTambah())) {
                currentView.setVisible(false);
                menuEditRuteAddKereta era = menu.getMenuEditRuteAddKereta();
                era.setTableKereta(app.daftarKereta);
                currentView = era;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRuteAddKereta())) {
            menuEditRuteAddKereta era = menu.getMenuEditRuteAddKereta();
            if (source.equals(era.getBtnTambah())) {
//                int i = 0;
//                while ((app.daftarKereta.get(i).getIdKereta() != era.getSelectedKereta()) && (i < app.daftarKereta.size())) {
//                    i++;
//                }
//                if (app.daftarKereta.get(i).getIdKereta() == era.getSelectedKereta()) {
                try {
                    k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == era.getSelectedKereta()).findFirst().orElse(null);
                    r.getListKereta().add(k);
                    app.daftarKereta.remove(k);
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                    JOptionPane.showMessageDialog(currentView, "Data Telah Ditambahkan!");
                    era.setTableKereta(app.daftarKereta);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(era.getBtnSelesai())) {
                currentView.setVisible(false);
                menuEditRuteEditKereta erk = menu.getMenuEditRuteEditKereta();
                erk.setTableKereta(r.getListKereta());
                currentView = erk;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRuteViewTiket())) {
            menuEditRuteViewTiket erv = menu.getMenuEditRuteViewTiket();
            if (source.equals(erv.getBtnHapus())) {
                int i = 0;
                while ((r.getListTiket().get(i).getIdTiket() != erv.getTableTiket()) && (i < r.getListTiket().size())) {
                    i++;
                }
                if (r.getListTiket().get(i).getIdTiket() == erv.getTableTiket()) {
                    try {
                        Tiket t = r.getListTiket().get(i);
                        r.getListTiket().remove(t);
                        app.writeFile(app.daftarRute, "Rute.dat");
                        JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                    }
                }
                currentView.setVisible(false);
                erv.setTableData(r.getListTiket());
                currentView.setVisible(true);
            } else if (source.equals(erv.getBtnKembali())) {
                currentView.setVisible(false);
                menuEditRuteDetil erd = menu.getMenuEditRuteDetil();
                r = app.menuSearchRute(ruteName);
                erd.setComBoxSt(app.daftarStasiun);
                erd.setTxFieldNama(r);
                erd.setTxFieldJmlKereta(r.getListKereta().size());
                int jml = 0;
                for (int i = 0; i < r.getListTiket().size(); i++) {
                    jml = jml + r.getListTiket().get(i).getGerbong().getKapasitas();
                }
                erd.setTxFieldJmlTiket(jml);
                currentView = erd;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuAddRute())) {
            menuAddRute ar = menu.getMenuAddRute();
            if (source.equals(ar.getBtnTambah())) {
                try {
                    r = new Rute(ar.getTxFieldNama());
                    r.setStasiun1(app.daftarStasiun.get(ar.getComBoxSt1()));
                    r.setStasiun2(app.daftarStasiun.get(ar.getComBoxSt2()));
                    app.menuAddRute(r);
                    app.writeFile(app.daftarRute, "Rute.dat");
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                    currentView.setVisible(false);
                    menuEditRute er = menu.getMenuEditRute();
                    currentView = er;
                    currentView.setSize(400, 300);
                    currentView.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(ar.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditRute er = menu.getMenuEditRute();
                currentView = er;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuCreateTiket())) {
            menuCreateTiket ct = menu.getMenuCreateTiket();
            if (source.equals(ct.getBtnPilih())) {
                r = app.daftarRute.get(ct.getListStasiun());
                currentView.setVisible(false);
                menuCreateTiket2 ct2 = menu.getMenuCreateTiket2();
                ct2.setTableKereta(r.getListKereta());
                currentView = ct2;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            } else if (source.equals(ct.getBtnBatal())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView = mm;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuCreateTiket4())) {
            menuCreateTiket4 ct4 = menu.getMenuCreateTiket4();
            if (source.equals(ct4.getBtnBuat())) {
                GregorianCalendar date = new GregorianCalendar(0, 0, 0);
                date.setLenient(false);
                date.setTime((ct4.getDate()).getTime());
                boolean check = r.checkTicket(date, g.getTipeGerbong(), ct4.getTxFieldHarga(), k, g);
                if (!check) {
                    JOptionPane.showMessageDialog(currentView, "Tiket Sudah Dibuat!");
                } else {
                    try {
                        r.createTicket(date, g.getTipeGerbong(), ct4.getTxFieldHarga(), k, g);
                        JOptionPane.showMessageDialog(currentView, "Tiket Berhasil Dibuat!");
                        app.writeFile(app.daftarRute, "Rute.dat");
                        currentView.setVisible(false);
                        menuCreateTiket3 ct3 = menu.getMenuCreateTiket3();
                        currentView = ct3;
                        currentView.setSize(395, 303);
                        currentView.setVisible(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                    }
                }
            } else if (source.equals(ct4.getBtnBatal())) {
                currentView.setVisible(false);
                menuCreateTiket3 ct3 = menu.getMenuCreateTiket3();
                currentView = ct3;
                currentView.setSize(395, 303);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuCreateTiket3())) {
            menuCreateTiket3 ct3 = menu.getMenuCreateTiket3();
            if (source.equals(ct3.getBtnBuat())) {
                int i = 0;
                while ((i < k.getListGerbong().size()) && (k.getListGerbong().get(i).getIdGerbong() != ct3.getTableGerbong())) {
                    i++;
                }
                if (k.getListGerbong().get(i).getIdGerbong() == ct3.getTableGerbong()) {
                    g = k.getListGerbong().get(i);
                }
                currentView.setVisible(false);
                menuCreateTiket4 ct4 = menu.getMenuCreateTiket4();
                currentView = ct4;
                currentView.setSize(400, 223);
                currentView.setVisible(true);
            } else if (source.equals(ct3.getBtnSelesai())) {
                currentView.setVisible(false);
                menuCreateTiket2 ct2 = menu.getMenuCreateTiket2();
                currentView = ct2;
                currentView.setSize(401, 304);
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuCreateTiket2())) {
            menuCreateTiket2 ct2 = menu.getMenuCreateTiket2();
            if (source.equals(ct2.getBtnPilih())) {
                int i = 0;
                while ((i < r.getListKereta().size()) && (r.getListKereta().get(i).getIdKereta() != ct2.getSelectedKereta())) {
                    i++;
                } 
                if (r.getListKereta().get(i).getIdKereta() == ct2.getSelectedKereta()) {
                    k = r.getListKereta().get(i);
                }
                currentView.setVisible(false);
                menuCreateTiket3 ct3 = menu.getMenuCreateTiket3();
                ct3.setTableGerbong(k.getListGerbong());
                currentView = ct3;
                currentView.setSize(395, 303);
                currentView.setVisible(true);
            } else if (source.equals(ct2.getBtnBatal())) {
                currentView.setVisible(false);
                menuCreateTiket ct = menu.getMenuCreateTiket();
                currentView = ct;
                currentView.setSize(400, 300);
                currentView.setVisible(true);
            }
        }
    }
}
