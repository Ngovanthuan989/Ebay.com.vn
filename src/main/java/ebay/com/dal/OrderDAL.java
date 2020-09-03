package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Order;

public class OrderDAL {

    public void insert_order(Order ord)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection =JDBCConnection.getJDBConnection();

        try {
            String sql="insert into orders(address_id,customer_id,payment_id,shipment_id,customer_notes,order_status,order_date)values(?,?,?,?,?,?,?)";
            preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, ord.getAddress_id());
            preparedStatement.setInt(2, ord.getCustomer_id());
            preparedStatement.setInt(3, ord.getPayment_id());
            preparedStatement.setInt(4, ord.getShipment_id());
            preparedStatement.setString(5, ord.getCustomer_notes());
            preparedStatement.setString(6, ord.getOrder_status());
            preparedStatement.setString(7, ord.getOrder_date());

            preparedStatement.execute();

        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                //TODO: handle exception
            }
        }

    }

    public void update_order(Order ord,int order_id,int customer_id)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection =JDBCConnection.getJDBConnection();

        try {
            String sql="update orders set address_id=?,payment_id=?,shipment_id=?,customer_notes=?,order_status=?,order_date=? where order_id='"+order_id+"' and customer_id='"+customer_id+"' ";
            preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, ord.getAddress_id());
            preparedStatement.setInt(2, ord.getPayment_id());
            preparedStatement.setInt(3, ord.getShipment_id());
            preparedStatement.setString(4, ord.getCustomer_notes());
            preparedStatement.setString(5, ord.getOrder_status());
            preparedStatement.setString(6, ord.getOrder_date());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                //TODO: handle exception
            }
        }

    }

    public ArrayList<Order>select_order(int customers_id)throws SQLException{

        Connection connection =JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Order>List = new ArrayList<>();

        try {
            String sql ="SELECT * FROM ebay.orders where customer_id='"+customers_id+"'order by order_id desc limit 1 ;";
            ResultSet rs =statement.executeQuery(sql);

            while (rs.next()) {
               int order_id=rs.getInt(1);
               int customer_id=rs.getInt(2);
               int address_id=rs.getInt(3);
               int payment_id=rs.getInt(4);
               int shipment_id=rs.getInt(5);
               String customer_notes=rs.getString(6);
               String order_status=rs.getString(7);
               String order_date=rs.getString(8);

               List.add(new Order(order_id, customer_id, address_id, payment_id, shipment_id, customer_notes, order_status, order_date));
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
