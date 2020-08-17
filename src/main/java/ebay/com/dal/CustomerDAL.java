package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Customer;


/**
 * CustomerDAL
 */
public class CustomerDAL {

  public void insert_customer(Customer cm) throws SQLException{
      PreparedStatement preparedStatement = null;

      Connection connection =JDBCConnection.getJDBConnection();

      try {
          String sql ="insert into customer (customer_name,customer_address,customer_email,customer_pass,customer_phone)values(?,?,?,?,?)";
          preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
          preparedStatement.setString(1, cm.getCustomer_name());
          preparedStatement.setString(2, cm.getCustomer_address());
          preparedStatement.setString(3, cm.getCustomer_email());
          preparedStatement.setString(4, cm.getCustomer_pass());
          preparedStatement.setString(5, cm.getCustomer_phone());
          preparedStatement.execute();
      } catch (SQLException e) {
          //TODO: handle exception
          e.printStackTrace();
      }
      finally{
          try {
              preparedStatement.close();
          } catch (SQLException e) {
              //TODO: handle exception
          }
      }
  }

  public ArrayList<Customer> SelectCustomer(String email ,String pass) throws SQLException{
      Connection connection = JDBCConnection.getJDBConnection();
      Statement statement = connection.createStatement();
      ArrayList<Customer> List = new ArrayList<>();

      try {
          String sql = "select * from customer where customer_email ='"+email+"' and customer_pass = '"+pass+"';";

          ResultSet rs = statement.executeQuery(sql);

          while (rs.next()) {
            int customer_ID = rs.getInt(1);
            String customer_Name = rs.getString(2);
            String address = rs.getString(3);
            String mail = rs.getString(4);
            String password = rs.getString(5);
            String phone_Number = rs.getString(6);

            List.add(new Customer(customer_ID, customer_Name, address, mail, password, phone_Number));
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
