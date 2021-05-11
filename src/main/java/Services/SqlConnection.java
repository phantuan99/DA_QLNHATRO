/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */
public class SqlConnection {
    
   //Thực hiện kết nối đến database
    public Connection getConnection() throws ClassNotFoundException{
            Connection conn = null;
        try{
                //Connect SQL Server DB voi username, password
                //String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress:1433;user=sa;password=secret";

                //Connect SQL Server DB voi integratedSecurity
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=QL_NHATRO;user=sa;password=123;";

          //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);        				

            return conn;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Loi" , JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
	// Kiểm tra kết nối
    public void testConnection() throws ClassNotFoundException{
        Connection conn = null;
        try {       
        // Test connection			
                conn = new SqlConnection().getConnection();

                if (conn != null) {
                        DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                        System.out.println("Test SQL Server connection: ");
                        System.out.println("Driver name: " + dm.getDriverName());
                        System.out.println("Driver version: " + dm.getDriverVersion());
                        System.out.println("Product name: " + dm.getDatabaseProductName());
                        System.out.println("Product version: " + dm.getDatabaseProductVersion());				
                }
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                try {				
                        if (conn != null && !conn.isClosed())
                                try {conn.close();} catch (Exception ex) {ex.printStackTrace();}
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }
    }
        
    public void checkConnectDB() throws ClassNotFoundException{
            if (getConnection() != null)
                    System.out.println("Kết nối database thành công");
            else
                    System.out.println("Kết nối database không thành công");
    }

}
