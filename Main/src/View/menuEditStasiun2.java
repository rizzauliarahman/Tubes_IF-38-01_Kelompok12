/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Rizza
 */
public class menuEditStasiun2 extends javax.swing.JPanel {

    /**
     * Creates new form menuEditStasiun2
     */
    public menuEditStasiun2() {
        initComponents();
//        setListStasiun(app.daftarStasiun);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStasiun = new javax.swing.JTable();
        txLabelEditStasiun = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        tableStasiun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No Stasiun", "Nama Stasiun", "Kota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStasiun.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableStasiun.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableStasiun);
        tableStasiun.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableStasiun.getColumnModel().getColumnCount() > 0) {
            tableStasiun.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableStasiun.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableStasiun.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        txLabelEditStasiun.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txLabelEditStasiun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txLabelEditStasiun.setText("Edit Stasiun");

        btnEdit.setText("Edit");

        btnKembali.setText("Kembali");

        btnHapus.setText("Hapus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txLabelEditStasiun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 181, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addGap(20, 20, 20)
                        .addComponent(btnHapus)
                        .addGap(19, 19, 19)
                        .addComponent(btnKembali))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txLabelEditStasiun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnKembali)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableStasiun;
    private javax.swing.JLabel txLabelEditStasiun;
    // End of variables declaration//GEN-END:variables

    public Object getBtnEdit() {
        return btnEdit;
    }

    public Object getBtnKembali() {
        return btnKembali;
    }  
    
    public Object getBtnHapus() {
        return btnHapus;
    }
    
    public void addListener (ActionListener e) {
        btnEdit.addActionListener(e);
        btnHapus.addActionListener(e);
        btnKembali.addActionListener(e);
    }
    
    public void addAdapter (MouseAdapter e) {
        tableStasiun.addMouseListener(e);
    }
    
    public void setTabelStasiun(List<Stasiun> list) {
        for (int i = 0; i < tableStasiun.getRowCount(); i++) {
            tableStasiun.setValueAt("", i, 0);
            tableStasiun.setValueAt("", i, 1);
            tableStasiun.setValueAt("", i, 2);
        }
        for (int i = 0; i < list.size(); i++) {
            tableStasiun.setValueAt(list.get(i).getNomorStasiun(), i, 0);
            tableStasiun.setValueAt(list.get(i).getNamaStasiun(), i, 1);
            tableStasiun.setValueAt(list.get(i).getKota(), i, 2);
        }
    }
    
    public int getSelectedStasiun() {
        return (int) tableStasiun.getValueAt(tableStasiun.getSelectedRow(), 0);
    }
    
//    public void removeRow() {
//        tableStasiun.remove(tableStasiun.getSelectedRow());
//    }
    
}
