/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da_qlnhatro;

import Entities.*;
import Services.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
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
 * @author PhanTuan, vuhuynh
 */
public class frm_Bill extends javax.swing.JFrame {
    RoomServices roomServices = new RoomServices();
    RoomTypeServices roomTypeServices = new RoomTypeServices();
    AreaServices areaServices = new AreaServices();
    ArrayList<Room> dsRoom = new ArrayList<Room>();
    ArrayList<Area> dsArea = new ArrayList<Area>();
    
    BillServices BServices = new BillServices();
    ArrayList<Bill> dsBill = new ArrayList<Bill>();
    
    Bill selectedBill = null;
    
    //Lưu Role đăng nhập
    int saveRole =0;
    //Lưu tên đăng nhập
    String saveName;
    /**
     * Creates new form frm_Bill
     */
    public frm_Bill() {
        initComponents();
        LoadArea();
        LoadRoom(0);
        showDataList();
        addItemNam();
        this.setTitle("HỆ THỐNG QUẢN LÝ NHÀ TRỌ/QUẢN LÝ HÓA ĐƠN");
        txt_ThanhTienDien.setText("0");
        txt_ThanhTienNuoc.setText("0");
        txt_Tongtien.setText("0");
        txtDonGia.setText("0");
    }
    /**
     * Truyền năm vào combobox năm
     */
    void addItemNam()
    {
        int Max = 2100;
        for (int i = 1900; i <= Max; i++) {
            cbb_Nam.addItem(String.valueOf(i));

        }
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
    
    
    // Các phương thức tìm kiếm
            // Tìm kiếm mã hóa đơn 
            public Bill findBill(int MaHD, ArrayList<Bill> DSBills) {
                for (Bill item : DSBills) {
                    if (item.getMAHOADON()== MaHD) {
                        return item;
                    }
                }
                return null;
            }
            // Tìm kiếm mã phòng 
            public Room findRoom(int MaPhong, ArrayList<Room> DSRoom) {
                for (Room item : DSRoom) {
                    if (item.getMAPHONG()== MaPhong) {
                        return item;
                    }
                }
                return null;
            }
            // Tìm kiếm mã khu vực
            public Area findKV(int MaKV, ArrayList<Area> DSKV) {
                for (Area item : DSKV) {
                    if (item.getMAKV()== MaKV) {
                        return item;
                    }
                }
                return null;
            }
            private RoomType findRoomType(int maloai, ArrayList<RoomType> dsRoomType){
                for(RoomType item : dsRoomType){
                    if(item.getMALOAI() == maloai){
                        return item;
                    }
                }
                return null;
            }
   
            

            
  /**
     * Hàm để show danh sách data ở table(grid view)
     */
   private void showDataList(){
        //Khai báo defaul model
        DefaultTableModel model = (DefaultTableModel)this.tab_grid.getModel(); 
        //Xóa các hàng 
        model.setRowCount(0); 
        // Khởi tạo list truyền vào các giá trị của Bill
        ArrayList<Bill> list = BServices.getAllRecords();
        //Truyền list lại cho dsBill
        dsBill = list;
               
        Object[] row = new Object[10]; // Khai báo mảng
        
        //Gán các item tương đương cho table
        for(int i = 0; i < list.size(); i++){            
            row[0] = list.get(i).getMAHOADON();
            row[1] = list.get(i).getMAKV();
            row[2] = list.get(i).getMAPHONG();
            row[3] = list.get(i).getSOKWDIEN();
            row[4] = list.get(i).getSOKWNUOC();
            row[5] = list.get(i).getTIENDIEN();
            row[6] = list.get(i).getTIENNUOC();
            row[7] = list.get(i).getTHANG();
            row[8] = list.get(i).getNAM();
            row[9] = list.get(i).getTONGTIEN();
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
    
   /**
    * 
    * Method thay đổi giá trị table khi nhấn vào
    */
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
           
           selectedBill= findBill(selectedID,dsBill);
           
           System.out.println("Selected: " + selectedData + " , value: " + selectedID);
               if(selectedID != 0){
               showDataDetail(selectedID,
                                    (int)tab_grid.getValueAt(selectedRow, 1), 
                                    (int) tab_grid.getValueAt(selectedRow, 2), 
                                    (int) tab_grid.getValueAt(selectedRow, 3), 
                                    (int)tab_grid.getValueAt(selectedRow, 4), 
                                    (int)tab_grid.getValueAt(selectedRow, 5),
                                    (int)tab_grid.getValueAt(selectedRow, 6),
                                    (int)tab_grid.getValueAt(selectedRow, 7),
                                    (int)tab_grid.getValueAt(selectedRow, 8),
                                    (int)tab_grid.getValueAt(selectedRow, 9));
                                  
                   
               }       
       }
    }
      /**
       * Method thay đổi giá trị theo đối tượng ở table
       * @param MAHOADON
       * @param MAKV
       * @param MAPHONG
       * @param SOKWDIEN
       * @param SOKWNUOC
       * @param TIENDIEN
       * @param TIENNUOC
       * @param THANG
       * @param NAM 
       */
      
       private void showDataDetail(int MAHOADON, int MAKV, int MAPHONG, int SOKWDIEN, int SOKWNUOC, int TIENDIEN, int TIENNUOC, int THANG, int NAM,int TONGTIEN){
     
        txt_MaHD.setText(""+ MAHOADON);
        txt_KWDien.setText(String.valueOf(SOKWDIEN));
        txt_KhoiNuoc.setText(String.valueOf(SOKWNUOC));
        txt_ThanhTienDien.setText(String.valueOf(TIENDIEN));
        txt_ThanhTienNuoc.setText(String.valueOf(TIENNUOC)); 
        txt_Tongtien.setText(String.valueOf(TONGTIEN)); 
        if(selectedBill != null){
            cbxKhuVuc.setSelectedItem(findKV(selectedBill.getMAKV(), dsArea));
            cbxPhong.setSelectedItem(findRoom(selectedBill.getMAPHONG(), dsRoom));
            
       
    }
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
        jPanel2 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxPhong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ThanhTienDien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxKhuVuc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_MaHD = new javax.swing.JTextField();
        txt_KWDien = new javax.swing.JTextField();
        txt_ThanhTienNuoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_KhoiNuoc = new javax.swing.JTextField();
        cbb_month = new javax.swing.JComboBox<>();
        cbb_Nam = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Tongtien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(397, 397, 397))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tab_grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Số Hóa Đơn", "Khu Vực", "Phòng", "Số KW Điện", "Số Khối Nước", "Thành tiền Điện", "Thành Tiền Nước", "Tháng", "Năm", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tab_grid);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_del.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_del.setText("Xóa");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_update.setText("Sửa");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_reload.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_reload.setText("Làm mới");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        btn_home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_home.setText("Trang Chủ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_report.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_report.setText("Báo cáo");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_report, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add)
                .addGap(18, 18, 18)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_del)
                .addGap(18, 18, 18)
                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_add, btn_del, btn_home, btn_reload, btn_report, btn_update});

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Thành Tiền:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số Khối Nước");

        cbxPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã Hóa Đơn");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Thành Tiền:");

        txt_ThanhTienDien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ThanhTienDien.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số KW Điện");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Năm");

        cbxKhuVuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Phòng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tháng");

        txt_MaHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_MaHD.setEnabled(false);

        txt_KWDien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_KWDien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_KWDienFocusLost(evt);
            }
        });
        txt_KWDien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KWDienActionPerformed(evt);
            }
        });
        txt_KWDien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_KWDienKeyPressed(evt);
            }
        });

        txt_ThanhTienNuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ThanhTienNuoc.setEnabled(false);
        txt_ThanhTienNuoc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_ThanhTienNuocPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Khu Vực");

        txt_KhoiNuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_KhoiNuoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_KhoiNuocFocusLost(evt);
            }
        });
        txt_KhoiNuoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_KhoiNuocKeyPressed(evt);
            }
        });

        cbb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        cbb_month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbb_monthMouseClicked(evt);
            }
        });

        cbb_Nam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbb_NamMouseClicked(evt);
            }
        });
        cbb_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_NamActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tiền Phòng");

        txtDonGia.setEditable(false);
        txtDonGia.setBackground(new java.awt.Color(255, 255, 255));
        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDonGia.setEnabled(false);
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tổng tiền");

        txt_Tongtien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Tongtien.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(30, 30, 30)
                                        .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxKhuVuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_KWDien, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                .addComponent(txt_KhoiNuoc))
                                            .addComponent(cbb_month, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(63, 63, 63)
                                                .addComponent(cbb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txt_ThanhTienDien, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txt_ThanhTienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(txtDonGia)
                                    .addComponent(txt_Tongtien))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_KWDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_KhoiNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ThanhTienDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ThanhTienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbb_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_Tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxKhuVuc, txt_MaHD});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxPhong, txtDonGia, txt_KWDien, txt_KhoiNuoc, txt_ThanhTienDien, txt_ThanhTienNuoc, txt_Tongtien});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel3, jLabel5, jLabel6, jLabel7, jLabel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CÁC ACTION
    private void txt_KWDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KWDienActionPerformed
   

    
    
     
      
    }//GEN-LAST:event_txt_KWDienActionPerformed
      
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
      
        //Khai báo biến
        String KWD = txt_KWDien.getText();
        String KWN = txt_KhoiNuoc.getText();
        Area KV = (Area) cbxKhuVuc.getSelectedItem();
        Room Phong = (Room) cbxPhong.getSelectedItem();
        int Nam =  Integer.valueOf((String)cbb_Nam.getSelectedItem());
        int Thang =  Integer.valueOf((String)cbb_month.getSelectedItem());
        String TongTien = txt_Tongtien.getText();
        String TTD = txt_ThanhTienDien.getText();
        String TTN = txt_ThanhTienNuoc.getText();
        
        if(KWD.equals("")|| KWN.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Bạn cần phải nhập số điện và số nước");
        }
       
        else
        {
             int rowEffected = BServices.AddNewRecord(KV.getMAKV(),Phong.getMAPHONG(),Integer.parseInt(KWD),Integer.parseInt(KWN),Integer.parseInt(TTD),Integer.parseInt(TTN),Thang,Nam,Integer.parseInt(TongTien));
            if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Tao moi thanh cong!");
             showDataList();
            }            
            else
                JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
           } 
        clear();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
          int MaHD = Integer.valueOf(txt_MaHD.getText()); 
          int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",
            
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          System.out.println("Delete data? =" +input);
      
            if(!txt_MaHD.getText().equals("") ){
                if(input == 0)
                {

                    int rowEffected = BServices.DeleteRecord(MaHD);
                    if(rowEffected > 0){
                        showDataList();
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            }   
            else
                    JOptionPane.showMessageDialog(null, "Bạn cần phải chọn hóa đơn để xóa"); 
            clear();
    }//GEN-LAST:event_btn_delActionPerformed

    void clear()
    {
        txt_KWDien.setText("");
        txt_KhoiNuoc.setText("");
        txt_MaHD.setText("");
        txt_ThanhTienDien.setText("0");
        txt_ThanhTienNuoc.setText("0");
        txt_Tongtien.setText("0");
        txtDonGia.setText("0");
    }
    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
       clear();
    }//GEN-LAST:event_btn_reloadActionPerformed

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

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        try {
            SqlConnection sqlConn = new SqlConnection();              
            
            Map parameters = new HashMap(); // Tạo thành cặp key/value
            
            String workingDir = System.getProperty("user.dir"); // lấy đường dẫn gốc
 
            String file = workingDir + "/src/main/java/Report/HoaDon.jasper"; 

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
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        //Khai báo biến
        String TongTien = txt_Tongtien.getText();
        String MaHD = txt_MaHD.getText();
        String KWD = txt_KWDien.getText();
        String KWN = txt_KhoiNuoc.getText();
        Area KV = (Area) cbxKhuVuc.getSelectedItem();
        Room Phong = (Room) cbxPhong.getSelectedItem();
        int Nam =  Integer.valueOf((String)cbb_Nam.getSelectedItem());
        int Thang =  Integer.valueOf((String)cbb_month.getSelectedItem());

        String TTD = txt_ThanhTienDien.getText();
        String TTN = txt_ThanhTienNuoc.getText();
        
        if(KWD.equals("")|| KWN.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Bạn cần phải nhập số điện và số nước");
        }
       
        else
        {
             int rowEffected = BServices.UpdateRecord(Integer.parseInt(MaHD),KV.getMAKV(),Phong.getMAPHONG(),Integer.parseInt(KWD),Integer.parseInt(KWN),Integer.parseInt(TTD),Integer.parseInt(TTN),Thang,Nam,Integer.parseInt(TongTien));
      
            if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Cập nhật thất bại. Vui lòng kiểm tra lại!");
        }
        clear();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
       
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void txt_ThanhTienNuocPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_ThanhTienNuocPropertyChange
       

    }//GEN-LAST:event_txt_ThanhTienNuocPropertyChange

    private void cbb_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_NamActionPerformed

    }//GEN-LAST:event_cbb_NamActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    
    void updateTT()
    {
     int X = Integer.parseInt(txt_ThanhTienDien.getText());
     int Y = Integer.parseInt(txt_ThanhTienNuoc.getText());
     int Z = Integer.parseInt(txtDonGia.getText());
     txt_Tongtien.setText(String.valueOf(X+Y+Z));
    }
    
    private void cbb_NamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_NamMouseClicked
    updateTT();
    }//GEN-LAST:event_cbb_NamMouseClicked

    private void cbb_monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbb_monthMouseClicked
     updateTT();
    }//GEN-LAST:event_cbb_monthMouseClicked

    private void txt_KhoiNuocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KhoiNuocKeyPressed
     updateTT();
    }//GEN-LAST:event_txt_KhoiNuocKeyPressed

    private void txt_KWDienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KWDienKeyPressed

    }//GEN-LAST:event_txt_KWDienKeyPressed

    private void txt_KWDienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_KWDienFocusLost
       try {
      int X = Integer.parseInt(txt_KWDien.getText());
      int T = X*3000;
      txt_ThanhTienDien.setText(String.valueOf(T));
      txt_KhoiNuoc.requestFocus();
    } catch (NumberFormatException e) {
  
        JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
        txt_KWDien.setText("");
    }
    }//GEN-LAST:event_txt_KWDienFocusLost

    private void txt_KhoiNuocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_KhoiNuocFocusLost
         try {
        int X = Integer.parseInt(txt_KhoiNuoc.getText());
        int T = X*2000;
        txt_ThanhTienNuoc.setText(String.valueOf(T));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
        txt_KhoiNuoc.setText("");
    }
    }//GEN-LAST:event_txt_KhoiNuocFocusLost

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
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new frm_Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_Nam;
    private javax.swing.JComboBox<String> cbb_month;
    private javax.swing.JComboBox<Area> cbxKhuVuc;
    private javax.swing.JComboBox<Room> cbxPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_grid;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txt_KWDien;
    private javax.swing.JTextField txt_KhoiNuoc;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_ThanhTienDien;
    private javax.swing.JTextField txt_ThanhTienNuoc;
    private javax.swing.JTextField txt_Tongtien;
    // End of variables declaration//GEN-END:variables

    private void LoadArea() {
        cbxKhuVuc.removeAllItems();
        dsArea = areaServices.getAllRecords();
        for(Area item : dsArea){
            cbxKhuVuc.addItem(item);
        }        
        cbxKhuVuc.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);               
                if(value instanceof Area){
                    Area item = (Area) value;
                    //hiển thị tên khu vực
                    setText(item.getTENKV());
                }
                return this;
            }
            
        });
        cbxKhuVuc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Area area = (Area) cbxKhuVuc.getSelectedItem();
                    int makv = area.getMAKV();
                    System.out.println(makv);
                    LoadRoom(makv);
                    
                }
            }
        });

  
    }
    private void LoadRoom(int makv){
        cbxPhong.removeAllItems();
        if(makv != 0){
         //   dsRoom = null;
            dsRoom = roomServices.getRecordByArea(makv);
        }
        else{
         //   dsRoom = null;
            dsRoom = roomServices.getAllRecords();
        }
        
        for (Room item : dsRoom) {
            cbxPhong.addItem(item);
        }
        cbxPhong.setRenderer(new DefaultListCellRenderer(){
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);               
            if(value instanceof Room){
                Room item = (Room) value;
                setText(String.valueOf(item.getMAPHONG()));
                }
            return this;
            }

        });
        //get đơn giá
        cbxPhong.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                   Room room = (Room) cbxPhong.getSelectedItem();
                   int maloai = room.getMALOAI();
                   ArrayList<RoomType> dsRoomType = roomTypeServices.getAllRecords();
                   int dongia = findRoomType(maloai, dsRoomType).getDONGIA();
                   txtDonGia.setText(dongia+"");
                }
            }
        });
    }
}
