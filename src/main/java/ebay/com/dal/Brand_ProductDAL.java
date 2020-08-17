package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Brand_Product;

public class Brand_ProductDAL {

    public void insert_brand_product(Brand_Product bp)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
           String sql = "insert into brand (brand_name,category_id,brand_date) values(?,?,?)";

           preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
           preparedStatement.setString(1, bp.getBrand_name());
           preparedStatement.setInt(2, bp.getCategory_id());
           preparedStatement.setString(3,bp.getBrand_date());

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



    public void update_brand_product(Brand_Product bp, int brand_id)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {

            String sql = "update brand set brand_name =?, category_id =?, brand_date =? where brand_id='"+brand_id+"'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, bp.getBrand_name());
            preparedStatement.setInt(2, bp.getCategory_id());
            preparedStatement.setString(3, bp.getBrand_date());

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


    public ArrayList<Brand_Product> select_brand_product() throws SQLException{

        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Brand_Product> List = new ArrayList<>();
        try {
            String sql = "select * from brand";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int brand_id = rs.getInt(1);
                int category_id = rs.getInt(2);
                String brand_name = rs.getString(3);
                String brand_date = rs.getString(4);

                List.add(new Brand_Product(brand_id, category_id, brand_name, brand_date) );
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
