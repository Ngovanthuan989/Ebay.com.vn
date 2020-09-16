package ebay.com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Bill;

public class BillDAL {

    public ArrayList<Bill>select_bill(int ord_id,int cus_id)throws SQLException{
        Connection connection =JDBCConnection.getJDBConnection();
        Statement statement=connection.createStatement();

        ArrayList<Bill>List = new ArrayList<>();

        try {
            String sql="call select_bill('"+ord_id+"','"+cus_id+"');";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               int order_id = rs.getInt(1);
               int customer_id = rs.getInt(2);
               String customer_name= rs.getString(3);
               String customer_phone = rs.getString(4);
               int product_id = rs.getInt(5);
               String product_name = rs.getString(6);
               double promotion_price = rs.getDouble(7);
               int amount = rs.getInt(8);
               String payment_method = rs.getString(9);
               String address_name = rs.getString(10);
               String order_date = rs.getString(11);
               String shipping_name = rs.getString(12);
               double shipping_price = rs.getDouble(13);
               double total = rs.getDouble(14);
               String order_status = rs.getString(15);

               List.add(new Bill(order_id, customer_id, customer_name, customer_phone, product_id, product_name, promotion_price, amount, payment_method, address_name, order_date, shipping_name, shipping_price, total, order_status));
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
    public ArrayList<Bill>select_bill2(int sup_id)throws SQLException{
        Connection connection =JDBCConnection.getJDBConnection();
        Statement statement=connection.createStatement();

        ArrayList<Bill>List = new ArrayList<>();

        try {
            String sql="call select_bill2("+sup_id+");";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               int order_id = rs.getInt(1);
               int customer_id = rs.getInt(2);
               String customer_name= rs.getString(3);
               String customer_phone = rs.getString(4);
               int product_id = rs.getInt(5);
               String product_name = rs.getString(6);
               double promotion_price = rs.getDouble(7);
               int amount = rs.getInt(8);
               String payment_method = rs.getString(9);
               String address_name = rs.getString(10);
               String order_date = rs.getString(11);
               String shipping_name = rs.getString(12);
               double shipping_price = rs.getDouble(13);
               double total = rs.getDouble(14);
               String order_status = rs.getString(15);

               List.add(new Bill(order_id, customer_id, customer_name, customer_phone, product_id, product_name, promotion_price, amount, payment_method, address_name, order_date, shipping_name, shipping_price, total, order_status));
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
