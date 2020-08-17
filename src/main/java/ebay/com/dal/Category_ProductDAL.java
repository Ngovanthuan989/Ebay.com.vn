package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Category_Product;

public class Category_ProductDAL {

    public void insert_category(Category_Product cap) throws SQLException{
        PreparedStatement preparedStatement = null;

        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql = "insert into category(category_name, category_date)values(?,?);";
            preparedStatement =(PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, cap.getCategory_Name());
            preparedStatement.setString(2, cap.getCategory_date());

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


    public void update_category(Category_Product cap ,int category_id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {

            String sql ="update category set category_name=?,category_date=? where category_id ='"+category_id+"'";
            preparedStatement =(PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, cap.getCategory_Name());
            preparedStatement.setString(2,cap.getCategory_date());

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
    public ArrayList<Category_Product> Select_Category_Product()throws SQLException{
         Connection connection = JDBCConnection.getJDBConnection();

         Statement statement = connection.createStatement();

         ArrayList<Category_Product> List =  new ArrayList<>();

         try {
             String sql = "select * from category";

             ResultSet rs =statement.executeQuery(sql);

             while (rs.next()) {
                int category_id = rs.getInt(1);
                String category_name = rs.getString(2);
                String category_date = rs.getString(3);

                List.add(new Category_Product(category_id, category_name, category_date));
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
