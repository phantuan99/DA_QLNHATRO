/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PhanTuan
 */
public class frm_Index extends javax.swing.JFrame {

    /**
     * Creates new form frm_Index
     */
    public frm_Index() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.setTitle("HỆ THỐNG QUẢN LÝ NHÀ TRỌ/TRANG CHỦ");
        //Nếu không phải admin thì không hiện quản lý user
        if(lbl_role.getText().equals("Admin"))
        {
            btn_QLTK.setVisible(true);
        }
        else
        {
            btn_QLTK.setVisible(false);
        }
    }
     public void setTenUser(String username){ 
        this.lbl_Username.setText(username);
    }
    /**
     * Set Tên role vào form Main
     * @param Role 
     */
          public void setRoleName(String Role){ 
        this.lbl_role.setText(Role);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_QLBill = new javax.swing.JButton();
        btn_QLPhong = new javax.swing.JButton();
        btn_QLHD = new javax.swing.JButton();
        btn_QLKH = new javax.swing.JButton();
        btn_QLKV = new javax.swing.JButton();
        btn_QLTK = new javax.swing.JButton();
        btn_QLDienNuoc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_Username = new javax.swing.JLabel();
        lbl_role = new javax.swing.JLabel();
        bgIMG = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("        HỆ THỐNG QUẢN LÝ NHÀ TRỌ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_QLBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLBill.setText("QUẢN LÝ HÓA ĐƠN");
        btn_QLBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLBillActionPerformed(evt);
            }
        });

        btn_QLPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLPhong.setText("QUẢN LÝ PHÒNG");
        btn_QLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLPhongActionPerformed(evt);
            }
        });

        btn_QLHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLHD.setText("QUẢN LÝ HỢP ĐỒNG");
        btn_QLHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLHDActionPerformed(evt);
            }
        });

        btn_QLKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLKH.setText("QUẢN LÝ KHÁCH HÀNG");
        btn_QLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLKHActionPerformed(evt);
            }
        });

        btn_QLKV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLKV.setText("QUẢN LÝ KHU VỰC");
        btn_QLKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLKVActionPerformed(evt);
            }
        });

        btn_QLTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLTK.setText("QUẢN LÝ TÀI KHOẢN");
        btn_QLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLTKActionPerformed(evt);
            }
        });

        btn_QLDienNuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_QLDienNuoc.setText("QUẢN LÝ ĐIỆN NƯỚC");
        btn_QLDienNuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLDienNuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_QLDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QLTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QLKV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QLBill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QLKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btn_QLHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QLPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_QLBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QLKV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btn_QLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QLHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QLDienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_QLPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(51, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome");

        lbl_Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Username.setText("Name");

        lbl_role.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_role.setForeground(new java.awt.Color(255, 255, 255));
        lbl_role.setText("lbl_Role");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_role)
                    .addComponent(lbl_Username))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_Username))
                .addGap(18, 18, 18)
                .addComponent(lbl_role)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgIMGLayout = new javax.swing.GroupLayout(bgIMG);
        bgIMG.setLayout(bgIMGLayout);
        bgIMGLayout.setHorizontalGroup(
            bgIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bgIMGLayout.setVerticalGroup(
            bgIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bgIMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bgIMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_QLBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLBillActionPerformed
        frm_Bill B = new frm_Bill();
        B.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLBillActionPerformed

    private void btn_QLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLKHActionPerformed
        frm_Customer KH = new frm_Customer();
        KH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLKHActionPerformed

    private void btn_QLHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLHDActionPerformed
        frm_Contract C = new frm_Contract();
        C.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLHDActionPerformed

    private void btn_QLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLPhongActionPerformed
        frm_Room R = new frm_Room();
        R.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLPhongActionPerformed

    private void btn_QLDienNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLDienNuocActionPerformed
        frm_DienNuoc DN = new frm_DienNuoc();
        DN.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLDienNuocActionPerformed

    private void btn_QLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLTKActionPerformed
        frm_UserAccount User = new frm_UserAccount();
        User.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLTKActionPerformed

    private void btn_QLKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLKVActionPerformed
        frm_Area KV = new frm_Area();
        KV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_QLKVActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgIMG;
    private javax.swing.JButton btn_QLBill;
    private javax.swing.JButton btn_QLDienNuoc;
    private javax.swing.JButton btn_QLHD;
    private javax.swing.JButton btn_QLKH;
    private javax.swing.JButton btn_QLKV;
    private javax.swing.JButton btn_QLPhong;
    private javax.swing.JButton btn_QLTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JLabel lbl_role;
    // End of variables declaration//GEN-END:variables
}
