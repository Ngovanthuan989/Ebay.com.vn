package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Product;

public class ProductDAL {

    public void insert_product(Product pr)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "insert into product( product_code,product_name, supplier_id,category_id,brand_id,product_price,promotion_price,product_desc,product_amount,product_status,product_date)values(?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, pr.getProduct_code());
            preparedStatement.setString(2, pr.getProduct_name());
            preparedStatement.setInt(3, pr.getSupplier_id());
            preparedStatement.setInt(4, pr.getCategory_id());
            preparedStatement.setInt(5, pr.getBrand_id());
            preparedStatement.setDouble(6, pr.getProduct_price());
            preparedStatement.setDouble(7, pr.getPromotion_price());
            preparedStatement.setString(8, pr.getProduct_desc());
            preparedStatement.setInt(9, pr.getProduct_amount());
            preparedStatement.setString(10, pr.getProduct_status());
            preparedStatement.setString(11, pr.getProduct_date());

            preparedStatement.execute();
        } catch (SQLException ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }finally{
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                //TODO: handle exception
                ex.printStackTrace();
            }
        }
    }

    public void update_product(Product pr,int product_id)throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();
        try {
            String sql = "update product set product_code=?, product_name=?,supplier_id=?,category_id=?,brand_id=?,product_price=?,promotion_price=?,product_desc=?,product_amount=?,product_status=?,product_date=? where product_id='"+product_id+"'";
            preparedStatement =(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, pr.getProduct_code());
            preparedStatement.setString(2, pr.getProduct_name());
            preparedStatement.setInt(3, pr.getSupplier_id());
            preparedStatement.setInt(4, pr.getCategory_id());
            preparedStatement.setInt(5, pr.getBrand_id());
            preparedStatement.setDouble(6, pr.getProduct_price());
            preparedStatement.setDouble(7, pr.getPromotion_price());
            preparedStatement.setString(8, pr.getProduct_desc());
            preparedStatement.setInt(9, pr.getProduct_amount());
            preparedStatement.setString(10, pr.getProduct_status());
            preparedStatement.setString(11, pr.getProduct_date());

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

    public ArrayList<Product> select_product(int supplier_id_product) throws SQLException{
        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement =connection.createStatement();

        ArrayList<Product> List = new ArrayList<>();
        try {
            String sql ="select * from product where supplier_id ='"+supplier_id_product+"'";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int product_id = rs.getInt(1);
                String product_code = rs.getString(2);
                String product_name = rs.getString(3);
                int supplier_id = rs.getInt(4);
                int category_id = rs.getInt(5);
                int brand_id = rs.getInt(6);
                double product_price = rs.getDouble(7);
                double promotion_price = rs.getDouble(8);
                String product_desc = rs.getString(9);
                int product_amount = rs.getInt(10);
                String product_status = rs.getString(11);
                String product_date = rs.getString(12);

                List.add(new Product(product_id,product_code, product_name, supplier_id, category_id, brand_id, product_price, promotion_price, product_desc, product_amount, product_status, product_date));
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
