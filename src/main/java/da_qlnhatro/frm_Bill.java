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
    AreaServices areaServices = new AreaServices();
    ArrayList<Room> dsRoom = new ArrayList<Room>();
    ArrayList<Area> dsArea = new ArrayList<Area>();
    
    BillServices BServices = new BillServices();
    ArrayList<Bill> dsBill = new ArrayList<Bill>();
    
    Bill selectedBill = null;
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
            
   
            
    
    
            
            
   private void showDataList(){
     
        DefaultTableModel model = (DefaultTableModel)this.tab_grid.getModel(); 
        model.setRowCount(0); 
               
        ArrayList<Bill> list = BServices.getAllRecords();
        
        dsBill = list;//dùng cho việc chọn hợp đồng
               
        Object[] row = new Object[9]; // Khai báo mảng
        
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
                                    (int)tab_grid.getValueAt(selectedRow, 8));
                                  
                   
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
      
       private void showDataDetail(int MAHOADON, int MAKV, int MAPHONG, int SOKWDIEN, int SOKWNUOC, int TIENDIEN, int TIENNUOC, int THANG, int NAM){
     
        txt_MaHD.setText(""+ MAHOADON);
        txt_KWDien.setText(String.valueOf(SOKWDIEN));
        txt_KhoiNuoc.setText(String.valueOf(SOKWNUOC));
        txt_ThanhTienDien.setText(String.valueOf(TIENDIEN));
        txt_ThanhTienNuoc.setText(String.valueOf(TIENNUOC)); 
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
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Số Hóa Đơn", "Khu Vực", "Phòng", "Số KW Điện", "Số Khối Nước", "Thành tiền Điện", "Thành Tiền Nước", "Tháng", "Năm"
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
                .addGap(29, 29, 29)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_del)
                .addGap(18, 18, 18)
                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_add, btn_del, btn_home, btn_reload, btn_report, btn_update});

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

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
        txt_KWDien.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_KWDienInputMethodTextChanged(evt);
            }
        });
        txt_KWDien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KWDienActionPerformed(evt);
            }
        });

        txt_ThanhTienNuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ThanhTienNuoc.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Khu Vực");

        txt_KhoiNuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_KhoiNuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KhoiNuocActionPerformed(evt);
            }
        });

        cbb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxKhuVuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_KWDien, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbb_month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_KhoiNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_ThanhTienDien, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_ThanhTienNuoc)
                                                    .addComponent(cbb_Nam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txt_ThanhTienDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_KWDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_ThanhTienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_KhoiNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cbb_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxKhuVuc, txt_MaHD});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxPhong, txt_KWDien, txt_KhoiNuoc, txt_ThanhTienDien, txt_ThanhTienNuoc});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel3, jLabel5, jLabel6, jLabel7, jLabel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CÁC ACTION
    private void txt_KWDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KWDienActionPerformed
      int X = Integer.parseInt(txt_KWDien.getText());
      int T = X*3000;
      txt_ThanhTienDien.setText(String.valueOf(T));
      txt_KhoiNuoc.requestFocus();
    }//GEN-LAST:event_txt_KWDienActionPerformed
      
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
      
        //Khai báo biến
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
             int rowEffected = BServices.AddNewRecord(KV.getMAKV(),Phong.getMAPHONG(),Integer.parseInt(KWD),Integer.parseInt(KWN),Integer.parseInt(TTD),Integer.parseInt(TTN),Thang,Nam);
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
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        txt_KWDien.setText("");
        txt_KhoiNuoc.setText("");
        txt_MaHD.setText("");
        txt_ThanhTienDien.setText("");
        txt_ThanhTienNuoc.setText("");
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        this.dispose();
        frm_Index Home = new frm_Index();
        Home.setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
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
    }//GEN-LAST:event_btn_reportActionPerformed

    private void txt_KWDienInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_KWDienInputMethodTextChanged
    
    }//GEN-LAST:event_txt_KWDienInputMethodTextChanged

    private void txt_KhoiNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KhoiNuocActionPerformed
      int X = Integer.parseInt(txt_KhoiNuoc.getText());
      int T = X*2000;
      txt_ThanhTienNuoc.setText(String.valueOf(T));
    }//GEN-LAST:event_txt_KhoiNuocActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        //Khai báo biến
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
             int rowEffected = BServices.UpdateRecord(Integer.parseInt(MaHD),KV.getMAKV(),Phong.getMAPHONG(),Integer.parseInt(KWD),Integer.parseInt(KWN),Integer.parseInt(TTD),Integer.parseInt(TTN),Thang,Nam);
      
            if(rowEffected > 0){
           //  showUserAccounts();
             JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
             showDataList();
         }            
         else
             JOptionPane.showMessageDialog(null, "Cập nhật thất bại. Vui lòng kiểm tra lại!");
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
    private javax.swing.JTextField txt_KWDien;
    private javax.swing.JTextField txt_KhoiNuoc;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_ThanhTienDien;
    private javax.swing.JTextField txt_ThanhTienNuoc;
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
    }
}
