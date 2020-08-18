package ebay.com.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Product_Options_Details;

public class Product_Options_DetailsDAL {
    public ArrayList<Product_Options_Details>select_options_details(int supplier_id)throws SQLException{
        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Product_Options_Details> List = new ArrayList<>();
        try {
            String sql = " call select_options_details('"+supplier_id+"');";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_code = rs.getString(2);
                String product_name = rs.getString(3);
                String tbl_options_name = rs.getString(4);
                String options_name = rs.getString(5);

                List.add(new Product_Options_Details(product_id, product_code, product_name, tbl_options_name, options_name));
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
