/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.calendar.DateUtils;
import javax.swing.table.DefaultTableCellRenderer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.sql.Time;
import java.sql.Date; // Import untuk kelas Date yang sesuai dengan JDBC
import java.time.LocalDate; // Import untuk kelas LocalDate



/**
 *
 * @author Rad
 */
public class AgendaPribadi extends javax.swing.JFrame {

    private Connection conn;
    
    public AgendaPribadi() {
        initComponents();
        conn = Koneksi.getConnection();
        getData();
        matikanButton();
        aktifkanButton();
    }

    private void getData() {  
        
        // Set tanggal dan jam
        dp_agenda.setDateToToday();  // 
        tp_agenda.setTime(LocalTime.of(12, 0));

        //Rata tengah cell tabel
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tb_agenda.setDefaultRenderer(Object.class, centerRenderer);             

        DefaultTableModel model = (DefaultTableModel) tb_agenda.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT * FROM tbagenda";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            // Menggunakan SimpleDateFormat untuk memformat tanggal dan jam
            SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfWaktu = new SimpleDateFormat("HH:mm");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama_agenda = rs.getString("nama_agenda");

                // Menggunakan java.sql.Date untuk menangani tanggal
                java.sql.Date tanggal_agenda = rs.getDate("tanggal_agenda");

                // Menggunakan java.sql.Time untuk menangani waktu
                java.sql.Time waktu_agenda = rs.getTime("waktu_agenda");

                // Memformat tanggal dan waktu menjadi string sesuai format
                String formattedTanggal = sdfTanggal.format(tanggal_agenda);
                String formattedWaktu = sdfWaktu.format(waktu_agenda);

                String catatan = rs.getString("catatan");

                Object[] rowData = {id, nama_agenda, formattedTanggal, formattedWaktu, catatan};
                model.addRow(rowData);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(AgendaPribadi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    


    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_agenda = new javax.swing.JTable();
        t_cari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bt_tambah = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_batal = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tp_agenda = new com.github.lgooddatepicker.components.TimePicker();
        jLabel2 = new javax.swing.JLabel();
        dp_agenda = new com.github.lgooddatepicker.components.DatePicker();
        jLabel3 = new javax.swing.JLabel();
        t_namaAgenda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Catatan = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Agenda Pribadi");
        setBackground(new java.awt.Color(0, 153, 102));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel4.setText("APLIKASI AGENDA PRIBADI");
        jLabel4.setFont(new java.awt.Font("Spartan", 1, 24)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "List Agenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tb_agenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tb_agenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Agenda", "Tanggal Agenda", "Waktu Agenda", "Catatan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_agenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tb_agenda.setForeground(new java.awt.Color(51, 51, 51));
        tb_agenda.setGridColor(new java.awt.Color(204, 204, 204));
        tb_agenda.setRowHeight(30);
        tb_agenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_agendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_agenda);
        if (tb_agenda.getColumnModel().getColumnCount() > 0) {
            tb_agenda.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_agenda.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_agenda.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_agenda.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        t_cari.setText("Pencarian");
        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah Agenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_update.setText("Perbarui");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_batal.setText("Batal");
        bt_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_batalActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Agenda");
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tanggal Agenda");
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Catatan");
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        txt_Catatan.setColumns(20);
        txt_Catatan.setRows(5);
        jScrollPane2.setViewportView(txt_Catatan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dp_agenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tp_agenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(t_namaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(194, 194, 194)
                            .addComponent(jLabel3)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(bt_tambah)
                            .addGap(18, 18, 18)
                            .addComponent(bt_batal)
                            .addGap(18, 18, 18)
                            .addComponent(bt_update)
                            .addGap(18, 18, 18)
                            .addComponent(bt_hapus)
                            .addGap(235, 235, 235)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t_namaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tp_agenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_agenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_batal)
                    .addComponent(bt_tambah)
                    .addComponent(bt_update)
                    .addComponent(bt_hapus))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        int selectedRow = tb_agenda.getSelectedRow();

        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diHapus");
            return;
        }

        int confirm= JOptionPane.showConfirmDialog(this,"Apakah Anda yakin ingin menghapus Agenda?", "Konfirmasi",JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){
            String id = tb_agenda.getValueAt(selectedRow,0).toString();

            try {
                String sql ="DELETE FROM tbagenda WHERE id=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,id);

                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this,"Agenda berhasil diHapus!");
                    resetForm();
                    getData();
                }

                st.close();

            } catch (Exception e) {
                Logger.getLogger(AgendaPribadi.class.getName()).log(Level.SEVERE,null,e);
            }
        }

        resetForm();
        getData();
        aktifkanButton();
        matikanButton();
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_batalActionPerformed
        resetForm();
        aktifkanButton();
        matikanButton();
    }//GEN-LAST:event_bt_batalActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        int selectedRow = tb_agenda.getSelectedRow();

        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbaharui");
            return;
        }

        String id = tb_agenda.getValueAt(selectedRow, 0).toString();
        String nama_agenda = t_namaAgenda.getText();
        LocalDate tanggal_agenda = dp_agenda.getDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(tanggal_agenda);

        // Ambil waktu dari TimePicker
        LocalTime waktu_agenda = tp_agenda.getTime();

        // Konversi LocalTime ke format string HH:mm
        String formattedWaktu = waktu_agenda.format(DateTimeFormatter.ofPattern("HH:mm"));

        String catatan = txt_Catatan.getText();

        if(nama_agenda.isEmpty()){
            JOptionPane.showMessageDialog(this, "Kolom Nama Agenda harus diisi!", "Validasi",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE tbagenda SET nama_agenda=?,tanggal_agenda=?,waktu_agenda=?,catatan=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nama_agenda);
            st.setDate(2, sqlDate);
            st.setString(3, formattedWaktu);
            st.setString(4, catatan);
            st.setString(5, id);

            // Eksekusi kueri UPDATE
            int rowsUpdated = st.executeUpdate();

            if (rowsUpdated > 0) {
                // Data berhasil diperbaharui
                JOptionPane.showMessageDialog(this, "Agenda Berhasil Diperbaharui!");
                resetForm();
                getData();
            } else {
                // Data tidak berhasil diperbaharui
                JOptionPane.showMessageDialog(this, "Gagal Memperbaharui Agenda!", "pesanGagal",JOptionPane.ERROR_MESSAGE);
            }

            st.close();
        } catch (Exception e) {
            Logger.getLogger(AgendaPribadi.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        String nama_agenda = t_namaAgenda.getText();

        // Mendapatkan tanggal dari DatePicker
        LocalDate tanggal_agenda = dp_agenda.getDate();

        // Mendapatkan waktu dari TimePicker
        java.time.LocalTime waktu_agenda = tp_agenda.getTime();

        // Mengonversi LocalDate ke dalam format yang sesuai untuk database
        String formattedTanggal = tanggal_agenda.toString();

        // Mengonversi LocalTime ke dalam format yang sesuai untuk database
        String formattedWaktu = waktu_agenda.format(DateTimeFormatter.ofPattern("HH:mm"));

        String catatan = txt_Catatan.getText();

        if (nama_agenda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kolom Nama Agenda harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO tbagenda (nama_agenda, tanggal_agenda, waktu_agenda, catatan) VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nama_agenda);
            st.setString(2, formattedTanggal);
            st.setString(3, formattedWaktu);
            st.setString(4, catatan);

            // Eksekusi kueri INSERT
            int rowsInserted = st.executeUpdate();

            if (rowsInserted > 0) {
                // Data berhasil ditambahkan
                JOptionPane.showMessageDialog(this, "Agenda Berhasil Ditambahkan!");
                resetForm();
                getData();
            } else {
                // Data tidak berhasil ditambahkan
                JOptionPane.showMessageDialog(this, "Gagal Menambahkan Agenda!", "pesanGagal", JOptionPane.ERROR_MESSAGE);
            }

            st.close();
        } catch (Exception e) {
            Logger.getLogger(AgendaPribadi.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) tb_agenda.getModel();
        model.setRowCount(0);

        //mencari data dari tabel
        String cari = t_cari.getText();
        try {
            String sql = "SELECT * FROM tbagenda WHERE nama_agenda LIKE ? OR catatan LIKE ? OR tanggal_agenda LIKE ? OR waktu_agenda LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");

            ResultSet rs = st.executeQuery();

            SimpleDateFormat sdfTanggal = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfWaktu = new SimpleDateFormat("HH:mm");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama_agenda = rs.getString("nama_agenda");

                // Menggunakan java.sql.Date untuk menangani tanggal
                java.util.Date utilDate = sdfTanggal.parse(rs.getString("tanggal_agenda"));
                java.sql.Date tanggal_agenda = new java.sql.Date(utilDate.getTime());

                // Menggunakan java.sql.Time untuk menangani waktu
                java.sql.Time waktu_agenda = java.sql.Time.valueOf(rs.getString("waktu_agenda"));

                // Mengubah waktu_agenda ke dalam format "hh:mm"
                String formattedWaktu = sdfWaktu.format(waktu_agenda);

                String catatan = rs.getString("catatan");

                Object[] rowData = {id, nama_agenda, tanggal_agenda, formattedWaktu, catatan};
                model.addRow(rowData);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(AgendaPribadi.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void tb_agendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_agendaMouseClicked
        
        //memilih data dan memasukan ke textfield
        int selectedRow = tb_agenda.getSelectedRow();

        if (selectedRow != -1) {
            String nama_agenda = tb_agenda.getValueAt(selectedRow, 1).toString();

            // Konversi String ke LocalDate
            LocalDate tanggal_agenda = LocalDate.parse(tb_agenda.getValueAt(selectedRow, 2).toString());

            // Ambil waktu_agenda dari database sebagai String
            String waktu_agenda_str = tb_agenda.getValueAt(selectedRow, 3).toString();

            // Konversi String ke LocalTime
            LocalTime waktu_agenda = LocalTime.parse(waktu_agenda_str);

            // Set tanggal pada DatePicker
            dp_agenda.setDate(tanggal_agenda);

            // Set waktu pada TimePicker
            tp_agenda.setTime(waktu_agenda);

            String catatan = tb_agenda.getValueAt(selectedRow, 4).toString();

            t_namaAgenda.setText(nama_agenda);
            txt_Catatan.setText(catatan);
        }

        bt_tambah.setEnabled(false);
        bt_update.setEnabled(true);
        bt_hapus.setEnabled(true);
        bt_batal.setEnabled(true);
    }//GEN-LAST:event_tb_agendaMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaPribadi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_batal;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton bt_update;
    private com.github.lgooddatepicker.components.DatePicker dp_agenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_namaAgenda;
    private javax.swing.JTable tb_agenda;
    private com.github.lgooddatepicker.components.TimePicker tp_agenda;
    private javax.swing.JTextArea txt_Catatan;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        
        //bersihkan textfield
        t_namaAgenda.setText("");
        // Mengatur ulang dp_agenda ke tanggal saat ini
        dp_agenda.setDateToToday();
        tp_agenda.setTime(LocalTime.of(12, 0));
        txt_Catatan.setText("");
        
    }

    private void matikanButton() {
        bt_update.setEnabled(false);   
        bt_hapus.setEnabled(false);
    }

    private void aktifkanButton() {
       bt_tambah.setEnabled(true);
       bt_batal.setEnabled(true);
    }

    
}
