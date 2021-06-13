/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;



import Entities.UserAcc;
import Services.SqlConnection;
import Services.UserAccServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author PhanTuan
 */
public class frm_UserAccount extends javax.swing.JFrame {

    /**
     * Creates new form frm_UserAccount
     */
    
   UserAccServices UserServices = new UserAccServices(); // Gọi Services NV đặt tên = NVServices
   
    
    ArrayList<UserAcc> DSUser = new ArrayList<UserAcc>(); // Tạo mảng NV đặt tên = DSNV

   
   UserAcc selectedUser = null;// Khai báo lựa chọn NV là rong
   private int MaNV = 0;// Khai báo Mã NV là 0
    public frm_UserAccount() {
        initComponents();
        this.setTitle("HỆ THỐNG QUẢN LÝ NHÀ TRỌ/QUẢN LÝ USER");
        showDataList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tab_grid = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_del = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        btn_xuatNV = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chk_role = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        txt_TenNV = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_Phone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        J_NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab_grid.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tab_grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Mật khẩu", "Quyền", "Họ Tên Nhân Viên", "Số Điện Thoại", "Email", "Địa Chỉ", "Ngày Sinh"
            }
        ));
        jScrollPane1.setViewportView(tab_grid);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_del.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_del.setText("Xóa");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_home.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_home.setText("Trang chủ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_reload.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_reload.setText("Làm mới");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        btn_xuatNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_xuatNV.setText("Xuất DS Nhân Viên");
        btn_xuatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xuatNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_xuatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_add, btn_del, btn_home, btn_reload, btn_update});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Mã Nhân Viên");

        chk_role.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        chk_role.setText("Toàn quyền");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Mật Khẩu");

        txt_MaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_MaNV.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Quyền");

        txt_Password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_TenNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Tên Nhân Viên");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Số Điện Thoại");

        txt_Phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PhoneActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Ngày sinh");

        J_NgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Email");

        txt_Email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Địa chỉ");

        txt_DiaChi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setText("THÔNG TIN CÁ NHÂN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(J_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chk_role)
                                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(267, 267, 267))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {J_NgaySinh, txt_DiaChi, txt_Email, txt_MaNV, txt_Password, txt_Phone, txt_TenNV});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_role)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19))
                    .addComponent(J_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {J_NgaySinh, txt_DiaChi, txt_Email, txt_MaNV, txt_Password, txt_Phone, txt_TenNV});

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN NHÂN SỰ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static boolean valEmail(String input)
{
    String emailRegex ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailat.matcher(input);
    return matcher.find();
}
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
    
       String Password = txt_Password.getText();
       String TenNV = txt_TenNV.getText();
       int SDT = Integer.valueOf(txt_Phone.getText());
       String Email = txt_Email.getText();
       String DiaChi = txt_DiaChi.getText();
       Date NgaySinh = J_NgaySinh.getDate();
       int Role;
      

       
       
       if(chk_role.isSelected() == true)
       {
           Role = 1;
       }
       else
           Role = 0;
     if(txt_Password.getText().equals("") ){
           JOptionPane.showMessageDialog(null, "Ban can phai nhap MK");
       }
     else if(valEmail(Email)==false){
         JOptionPane.showMessageDialog(null, "Mời bạn nhập lại email");
     }
     
     
     
     else 
        { 
         //call function
        int rowEffected = UserServices.AddNewRecord(Password,Role,TenNV,SDT,Email,DiaChi,NgaySinh);
         if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Tao moi thanh cong!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
        }
      
 
    
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        String Password = txt_Password.getText();
        int MaNV = Integer.valueOf( txt_MaNV.getText());
        String TenNV = txt_TenNV.getText();
        int SDT = Integer.valueOf(txt_Phone.getText());
        String Email = txt_Email.getText();
        String DiaChi = txt_DiaChi.getText();
        Date NgaySinh = J_NgaySinh.getDate();
         int Role;
       if(chk_role.isSelected() == true)
       {
           Role = 1;
       }
       else
           Role = 0;
     if(txt_Password.getText().equals("") ){
           JOptionPane.showMessageDialog(null, "Ban can phai nhap MK");
       }
      else if(valEmail(Email)==false){
         JOptionPane.showMessageDialog(null, "Mời bạn nhập lại email");
     }
       else
        { 
         //call function
        int rowEffected = UserServices.UpdateRecord(MaNV,Password,Role,TenNV,SDT,Email,DiaChi,NgaySinh);
         if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Cap nhat thanh cong!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Cap nhat thất bại");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
    
        int MaNV = Integer.valueOf( txt_MaNV.getText());
        
        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Delete data? =" +input);

      if(!txt_MaNV.getText().equals("") ){
        if(input == 0)
        {
         
            int rowEffected = UserServices.DeleteRecord(Integer.valueOf(MaNV));
            if(rowEffected > 0){
                showDataList();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            }
            else
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }   
      else
              JOptionPane.showMessageDialog(null, "Bạn cần phải chọn User để xóa"); 
      txt_MaNV.setText("");
      txt_Password.setText("");
    }//GEN-LAST:event_btn_delActionPerformed

    private void txt_PhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PhoneActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
       txt_MaNV.setText("");
       txt_Email.setText("");
       txt_DiaChi.setText("");
       txt_Password.setText("");
       txt_Phone.setText("");
       txt_TenNV.setText("");
       
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       frm_Index home = new frm_Index();
               home.setVisible(true);
               this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_xuatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatNVActionPerformed
        try {
            SqlConnection sqlConn = new SqlConnection();              
 
            Map parameters = new HashMap();
            
            String workingDir = System.getProperty("user.dir");
 
            String file = workingDir + "/src/main/java/Report/DSNV.jasper"; 

            System.out.println("Current working directory : " + file);

            
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, sqlConn.getConnection());            
            
            //JasperViewer.viewReport(jasperPrint);
                                    
            JFrame frame = new JFrame("Report");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new JRViewer(jasperPrint));
            frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
            frame.pack();
            frame.setVisible(true);
                        
      

            System.out.print("Successful!");
                
        } catch (Exception e) {
                System.out.print(e.toString());
        }
    }//GEN-LAST:event_btn_xuatNVActionPerformed

    /**
     * Dùng để show data ra gridview
     */
     private void showDataList(){
        
        DefaultTableModel model = (DefaultTableModel)this.tab_grid.getModel(); 
        model.setRowCount(0);
                
        //load data
        ArrayList<UserAcc> list = UserServices.getAllRecords();
        
        DSUser = list;
               
        Object[] row = new Object[8];
        
        for(int i = 0; i < list.size(); i++){            
            row[0] = list.get(i).getMaNV();
            row[1] = list.get(i).getPassword();
            row[2] = list.get(i).getRole();
            row[3] = list.get(i).getTENNV();
            row[4] = list.get(i).getSDT();
            row[5] = list.get(i).getEMAIL();
            row[6] = list.get(i).getDIACHI();
            row[7] = list.get(i).getNgaySinh();
       
            model.addRow(row);
        }
        
        ListSelectionModel cellSelectionModel = tab_grid.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Dang ky event click tren danh sach        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //goi ham show data chi tiet
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
        //   selectedUser= findNV(selectedID,DSUser);
           MaNV = selectedID;
           System.out.println("Selected: " + selectedData + " , value: " + selectedID);
               if(selectedID != 0){
               showDataDetail(selectedID,
                                    (String)tab_grid.getValueAt(selectedRow, 1), 
                                    (int) tab_grid.getValueAt(selectedRow, 2), 
                                    (String) tab_grid.getValueAt(selectedRow, 3), 
                                    (int)tab_grid.getValueAt(selectedRow, 4), 
                                    (String)tab_grid.getValueAt(selectedRow, 5),
                                    (String)tab_grid.getValueAt(selectedRow, 6),
                                    (Date)tab_grid.getValueAt(selectedRow, 7));
                   
               }       
       }
    }
       private void showDataDetail(int MaNV,String Password, int Role,String TENNV,int SDT,String EMAIL, String DIACHI,Date NgaySinh){
     
        txt_MaNV.setText(""+ MaNV);        
        txt_Password.setText(Password);
        txt_TenNV.setText(TENNV);
        txt_Phone.setText(String.valueOf(SDT));
        txt_Email.setText(EMAIL);
        txt_DiaChi.setText(DIACHI);
        J_NgaySinh.setDate(NgaySinh);
        if(Role == 1)
            {
              chk_role.setSelected(true);
            }
            else
               chk_role.setSelected(false);
        
  
    }
    
//       public UserAcc findNV(int MaNV, ArrayList<UserAcc> DSUser) {
//      for (UserAcc item : DSUser) {
//          if (item.getMaNV()== this.MaNV) {
//              return item;
//          }
//      }
//      return null;
//    }
    
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
            java.util.logging.Logger.getLogger(frm_UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_UserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser J_NgaySinh;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_xuatNV;
    private javax.swing.JCheckBox chk_role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_grid;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_Phone;
    private javax.swing.JTextField txt_TenNV;
    // End of variables declaration//GEN-END:variables
}
