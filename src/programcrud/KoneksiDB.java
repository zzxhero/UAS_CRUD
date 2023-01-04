/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programcrud;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author irfan
 */
public class KoneksiDB {
    public static Connection setKoneksi(){
        String konString ="jdbc:mysql://localhost:3306/db_testkoneksi";
        Connection koneksi = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Koneksi Gagal");
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        }catch(SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Koneksi Gagal");
        }
        return koneksi;
   }



    public static int execute(String SQL){
        int status  = 0;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        }catch(SQLException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery (String SQL){
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        }catch(SQLException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        return rs;
    }
}