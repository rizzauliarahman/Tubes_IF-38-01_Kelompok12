/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;

/**
 *
 * @author Rizza
 */
public class menuList extends javax.swing.JFrame {

    /**
     * Creates new form menuList
     */
    public menuList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenu = new View.mainMenu();
        menuAddGerbong = new View.menuAddGerbong();
        menuAddKereta = new View.menuAddKereta();
        menuAddRute = new View.menuAddRute();
        menuAddStasiun = new View.menuAddStasiun();
        menuCreateTiket = new View.menuCreateTiket();
        menuCreateTiket2 = new View.menuCreateTiket2();
        menuCreateTiket3 = new View.menuCreateTiket3();
        menuEditGerbong2 = new View.menuEditGerbong2();
        menuEditGerbongDetil = new View.menuEditGerbongDetil();
        menuEditKereta = new View.menuEditKereta();
        menuEditKereta2 = new View.menuEditKereta2();
        menuEditKeretaDetil = new View.menuEditKeretaDetil();
        menuEditRute = new View.menuEditRute();
        menuEditRute2 = new View.menuEditRute2();
        menuEditRuteDetil = new View.menuEditRuteDetil();
        menuEditStasiun = new View.menuEditStasiun();
        menuEditStasiun2 = new View.menuEditStasiun2();
        menuEditStasiunDetil = new View.menuEditStasiunDetil();
        menuTambahGerbongKereta = new View.menuTambahGerbongKereta();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(mainMenu, "card2");
        getContentPane().add(menuAddGerbong, "card3");
        getContentPane().add(menuAddKereta, "card4");
        getContentPane().add(menuAddRute, "card5");
        getContentPane().add(menuAddStasiun, "card6");
        getContentPane().add(menuCreateTiket, "card7");
        getContentPane().add(menuCreateTiket2, "card8");
        getContentPane().add(menuCreateTiket3, "card9");
        getContentPane().add(menuEditGerbong2, "card10");
        getContentPane().add(menuEditGerbongDetil, "card11");
        getContentPane().add(menuEditKereta, "card12");
        getContentPane().add(menuEditKereta2, "card13");
        getContentPane().add(menuEditKeretaDetil, "card14");
        getContentPane().add(menuEditRute, "card15");
        getContentPane().add(menuEditRute2, "card16");
        getContentPane().add(menuEditRuteDetil, "card17");
        getContentPane().add(menuEditStasiun, "card18");
        getContentPane().add(menuEditStasiun2, "card19");
        getContentPane().add(menuEditStasiunDetil, "card20");
        getContentPane().add(menuTambahGerbongKereta, "card21");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.mainMenu mainMenu;
    private View.menuAddGerbong menuAddGerbong;
    private View.menuAddKereta menuAddKereta;
    private View.menuAddRute menuAddRute;
    private View.menuAddStasiun menuAddStasiun;
    private View.menuCreateTiket menuCreateTiket;
    private View.menuCreateTiket2 menuCreateTiket2;
    private View.menuCreateTiket3 menuCreateTiket3;
    private View.menuEditGerbong2 menuEditGerbong2;
    private View.menuEditGerbongDetil menuEditGerbongDetil;
    private View.menuEditKereta menuEditKereta;
    private View.menuEditKereta2 menuEditKereta2;
    private View.menuEditKeretaDetil menuEditKeretaDetil;
    private View.menuEditRute menuEditRute;
    private View.menuEditRute2 menuEditRute2;
    private View.menuEditRuteDetil menuEditRuteDetil;
    private View.menuEditStasiun menuEditStasiun;
    private View.menuEditStasiun2 menuEditStasiun2;
    private View.menuEditStasiunDetil menuEditStasiunDetil;
    private View.menuTambahGerbongKereta menuTambahGerbongKereta;
    // End of variables declaration//GEN-END:variables

    public mainMenu getMainMenu() {
        return mainMenu;
    }

    public menuAddGerbong getMenuAddGerbong() {
        return menuAddGerbong;
    }

    public menuAddKereta getMenuAddKereta() {
        return menuAddKereta;
    }

    public menuAddRute getMenuAddRute() {
        return menuAddRute;
    }

    public menuAddStasiun getMenuAddStasiun() {
        return menuAddStasiun;
    }

    public menuCreateTiket getMenuCreateTiket() {
        return menuCreateTiket;
    }

    public menuCreateTiket2 getMenuCreateTiket2() {
        return menuCreateTiket2;
    }

    public menuCreateTiket3 getMenuCreateTiket3() {
        return menuCreateTiket3;
    }

    public menuEditGerbong2 getMenuEditGerbong2() {
        return menuEditGerbong2;
    }

    public menuEditGerbongDetil getMenuEditGerbongDetil() {
        return menuEditGerbongDetil;
    }

    public menuEditKereta getMenuEditKereta() {
        return menuEditKereta;
    }

    public menuEditKereta2 getMenuEditKereta2() {
        return menuEditKereta2;
    }

    public menuEditKeretaDetil getMenuEditKeretaDetil() {
        return menuEditKeretaDetil;
    }

    public menuEditRute getMenuEditRute() {
        return menuEditRute;
    }

    public menuEditRute2 getMenuEditRute2() {
        return menuEditRute2;
    }

    public menuEditRuteDetil getMenuEditRuteDetil() {
        return menuEditRuteDetil;
    }

    public menuEditStasiun getMenuEditStasiun() {
        return menuEditStasiun;
    }

    public menuEditStasiun2 getMenuEditStasiun2() {
        return menuEditStasiun2;
    }

    public menuEditStasiunDetil getMenuEditStasiunDetil() {
        return menuEditStasiunDetil;
    }

    public menuTambahGerbongKereta getMenuTambahGerbongKereta() {
        return menuTambahGerbongKereta;
    }

    public void addListener (ActionListener e) {
        mainMenu.addListener(e);
        menuAddGerbong.addListener(e);
        menuAddKereta.addListener(e);
        menuAddRute.addListener(e);
        menuAddStasiun.addListener(e);
        menuCreateTiket.addListener(e);
        menuCreateTiket2.addListener(e);
        menuCreateTiket3.addListener(e);
        menuEditGerbong2.addListener(e);
        menuEditGerbongDetil.addListener(e);
        menuEditKereta.addListener(e);
        menuEditKereta2.addListener(e);
        menuEditKeretaDetil.addListener(e);
        menuEditRute.addListener(e);
        menuEditRute2.addListener(e);
        menuEditRuteDetil.addListener(e);
        menuEditStasiun.addListener(e);
        menuEditStasiun2.addListener(e);
        menuEditStasiunDetil.addListener(e);
        menuTambahGerbongKereta.addListener(e);
    }

}