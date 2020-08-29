package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Order_Details;

public class Order_DetailsDAL {

    public void insert_order_details(Order_Details odd)throws SQLException{
        PreparedStatement preparedStatement =null;
        Connection connection=JDBCConnection.getJDBConnection();

        try {
            String sql="insert into order_details(product_id,order_id,amount)values(?,?,?)";
            preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, odd.getProducts_id());
            preparedStatement.setInt(2, odd.getOrder_id());
            preparedStatement.setInt(3, odd.getAmount());

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
    public void update_order_details(Order_Details odd,int order_id)throws SQLException{
        PreparedStatement preparedStatement =null;
        Connection connection=JDBCConnection.getJDBConnection();

        try {
            String sql="update order_details set product_id=?,amount=? where order_id='"+order_id+"'";
            preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1, odd.getProducts_id());
            preparedStatement.setInt(2, odd.getOrder_id());
            preparedStatement.setInt(3, odd.getAmount());

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
    public ArrayList<Order_Details>select_order_details(int orders_id)throws SQLException{
        Connection connection =JDBCConnection.getJDBConnection();
        Statement statement =connection.createStatement();

        try {
            String sql="select*from order_details where order_id='"+orders_id+"'";
            ResultSet rs =statement.executeQuery(sql);

            ArrayList<Order_Details>List = new ArrayList<>();
            while (rs.next()) {
                int product_id=rs.getInt(1);
                int order_id = rs.getInt(2);
                int amount = rs.getInt(3);

                List.add(new Order_Details(product_id, order_id, amount));

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
