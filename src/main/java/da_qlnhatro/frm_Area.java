/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;

import Entities.*;
import Services.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phan Tuan
 */
public class frm_Area extends javax.swing.JFrame {
 
    UserAccServices UserServices = new UserAccServices(); 
    AreaServices KVServices = new AreaServices(); 
    
    ArrayList<UserAcc> DSUSER = new ArrayList<UserAcc>(); 
    ArrayList<Area> DSKV = new ArrayList<Area>();    
    
    Area selectedKV = null;
    
    //Lưu Role đăng nhập
    int saveRole =0;
    //Lưu tên đăng nhập
    String saveName;
    
     private int MaKV = 0;
    /**
     * Creates new form frm_Area
     */
    public frm_Area() {
        initComponents();
        loadMaNV();
        showDataList();
        txt_MaKV.setEnabled(false);
        this.setTitle("HỆ THỐNG QUẢN LÝ NHÀ TRỌ/QUẢN LÝ KHU VỰC");
    }

    /**
     * Phương thức lấy role ở form chính
     * @param stt 
     */
    void getRole(int role){
        saveRole = role;
    }
    /**
     * Phương thức lấy tên ở form chính
     * @param str 
     */
    void getNames(String str){
        saveName = str;
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
        jPanel1 = new javax.swing.JPanel();
        cbb_MaNV = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        txt_MaKV = new javax.swing.JTextField();
        txt_TenKV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_del = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab_grid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tab_grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khu Vực", "Tên Khu Vực", "Mã Nhân Viên", "Địa Chỉ"
            }
        ));
        jScrollPane1.setViewportView(tab_grid);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbb_MaNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã Khu Vực");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nhân Viên");

        txt_DiaChi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txt_MaKV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txt_TenKV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_TenKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TenKVActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên Khu Vực");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_MaKV, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_TenKV, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_MaKV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_TenKV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbb_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_del.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_del.setText("Xóa");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_update.setText("Cập Nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_refresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_refresh.setText("Làm Mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_home.setText("Trang Chủ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_del, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btn_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_del)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ KHU VỰC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(388, 388, 388))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
  * Load combobox Nhân viên
  */
    private void loadMaNV(){
        cbb_MaNV.removeAllItems(); // Xóa đi các item đang có
        DSUSER = UserServices.getAllRecords();// select các giá trị của Nhân viên
        
        //Lấy các đối tượng nhân viên trong danh sách nhân viên
        for(UserAcc User : DSUSER){
            cbb_MaNV.addItem(User);            
        }  
        // Thực hiện
        cbb_MaNV.setRenderer(new DefaultListCellRenderer() { 
            @Override
            // Trả về giá trị đã chỉ định
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                // Xác định đúng đối tượng UserAccount( Nhân viên
                if(value instanceof UserAcc){
                    UserAcc User = (UserAcc) value;                   
                    setText( String.valueOf( User.getTENNV())); // Lấy tên NV
                   
                }
                return this;
            }
        } );
    }
    
     
      // Các phương thức tìm kiếm 
      
      /**
       * Phương thức tìm một User với mã NV và danh sách User
       * @param MaNV - Mã nhân viên
       * @param User - Danh sách User
       * @return 
       */
       public UserAcc findUser(int MaNV, ArrayList<UserAcc> User) {
           // Duyệt qua từng đối tượng trong danh sách User
        for (UserAcc item : User) {
            //Tìm kiếm mã nhân viên
              if (item.getMaNV() == MaNV) {
                  return item;
              }
          }
          return null;
      }
       /**
        * Phương thức tìm một KV với mã Khu vực và danh sách khu vực
        * @param MaKV - Mã khu vực
        * @param DSKV - Danh sách khu vực
        * @return 
        */
        public Area findKV(int MaKV, ArrayList<Area> DSKV) {
        // Duyệt qua từng đối tượng trong danh sách khu vực
        for (Area item : DSKV) {
            // Tìm kiếm mã khu vực
              if (item.getMAKV()== MaKV) {
                  return item;
              }
          }
          return null;
      }
    
    
    /**
     * Phương thức để show danh sách data ở table(grid view)
     */
     private void showDataList(){
        // khai báo model default
        DefaultTableModel model = (DefaultTableModel)this.tab_grid.getModel(); 
        // xóa tất cả hàng trong table
        model.setRowCount(0);
                
        //Tạo list chứa các thông tin của khu vực 
        ArrayList<Area> list = KVServices.getAllRecords();
        //gán list cho danh sách khu vực
        DSKV = list; 
        //khai báo mảng đối tượng
        Object[] row = new Object[6];
        //vòng lặp chạy từ đầu đến hết list lấy ra các giá trị truyền vào mảng và lưu vào model
        for(int i = 0; i < list.size(); i++){            
            row[0] = list.get(i).getMAKV();
            row[1] = list.get(i).getTENKV();
            row[2] = list.get(i).getMANV();
            row[3] = list.get(i).getDIACHIKV();               
            model.addRow(row);
        }
        //khai báo phương thức chọn trên bảng
        ListSelectionModel cellSelectionModel = tab_grid.getSelectionModel();
        //Chế độ chọn đơn
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Dang ky event click tren list       
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //goi đến sự kiện thay đổi chọn
                gridSelectedChanged(e);
            }
          });
    }
     /**
      * Sự kiện thay đổi khi click vào đối tượng đơn table
      */
      public void gridSelectedChanged(ListSelectionEvent e) {
       // Khai báo biến
       String selectedData = null; 
       int selectedID = 0; 
       
//       int[] selectedRows = tab_grid.getSelectedRows();
//       int[] selectedColumns = tab_grid.getSelectedColumns();
        
       //Chọn dòng trong bảng
       int selectedRow = tab_grid.getSelectedRow();
       //Chọn cột trong bảng
       int selectedColumn = tab_grid.getSelectedColumn();
       
       //nếu số dòng được chọn lớn hơn hoặc bằng 0 và nếu số cột được chọn lớn hơn hoặc bằng 0
       if(selectedRow >=0 && selectedColumn >=0){
           
       //    selectedData = String.valueOf(tab_grid.getValueAt(selectedRow, selectedColumn));
       //Gán selectedID bằng hàng được chọn và cột đầu tiên 
        selectedID = (int) tab_grid.getValueAt(selectedRow, 0); // phần tử số 0 sẽ là ID
        //Gán biến selectedKV bằng đối tượng khu vực được chọn 
        selectedKV= findKV(selectedID,DSKV); 
        System.out.println("Selected: " + selectedData + " , value: " + selectedID);
            //Nếu đối tượng chọn phát sinh thay đổi
            if(selectedID != 0){
            //Gọi đến showDataDetail để set các giá trị text và combobox
            showDataDetail(selectedID,
                    (String) tab_grid.getValueAt(selectedRow, 1),
                    (int) tab_grid.getValueAt(selectedRow, 2),
                    (String) tab_grid.getValueAt(selectedRow, 3));                    
               }       
       }
      }
      /**
       * Phương thứ dùng để set các giá trị text vào combobox của form
       * Truyền vào tham số
       * @param MaKV - Mã khu vực
       * @param TenKV - Tên khu vực
       * @param MaNV - Mã nhân viên
       * @param DiaChi  - Địa chỉ
       */
      private void showDataDetail(int MaKV,String TenKV,int MaNV, String DiaChi){
          
        txt_MaKV.setText(""+ MaKV);        
        txt_TenKV.setText(TenKV);
          if( selectedKV != null)
          {
              cbb_MaNV.setSelectedItem(findUser(selectedKV.getMANV(), DSUSER));
          }
      }
     
    
    
 
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        //Khai báo biến
        String TenKV = txt_TenKV.getText(); 
        String DiaChi = txt_DiaChi.getText(); 
        UserAcc UserID = (UserAcc)cbb_MaNV.getSelectedItem();
        //Kiểm tra tên khu vực có rỗng ko
        if(TenKV.equals("") )
        {
           JOptionPane.showMessageDialog(null, "Ban can phai nhap TEN KV");
        }
        else
        {
           //Gọi đến đến Câu lệnh truy vấn của khu vực(Services)
           int rowEffected = KVServices.AddNewRecord(UserID.getMaNV(),TenKV,DiaChi);
           
           if(rowEffected > 0){
              
                JOptionPane.showMessageDialog(null, "Tao moi thanh cong!");
                showDataList();// Reload lại datalist
            }            
            else
                JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
        }
      clear();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
          //Khai báo biến
           int MaKV = Integer.valueOf(txt_MaKV.getText());
           String TenKV = txt_TenKV.getText(); 
           String DiaChi = txt_DiaChi.getText(); 
          UserAcc UserID = (UserAcc)cbb_MaNV.getSelectedItem();;
          
        if(txt_TenKV.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null, "Ban can phai nhap Ten KV");
        }
        else
        {
         // Gọi đến hàm câu lệnh update của khu vực
        int rowEffected = KVServices.UpdateRecord(MaKV,UserID.getMaNV(),TenKV,DiaChi);
        //KT điều kiện    
        if(rowEffected > 0)
            {
              //  showUserAccounts();
                JOptionPane.showMessageDialog(null, "Cap nhat thanh cong!");
                showDataList(); //Reload lại data list
            }            
            else
                JOptionPane.showMessageDialog(null, "Cap nhat thất bại");
        }
       clear();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
       //Đặt tên biến
        int MaKV = Integer.valueOf(txt_MaKV.getText()); 
       // Tạo ra thông báo Yes/No Question
        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Delete data? =" +input);
        
        // Nếu có lựa chọn thì tiếp tục
        if(!txt_MaKV.getText().equals("") ){
        if(input == 0)
        {
         
            int rowEffected = KVServices.DeleteRecord(MaKV);
            if(rowEffected > 0){
                showDataList();//Reload lại datalist
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            }
            else
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }   
      else
              JOptionPane.showMessageDialog(null, "Ban can phai chon khu vuc de xoa"); 
 
        clear();
    }//GEN-LAST:event_btn_delActionPerformed
void clear()
{
        txt_MaKV.setText("");
        txt_DiaChi.setText("");
        txt_TenKV.setText("");
}
    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
       clear();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void txt_TenKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TenKVActionPerformed
      
        
       
        
    }//GEN-LAST:event_txt_TenKVActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       this.dispose();
       frm_Index Home = new frm_Index();
       Home.setVisible(true);
       if(saveRole==1)
       {
           Home.setRoleName("Admin");  
       }
       else
       {
           Home.setRoleName("User");     
       }
       Home.setTenUser(saveName);
    }//GEN-LAST:event_btn_homeActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Area().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<UserAcc> cbb_MaNV;
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
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_MaKV;
    private javax.swing.JTextField txt_TenKV;
    // End of variables declaration//GEN-END:variables
}
