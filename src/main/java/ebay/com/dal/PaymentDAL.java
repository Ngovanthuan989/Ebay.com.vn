package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Payment;

public class PaymentDAL {
   public void insert_payment(Payment pay)throws SQLException{
       PreparedStatement preparedStatement =null;
       Connection connection =JDBCConnection.getJDBConnection();


       try {
           String sql="insert into payment(payment_method,payment_status)values(?,?);";
           preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
           preparedStatement.setString(1, pay.getPayment_method());
           preparedStatement.setString(2, pay.getPayment_status());
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


   public void update_payment(Payment pay,int payment_id) throws SQLException{
       PreparedStatement preparedStatement = null;
       Connection connection=JDBCConnection.getJDBConnection();

       try {
           String sql="update payment set payment_method=?,payment_status=? where payment_id='"+payment_id+"'";
           preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
           preparedStatement.setString(1, pay.getPayment_method());
           preparedStatement.setString(2, pay.getPayment_status());
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
   public ArrayList<Payment>select_payment()throws SQLException{
       Connection connection =JDBCConnection.getJDBConnection();
       Statement statement = connection.createStatement();

       ArrayList<Payment>List=new ArrayList<>();

       try {
           String sql="select*from payment where payment_status='Hiển Thị'";
           ResultSet rs = statement.executeQuery(sql);
           while (rs.next()) {
             int payment_id=rs.getInt(1);
             String payment_method=rs.getString(2);
             String payment_status=rs.getString(3);

             List.add(new Payment(payment_id, payment_method, payment_status));
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

