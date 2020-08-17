package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Suppiler;

public class SuppilerDAL {

    public void insert_suppiler(Suppiler SP) throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "insert into suppiler(suppiler_name, suppiler_address, suppiler_email,suppiler_pass,suppiler_phone,suppiler_status)values(?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, SP.getSuppiler_name());
            preparedStatement.setString(2, SP.getSuppiler_address());
            preparedStatement.setString(3, SP.getSuppiler_email());
            preparedStatement.setString(4, SP.getSuppiler_pass());
            preparedStatement.setString(5, SP.getSuppiler_phone());
            preparedStatement.setString(6, SP.getSuppiler_status());

            preparedStatement.execute();
        } catch (SQLException ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }finally{
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                //TODO: handle exception
            }
        }
    }

    public ArrayList<Suppiler> SelectSuppiler(String email, String pass) throws SQLException{
        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList <Suppiler> List = new ArrayList<>();

        try {
            String sql = "Select * from suppiler where suppiler_email = '"+email+"' and suppiler_pass = '"+pass+"'";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
               int suppiler_id = rs.getInt(1);
               String suppiler_name = rs.getString(2);
               String suppiler_address = rs.getString(3);
               String suppiler_email = rs.getString(4);
               String suppiler_pass = rs.getString(5);
               String suppiler_phone = rs.getString(6);
               String suppiler_status = rs.getString(7);

               List.add(new Suppiler(suppiler_id, suppiler_name, suppiler_address, suppiler_email, suppiler_pass, suppiler_phone, suppiler_status));
            }

            return List;
        } catch (SQLException ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }

        return null;
    }
}
