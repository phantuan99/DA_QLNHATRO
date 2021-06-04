/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;

import Services.AreaServices;
import Services.DienNuocServices;
import Entities.*;
import java.awt.Component;
/**
 *
 * @author PhanTuan
 */
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class frm_DienNuoc extends javax.swing.JFrame {

    /**
     * Creates new form frm_DienNuoc
     */
    DienNuocServices DNServices = new DienNuocServices();
    AreaServices KVServices = new AreaServices();

    ArrayList<DienNuoc> DSDN = new ArrayList<DienNuoc>();
    ArrayList<Area> DSKV = new ArrayList<Area>();
    DienNuoc selectedDN = null;
    
    
    
    public frm_DienNuoc() {
        initComponents();
        loadKV();
        showDataList();
    }
    
    
  private void loadKV(){
        cbb_KV.removeAllItems();// Xóa hết những giá trị có trong combobox
        DSKV = KVServices.getAllRecords();//Select các giá trị của khách hàng
       // Lấy từng đối tượng khách hàng dạng object
        for(Area KV : DSKV){
            cbb_KV.addItem(KV);
        }
          cbb_KV.setRenderer(new DefaultListCellRenderer() {
              @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Area){
                    Area KV = (Area) value;                  
                    setText( String.valueOf( KV.getTENKV()));
                }
                return this;
            }
        } );
   
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_grid = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cbb_KV = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txt_GiaDien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_GiaNuoc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ ĐIỆN NƯỚC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tab_grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã Khu Vực", "Giá Điện", "Giá Nước"
            }
        ));
        jScrollPane1.setViewportView(tab_grid);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbb_KV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giá Nước");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Khu Vực");

        txt_ID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txt_GiaDien.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Giá Điện");

        txt_GiaNuoc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbb_KV, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_GiaDien, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_GiaNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_KV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_GiaDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_GiaNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbb_KV, txt_GiaDien, txt_GiaNuoc, txt_ID});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_del.setText("Xóa");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        jButton3.setText("Làm mới");

        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jButton4.setText("Trang chủ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDataList(){
        // Khai báo defaul model
        DefaultTableModel model = (DefaultTableModel)this.tab_grid.getModel(); 
        model.setRowCount(0); // Set count = 0
                
        //Select toàn bộ data của hợp động vào list
        ArrayList<DienNuoc> list = DNServices.getAllRecords();
        
      
        DSDN = list;//dùng cho việc chọn phiếu điện nước
               
        Object[] row = new Object[4]; // Khai báo mảng
        
        //Gán các item tương đương cho table
        for(int i = 0; i < list.size(); i++){            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getMaKV();
            row[2] = list.get(i).getGiaDien();
            row[3] = list.get(i).getGiaNuoc();
            int a = list.get(i).getGiaNuoc();
            
               // txt_a.addItem(String.valueOf(a)); 
            model.addRow(row);
        }
        //Lớp interface thể hiện vùng chọn tĩnh
        ListSelectionModel cellSelectionModel = tab_grid.getSelectionModel();
        
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chế độ chọn đơn
        //Thêm listener vào DS mỗi khi vùng chọn có thay đổi       
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //Gọi đến thay đổi grid
                gridSelectedChanged(e);
            }
          });
    }
    
    
      public void gridSelectedChanged(ListSelectionEvent e) {
     String selectedData = null;
     int selectedID = 0; 
       
       int[] selectedRows = tab_grid.getSelectedRows();
       int[] selectedColumns = tab_grid.getSelectedColumns();
        
       int selectedRow = tab_grid.getSelectedRow();
       int selectedColumn = tab_grid.getSelectedColumn();
       
       if(selectedRow >=0 && selectedColumn >=0){
           selectedData = String.valueOf(tab_grid.getValueAt(selectedRow, selectedColumn));
           selectedID = (int) tab_grid.getValueAt(selectedRow, 0);
           
           selectedDN= findDN(selectedID,DSDN);
           
           System.out.println("Selected: " + selectedData + " , value: " + selectedID);
               if(selectedID != 0){
               showDataDetail(selectedID,
                                    (int)tab_grid.getValueAt(selectedRow, 1), 
                                    (int) tab_grid.getValueAt(selectedRow, 2), 
                                    (int)tab_grid.getValueAt(selectedRow, 3));
                                  
                   
               }       
       }
    }
       private void showDataDetail(int Id, int MaKV,  int GiaDien, int GiaNuoc){
     
        txt_ID.setText(""+ Id);        
        txt_GiaDien.setText(String.valueOf(GiaDien));
        txt_GiaNuoc.setText(String.valueOf(GiaNuoc));
       
        if(selectedDN != null){
            cbb_KV.setSelectedItem(findKV(selectedDN.getMaKV(), DSKV));
          
    }
 }
            public Area findKV(int MaKV, ArrayList<Area> DSKV) {
            for (Area item : DSKV) {
                if (item.getMAKV()== MaKV) {
                    return item;
                }
            }
            return null;
          }
             public DienNuoc findDN(int Id, ArrayList<DienNuoc> DSDN) {
            for (DienNuoc item : DSDN) {
                if (item.getID()== Id) {
                    return item;
                }
            }
            return null;
          }

    
    
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
          
            Area KV = (Area) cbb_KV.getSelectedItem();
            String GiaDien = txt_GiaDien.getText();
             String GiaNuoc = txt_GiaNuoc.getText();
        if(txt_GiaDien.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Bạn cần phải nhập giá điện");
        }
        
        
        else
        { 
         //call function
        int rowEffected = DNServices.AddNewRecord(KV.getMAKV(),Integer.parseInt(GiaDien),Integer.parseInt(GiaNuoc));
         if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Tao moi thanh cong!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        if(!txt_ID.getText().trim().isEmpty())
        {
            int ID = Integer.parseInt(txt_ID.getText());
            int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(input == 0)
            {
      
                int rowEffected = DNServices.DeleteRecord(ID);
                if(rowEffected > 0){
                    showDataList();
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                }
                else
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Xin chọn thông tin phiếu điện nước cần xóa!!");
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
            Area KV = (Area) cbb_KV.getSelectedItem();
            String GiaDien = txt_GiaDien.getText();
             String GiaNuoc = txt_GiaNuoc.getText();
             String ID = txt_ID.getText();
        if(txt_GiaDien.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Bạn cần phải nhập giá điện");
        }
        
        
        else
        { 
         //call function
        int rowEffected = DNServices.UpdateRecord(Integer.parseInt(ID),KV.getMAKV(),Integer.parseInt(GiaDien),Integer.parseInt(GiaNuoc));
         if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

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
            java.util.logging.Logger.getLogger(frm_DienNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_DienNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_DienNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_DienNuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_DienNuoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<Area> cbb_KV;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_grid;
    private javax.swing.JTextField txt_GiaDien;
    private javax.swing.JTextField txt_GiaNuoc;
    private javax.swing.JTextField txt_ID;
    // End of variables declaration//GEN-END:variables
}