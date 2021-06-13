/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;

import Entities.Customer;
import Services.CustomerServices;
import Services.SqlConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
 * @author vuhuynh
 */
public class frm_Customer extends javax.swing.JFrame {
    //khai báo customerServices để đển thêm, xóa, sửa cơ sở dữ liệu.
    CustomerServices customerServices = new CustomerServices();
    
    //ArrayList<Customer> dsKH =  new ArrayList<Customer>();
    /**
     * Creates new form frm_Customer
     */
    public frm_Customer() {
        initComponents();
        //load danh sách từ cơ sở dữ liệu lên bảng
        loadGrid();
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
        dgvKH = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_xuatNV = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        dtmNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý Khách Hàng");
        setResizable(false);

        dgvKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Khách Hàng", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgvKH);
        if (dgvKH.getColumnModel().getColumnCount() > 0) {
            dgvKH.getColumnModel().getColumn(0).setResizable(false);
            dgvKH.getColumnModel().getColumn(2).setResizable(false);
            dgvKH.getColumnModel().getColumn(3).setResizable(false);
            dgvKH.getColumnModel().getColumn(4).setResizable(false);
            dgvKH.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnXoa.setText("Xóa Thông Tin");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm Khách Hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa Thông Tin");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btn_home.setText("Trang Chủ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_xuatNV.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btn_xuatNV.setText("Xuất DS Khách Hàng");
        btn_xuatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xuatNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xuatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXoa, btn_home});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên Khách Hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Điện Thoại:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Email:");

        txtMaKH.setEditable(false);
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dtmNgaySinh.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtmNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dtmNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Xử lý sự kiện cho nút thêm
     * @param evt 
     */
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //nếu text field txtTenKH khác rỗng
        if(!txtTenKH.getText().isEmpty()){
            //khai báo biến chứa tên khách hàng
            String tenkh = txtTenKH.getText();
            //khai bao biến chứa ngày sinh khách hàng         
            Date ngaysinh = dtmNgaySinh.getDate();
            //khai bao biến chứa số điện thoại khách hàng
            String sdt  = txtSDT.getText();
            //khai báo biến chứa địa chỉ khách hàng
            String diachi = txtDiaChi.getText();
            //khai báo biến chứa email khách hàng
            String email = txtEmail.getText();
            //khai báo biến để thực thi SQL và xác định thêm thành công hay thất bại
            int rowEffected = customerServices.AddNewRecord(tenkh, ngaysinh, sdt, diachi, email);
            //nếu biến lớn hơn 0 thì thành công
            if(rowEffected > 0 ){
                //hiện thông báo thêm thành công
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                //load lại bảng danh sách khách hàng
                loadGrid();
            }
        }
        else{
            //hiện thông báo nhập lại thông tin
            JOptionPane.showMessageDialog(null, "Xin nhập vào thông tin khách hàng cần thêm!!");
        }
    }//GEN-LAST:event_btnThemActionPerformed
    /**
     * xử lý sự kiện nút sửa
     * @param evt 
     */
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //nếu text field txtMaKH khác rỗng
        if(!txtMaKH.getText().isEmpty()){
            //khai báo biến chứa mã khách hàng
            int makh = Integer.parseInt(txtMaKH.getText());
            //khai báo biến chứa tên khách hàng
            String tenkh = txtTenKH.getText();
            //khai bao biến chứa ngày sinh khách hàng         
            Date ngaysinh = dtmNgaySinh.getDate();
            //khai bao biến chứa số điện thoại khách hàng
            String sdt  = txtSDT.getText();
            //khai báo biến chứa địa chỉ khách hàng
            String diachi = txtDiaChi.getText();
            //khai báo biến chứa email khách hàng
            String email = txtEmail.getText();
            //khai báo biến để thực thi SQL và xác định sửa thành công hay thất bại
            int rowEffected = customerServices.UpdateRecord(makh, tenkh, ngaysinh, sdt, diachi, email);
            //nếu biến lớn hơn 0 thì thành công
            if(rowEffected > 0 ){
                //hiện thông báo sửa thành công
                JOptionPane.showMessageDialog(null, "Thông tin khách hàng đã được thay đổi!");
                //load lại bảng danh sách khách hàng
                loadGrid();
            }
        }
        else{
            //hiện thông báo chọn lại thông tin
            JOptionPane.showMessageDialog(null, "Xin chọn thông tin khách hàng cần sửa!!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    /**
     * xử lý sự kiện cho nút xóa
     * @param evt 
     */
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //nếu text field txtMaKH khác rỗng
        if(!txtMaKH.getText().trim().isEmpty())
        {
            //khai báo biến chứa mã khách hàng
            int makh = Integer.parseInt(txtMaKH.getText());
            // khai báo biến hiện thông báo xác nhận có muốn xóa hay không
            int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // 0=yes, 1=no, 2=cancel
            //nếu xác nhận có 
            if(input == 0)
            {
                //khai báo biến thực thi lệnh SQL và xác nhận xóa thành công hay thất bại
                int rowEffected = customerServices.DeleteRecord(makh);
                //nếu biến lớn hơn 0 thì thành công
                if(rowEffected > 0){
                    //load lại bảng danh sách khách hàng
                    loadGrid();
                    //hiện thông báo xóa thành công
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                }
                else
                //hiện thông báo xóa thất bại
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
        else{
            //hiện thông báo chọn lại thông tin
            JOptionPane.showMessageDialog(null, "Xin chọn thông tin khách hàng cần xóa!!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        this.dispose();
        frm_Index Home = new frm_Index();
        Home.setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_xuatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatNVActionPerformed
        try {
            SqlConnection sqlConn = new SqlConnection();

            Map parameters = new HashMap();

            String workingDir = System.getProperty("user.dir");

            String file = workingDir + "/src/main/java/Report/DSKH.jasper";

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
            java.util.logging.Logger.getLogger(frm_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_xuatNV;
    private javax.swing.JTable dgvKH;
    private com.toedter.calendar.JDateChooser dtmNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
    /**
     * phương thức load bảng danh sách khách hàng từ cơ sở dữ liệu
     */
    private void loadGrid() {
        //khai báo biến lấy model của bảng
        DefaultTableModel model = (DefaultTableModel) dgvKH.getModel();
        //xóa bảng
        model.setRowCount(0);
        //khai báo biến list chứa danh sách tất cả khách hàng từ cơ sở dữ liệu
        ArrayList<Customer> list = customerServices.getAllRecords();
        
        
        //dsKH = list;
        
        //khai báo mảng đối tượng chứa thông tin để mỗi dòng
        Object[] row = new Object[6];
        //vòng lặp chạy từ đầu đến hết danh sách
        for(int i = 0; i< list.size(); i++){
            //vị trí 0 hiện mã khách hàng
            row[0] = list.get(i).getMAKH();
            //vị trí 1 hiện tên khách hàng
            row[1] = list.get(i).getTENKH();
            //vị trí 2 hiện ngày sinh khách hàng
            row[2] = list.get(i).getNGAYSINH();
            //vị trí 3 hiện số điện thoại khách hàng
            row[3] = list.get(i).getSDT();
            //vị trí 4 hiện địa chỉ khách hàng
            row[4] = list.get(i).getDIACHI();
            //vị trí 5 hiện email khách hàng
            row[5] = list.get(i).getEmail();
            //thêm 1 dòng vào bảng
            model.addRow(row);
        }
        //khai báo phương thức chọn trên bảng
        ListSelectionModel listSelectionModel = dgvKH.getSelectionModel();
        //khai báo chọn đơn lẻ
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //xử lý sự kiện chọn
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //xử lý sự kiện thay đổi dòng chọn
                gridSelectedChanged(e);
            }
        });
        
    }
    /**
     * xử lý sự kiện thay đổi dòng chọn
     * @param e 
     */
    public void gridSelectedChanged(ListSelectionEvent e) {
                //String selectedData = null;
                
                //biến chứa mã khách hàng đã chọn
                int selectedID = 0;
                    //Trả về một mảng các số nguyên, mỗi một số nguyên chính là chỉ số của một hàng đang được chọn trong bảng.
                    int[] selectedRows = dgvKH.getSelectedColumns();
                    //Trả về một mảng các số nguyên, mỗi số nguyên là một chỉ số của một cột đang được chọn trong bảng
                    int[] selectedColumns = dgvKH.getSelectedColumns();
                    //Trả về một số nguyên, số nguyên này là chỉ số nhỏ nhất của một hàng trong tập hợp các hàng đang được chọn của bảng.
                    int selectedRow = dgvKH.getSelectedRow();
                    //Trả về một số nguyên là chỉ số nhỏ nhất của một cột trong số các cột đang được chọn của bảng.
                    int selectedColumn = dgvKH.getSelectedColumn();
                    //nếu số dòng được chọn lớn hơn hoặc bằng 0 và nếu số cột chọn lớn hơn hoặc bằng 0
                    if(selectedRow >=0 && selectedColumn >= 0){
                        
                        //selectedData = String.valueOf(dgvKH.getValueAt(selectedRow, selectedColumn));
                        //gán biến bằng dòng và cột đầu tiên được chọn lấy mã khách hàng
                        selectedID = (int) dgvKH.getValueAt(selectedRow, 0);
                        //nếu biến mã khách hàng khác 0
                        if(selectedID !=0){
                            //chạy phương thức hiển thị thông tin dòng được chọn lên các ô textfield qua biến mã khách hàng
                            showDataDetail(selectedID, 
                                    (String)dgvKH.getValueAt(selectedRow, 1), 
                                    (Date) dgvKH.getValueAt(selectedRow, 2), 
                                    (String) dgvKH.getValueAt(selectedRow, 3), 
                                    (String)dgvKH.getValueAt(selectedRow, 4), 
                                    (String)dgvKH.getValueAt(selectedRow, 5));
                        }
                    }
            }
    /**
     * Đây là phương thức hiển thị thông tin dòng được chọn lên các ô textfield
     * @param makh
     * @param tenkh
     * @param ngaysinh
     * @param sdt
     * @param diachi
     * @param email 
     */
    private void showDataDetail(int makh, String tenkh, Date ngaysinh, String sdt, String diachi, String email) {
        //gán mã khách hàng lên textfield
        txtMaKH.setText(""+makh);
        //gán tên khách hàng lên textfield
        txtTenKH.setText(tenkh);
        //gán ngày sinh khách hàng lên textfield
        dtmNgaySinh.setDate(ngaysinh);
        //gán số điện thoại khách hàng lên textfield
        txtSDT.setText(sdt);
        //gán địa chỉ khách hàng lên textfield
        txtDiaChi.setText(diachi);
        //gán email khách hàng lên textfield
        txtEmail.setText(email);
        
    }
}
