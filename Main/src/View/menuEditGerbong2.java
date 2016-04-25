/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Gerbong;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Rizza
 */
public class menuEditGerbong2 extends javax.swing.JPanel {

    /**
     * Creates new form menuEditGerbong2
     */
    public menuEditGerbong2() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGerbong = new javax.swing.JTable();
        btnBatal = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Data Gerbong");

        tableGerbong.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Jenis Gerbong", "Kapasitas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tableGerbong.setCellSelectionEnabled(false);
        tableGerbong.setRowSelectionAllowed(true);
        tableGerbong.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableGerbong);
        tableGerbong.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableGerbong.getColumnModel().getColumnCount() > 0) {
            tableGerbong.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableGerbong.getColumnModel().getColumn(1).setPreferredWidth(160);
            tableGerbong.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        btnBatal.setText("Batal");

        btnEdit.setText("Edit");

        btnHapus.setText("Hapus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGerbong;
    // End of variables declaration//GEN-END:variables

    public Object getBtnBatal() {
        return btnBatal;
    }

    public Object getBtnEdit() {
        return btnEdit;
    }

    public Object getBtnHapus() {
        return btnHapus;
    }

    public int getTableGerbong() {
        return (int) tableGerbong.getValueAt(tableGerbong.getSelectedRow(), 0);
    }
    
    public void setTableGerbong(List<Gerbong> list) {
        tableGerbong.clearSelection();
        for (int i = 0; i < tableGerbong.getRowCount(); i++) {
            tableGerbong.setValueAt("", i, 0);
            tableGerbong.setValueAt("", i, 1);
            tableGerbong.setValueAt("", i, 2);
        }
        for (int i = 0; i < list.size(); i++) {
            tableGerbong.setValueAt(list.get(i).getIdGerbong(), i, 0);
            tableGerbong.setValueAt(list.get(i).getJenisGerbong(), i, 1);
            tableGerbong.setValueAt(list.get(i).getKapasitas(), i, 2);
        }
    }    

    public void addListener (ActionListener e) {
        btnBatal.addActionListener(e);
        btnEdit.addActionListener(e);
        btnHapus.addActionListener(e);
    }
    
    public void addAdapter (MouseAdapter e) {
        tableGerbong.addMouseListener(e);
    }
    
}
