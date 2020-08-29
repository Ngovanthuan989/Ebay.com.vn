package ebay.com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Cart;

public class CartDAL {
   public ArrayList<Cart>select_cart(int cus_id,int ord_id)throws SQLException{
       Connection connection=JDBCConnection.getJDBConnection();
       Statement statement = connection.createStatement();

       ArrayList<Cart>List= new ArrayList<>();

       try {
           String sql="call select_cart('"+cus_id+"','"+ord_id+"');";

           ResultSet rs = statement.executeQuery(sql);

           while (rs.next()) {
              int order_id = rs.getInt(1);
              int product_id = rs.getInt(2);
              String product_code=rs.getString(3);
              String product_name=rs.getString(4);
              Double promotion_price =rs.getDouble(5);
              int amount =rs.getInt(6);
              String unit_price=rs.getString(7);

            List.add(new Cart(order_id, product_id, product_code, product_name, promotion_price, amount, unit_price));

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
