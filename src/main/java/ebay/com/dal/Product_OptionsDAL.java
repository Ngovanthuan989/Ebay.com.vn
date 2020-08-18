package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Product_Options;

public class Product_OptionsDAL {

    public void insert_product_options(Product_Options pro) throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql ="insert into product_options(product_id,tbl_options_id,options_name)values(?,?,?)";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, pro.getProduct_id());
            preparedStatement.setInt(2, pro.getTbl_options_id());
            preparedStatement.setString(3, pro.getOptions_name());

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

    public void update_product_options(Product_Options pro, int options_id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "update product_options set product_id=?,tbl_options_id=?,options_name=? where options_id='"+options_id+"'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, pro.getProduct_id());
            preparedStatement.setInt(2, pro.getTbl_options_id());
            preparedStatement.setString(3, pro.getOptions_name());

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
    // public ArrayList<Product_Options>select_product_options()throws SQLException{
    //     Connection connection = JDBCConnection.getJDBConnection();
    //     Statement statement = connection.createStatement();

    //     ArrayList<Product_Options>List = new ArrayList<>();

    //     try {

    //     } catch (Exception e) {
    //         //TODO: handle exception
    //     }

    // }
}
