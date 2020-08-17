package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Address_Details;

public class Address_DetailsDAL {

    public void insert_address_details(Address_Details AD) throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "insert into address_details(customer_id,address_name)values(?,?)";
            preparedStatement =(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, AD.getCustomer_id());
            preparedStatement.setString(2, AD.getAddress_name());

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

    public void update_address_details(Address_Details AD, int address_details_id) throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "update address_details set customer_id=?,address_name=? where address_id='"+address_details_id+"'";
            preparedStatement =(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, AD.getCustomer_id());
            preparedStatement.setString(2, AD.getAddress_name());
            preparedStatement.executeUpdate();
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

    public ArrayList<Address_Details> select_address_details(int address_customer_id) throws SQLException{

        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Address_Details> List = new ArrayList<>();

        try {
            String sql ="select * from address_details where customer_id ='"+address_customer_id+"' ";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
               int address_id = rs.getInt(1);
               int customer_id = rs.getInt(2);
               String address_name = rs.getString(3);

               List.add(new Address_Details(address_id, customer_id, address_name));
            }
            return List;
        } catch (SQLException ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }

        return null;
    }
}
