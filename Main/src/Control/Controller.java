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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rizza
 */
public class Controller implements ActionListener {
    menuList menu;
    JPanel currentView = new JPanel();
    Application app = new Application();

    public Controller() throws Exception {
        menu = new menuList();
        currentView = menu.getMainMenu();
        menu.setVisible(true);
        currentView.setVisible(true);
        menu.addListener(this);
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
        Kereta k = null;
        Object source = ae.getSource();
        if (currentView.equals(menu.getMainMenu())) {
            mainMenu mm = menu.getMainMenu();
            if (source.equals(mm.getBtnMenuEditStasiun())) {
                currentView.setVisible(false);
                menuEditStasiun es = menu.getMenuEditStasiun();
                currentView = menu.getMenuEditStasiun();
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuEditKereta())) {
                currentView.setVisible(false);
                menuEditKereta ek = menu.getMenuEditKereta();
                currentView = ek;
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuEditRute())) {
                currentView.setVisible(false);
                menuEditRute er = menu.getMenuEditRute();
                currentView = er;
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnMenuBuatTiket())) {
                currentView.setVisible(false);
                menuCreateTiket ct = menu.getMenuCreateTiket();
                currentView = ct;
                currentView.setVisible(true);
            } else if (source.equals(mm.getBtnExit())) {
                System.exit(0);
            }
        } else if (currentView.equals(menu.getMenuEditStasiun())) {
            menuEditStasiun es = menu.getMenuEditStasiun();
            if (source.equals(es.getBtnTambahStasiun())) {
                currentView.setVisible(false);
                menuAddStasiun as = menu.getMenuAddStasiun();
                currentView =  as;
                currentView.setVisible(true);
            } else if (source.equals(es.getBtnEditStasiun())) {
                currentView.setVisible(false);
                menuEditStasiun2 es2 = menu.getMenuEditStasiun2();
                es2.setTabelStasiun(app.daftarStasiun);
                currentView =  es2;
                currentView.setVisible(true);
            } else if (source.equals(es.getBtnBacktoMainMenu())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView =  mm;
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditKereta())) {
            menuEditKereta ek = menu.getMenuEditKereta();
            if (source.equals(ek.getBtnMenuAddKereta())) {
                currentView.setVisible(false);
                menuAddKereta ak = menu.getMenuAddKereta();
                currentView = ak;
                currentView.setVisible(true);
            } else if (source.equals(ek.getBtnMenuEditKereta())) {
                currentView.setVisible(false);
                menuEditKereta2 ek2 = menu.getMenuEditKereta2();
                currentView = ek2;
                currentView.setVisible(true);
            } else if (source.equals(ek.getBtnBack())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView = mm;
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditRute())) {
            menuEditRute er = menu.getMenuEditRute();
            if (source.equals(er.getBtnTambahRute())) {
                currentView.setVisible(false);
                menuAddRute ar = menu.getMenuAddRute();
                currentView = ar;
                currentView.setVisible(true);
            } else if (source.equals(er.getBtnEditRute())) {
                currentView.setVisible(false);
                menuAddRute ar = menu.getMenuAddRute();
                currentView = ar;
                currentView.setVisible(true);
            } else if (source.equals(er.getBtnKembali())) {
                currentView.setVisible(false);
                mainMenu mm = menu.getMainMenu();
                currentView = mm;
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuAddStasiun())) {
            menuAddStasiun as = menu.getMenuAddStasiun();
            int nomor;
            if (source.equals(as.getBtnOk())) {
                try {
                    nomor = as.getTxFieldNoStasiun();
                    Stasiun a = app.menuSearchStasiun(nomor) ;
                    if (a != null) {
                        Stasiun s = new Stasiun(as.getTxFieldNamaStasiun(), as.getTxFieldSingkatan(), as.getTxFieldNoStasiun());
                        s.setAlamat(as.getTxFieldAlamat());
                        s.setKota(as.getTxFieldKota());
                        try {
                            app.menuAddStasiun(s);
                            JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                            app.writeFile(app.daftarStasiun, "Stasiun.dat");
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
                currentView.setVisible(true);
            } else if (source.equals(es2.getBtnHapus())) {
                app.daftarStasiun.removeIf((Stasiun o) -> o.getNomorStasiun() == es2.getSelectedStasiun());
                JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                currentView.setVisible(false);
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
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditStasiunDetil())) {
            menuEditStasiunDetil esd = menu.getMenuEditStasiunDetil();
            if (source.equals(esd.getBtnOk())) {
                try {
                    Stasiun s = app.menuSearchStasiun(esd.getTxFieldNoStasiun());
                    int idx = app.daftarStasiun.indexOf(s);
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
                currentView.setVisible(true);
            } else if (source.equals(ek2.getBtnHapus())) {
                app.daftarKereta.removeIf((Kereta o) -> o.getIdKereta() == ek2.getSelectedKereta());
                JOptionPane.showMessageDialog(currentView, "Data Berhasil Dihapus!");
                currentView.setVisible(false);
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
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(ak.getBtnBatal())) {
                currentView.setVisible(false);
                menuEditKereta ek = menu.getMenuEditKereta();
                currentView = ek;
                currentView.setVisible(true);
            }
        } else if (currentView.equals(menu.getMenuEditKeretaDetil())) {
            menuEditKeretaDetil edk = menu.getMenuEditKeretaDetil();
            if (source.equals(edk.getBtnSimpan())) {
                try {
                    k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == edk.getTxFieldNoKereta()).findFirst().orElse(null);
                    int idx = app.daftarKereta.indexOf(k);
                    k.setNamaKereta(edk.getTxFieldNamaKereta());
                    k.setTipeKereta(edk.getComBoxJenisKereta() + 1);
                    app.daftarKereta.set(idx, k);
                    JOptionPane.showMessageDialog(currentView, "Data Berhasil Diubah!");
                    app.writeFile(app.daftarKereta, "Kereta.dat");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                }
            } else if (source.equals(edk.getBtnEditGerbong())) {
                k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == edk.getTxFieldNoKereta()).findFirst().orElse(null);
                currentView.setVisible(false);
                menuEditGerbong2 eg2 = menu.getMenuEditGerbong2();
                eg2.setTableGerbong(k.getListGerbong());
                currentView = eg2;
                currentView.setVisible(true);
                if (currentView.equals(menu.getMenuEditGerbong2())) {
                    eg2 = menu.getMenuEditGerbong2();
                    if (source.equals(eg2.getBtnEdit())) {
                        Gerbong g =  k.getGerbong(eg2.getTableGerbong());
                        int idx = k.getListGerbong().indexOf(g);
                        currentView.setVisible(false);
                        menuEditGerbongDetil egd = menu.getMenuEditGerbongDetil();
                        egd.setComponentsData(g);
                        currentView = egd;
                        currentView.setVisible(true);
                        if (currentView.equals(menu.getMenuEditGerbongDetil())) {
                            egd = menu.getMenuEditGerbongDetil();
                            if (source.equals(egd.getBtnSimpan())) {
                                g.setKapasitas(egd.getTxFieldKapasitas());
                                g.setTipeGerbong(egd.getComBoxJenisGerbong()+1);
                                k.getListGerbong().set(idx, g);
                                currentView.setVisible(false);
                                eg2 = menu.getMenuEditGerbong2();
                                currentView = eg2;
                                currentView.setVisible(true);
                            }
                        }
                    }
                }
            } else if (source.equals(edk.getBtnTambahGerbong())) {
                k = app.daftarKereta.stream().filter((Kereta o) -> o.getIdKereta() == edk.getTxFieldNoKereta()).findFirst().orElse(null);
                currentView.setVisible(false);
                menuAddGerbong ag = menu.getMenuAddGerbong();
                currentView = ag;
                currentView.setVisible(true);
                if (currentView.equals(menu.getMenuAddGerbong())) {
                    ag = menu.getMenuAddGerbong();
                    if (source.equals(ag.getBtnTambah())) {
                        try {
                            Gerbong g = new Gerbong(ag.getTxFieldKapasitas(), ag.getComBoxJenisGerbong() + 1);
                            for (int i = 0; i < ag.getTxFieldJumlah(); i++) {
                                k.addGerbong(g);
                            }
                            JOptionPane.showMessageDialog(currentView, "Data Berhasil Disimpan!");
                            app.writeFile(app.daftarKereta, "Kereta.dat");
                            currentView.setVisible(false);
                            menuEditKeretaDetil ekd = menu.getMenuEditKeretaDetil();
                            currentView = ekd; 
                            currentView.setVisible(true);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(currentView, "Terjadi Error : "+e.getMessage());
                        }
                    } else if (source.equals(ag.getBtnBatal())) {
                        currentView.setVisible(false);
                        menuEditKeretaDetil ekd = menu.getMenuEditKeretaDetil();
                        currentView = ekd;
                        currentView.setVisible(true);
                    }
                }
            } else if (currentView.equals(menu.getMenuEditRute2())) {
                
            }
        }
    }
        
}
