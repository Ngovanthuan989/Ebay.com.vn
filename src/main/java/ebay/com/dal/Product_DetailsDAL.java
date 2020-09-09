package ebay.com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Product_Details;

public class Product_DetailsDAL {

    public ArrayList<Product_Details>select_productID2(int pro_id)throws SQLException{
        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Product_Details>List = new ArrayList<>();

        try {
            String sql ="call select_product_details('"+pro_id+"')";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               int product_id=rs.getInt(1);
               String product_code =rs.getString(2);
               String product_name =rs.getString(3);
               String category_name=rs.getString(4);
               String brand_name=rs.getString(5);
               double product_price=rs.getDouble(6);
               double promotion_price=rs.getDouble(7);
               String product_desc=rs.getString(8);
               int product_amount =rs.getInt(9);
               String product_status =rs.getString(10);


               List.add(new Product_Details(product_id, product_code, product_name, category_name, brand_name, product_price, promotion_price, product_desc, product_amount, product_status));
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
                ex.printStackTrace();
            }
        }
        return null;

   }
}
