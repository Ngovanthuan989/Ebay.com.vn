package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Shippingment;

public class ShippingmentDAL {

    public void insert_shipment(Shippingment sh)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "insert into shipments(shipping_name,shipping_date)values(?,?)";
            preparedStatement =(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, sh.getShipment_name());
            preparedStatement.setString(2, sh.getShipment_date());

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


    public void update_shipment(Shippingment sh, int shipment_id)throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql ="update shipments set shipping_name=?,shipping_date=?where shipment_id='"+shipment_id+"'";
            preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, sh.getShipment_name());
            preparedStatement.setString(2, sh.getShipment_date());

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


    public ArrayList<Shippingment>select_shippingment()throws SQLException{

        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Shippingment> List = new ArrayList<>();

        try {

            String sql ="select * from shipments";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int shipping_id = rs.getInt(1);
                String shipping_name = rs.getString(2);
                String shipping_date = rs.getString(3);

                List.add(new Shippingment(shipping_id, shipping_name, shipping_date));

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
