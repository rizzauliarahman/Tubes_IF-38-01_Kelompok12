/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Rizza
 */
public class menuEditRute extends javax.swing.JPanel {

    /**
     * Creates new form menuEditRute
     */
    public menuEditRute() {
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

        jLabel1 = new javax.swing.JLabel();
        btnTambahRute = new javax.swing.JButton();
        btnEditRute = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Data Rute");

        btnTambahRute.setText("Tambahkan Data Rute");

        btnEditRute.setText("Edit Data Rute yang Ada");

        btnKembali.setText("Kembali ke Menu Utama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(btnTambahRute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditRute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(btnTambahRute)
                .addGap(18, 18, 18)
                .addComponent(btnEditRute)
                .addGap(54, 54, 54)
                .addComponent(btnKembali)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditRute;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambahRute;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public Object getBtnEditRute() {
        return btnEditRute;
    }

    public Object getBtnKembali() {
        return btnKembali;
    }

    public Object getBtnTambahRute() {
        return btnTambahRute;
    }

    public void addListener (ActionListener e) {
        btnEditRute.addActionListener(e);
        btnKembali.addActionListener(e);
        btnTambahRute.addActionListener(e);
    }

}
