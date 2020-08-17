package ebay.com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Admin;

public class AdminDAL {


    public ArrayList<Admin>SelectAdmin(String email,String pass) throws SQLException{

        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Admin> List = new ArrayList<>();
        try {
            String sql ="select * from admindashboard where admin_email='"+email+"' and admin_password='"+pass+"'";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int admin_id = rs.getInt(1);
                String admin_email = rs.getString(2);
                String admin_pass = rs.getString(3);
                String admin_name = rs.getString(4);

                List.add(new Admin(admin_id,admin_email,admin_pass,admin_name));
            }
            return List;
        } catch (SQLException ex) {
            //TODO: handle exception
            ex.printStackTrace();

        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                //TODO: handle exception
            }
        }
        return null;
    }


}
