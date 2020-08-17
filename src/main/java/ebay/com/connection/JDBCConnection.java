package ebay.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngova
 */
public class JDBCConnection {
    public static Connection getJDBConnection() {
        String url = "jdbc:mysql://localhost:3306/ebay?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn !=null) {
                System.out.println("Connect to the database");
            }else{
                System.out.println("Failed to make connection");
            }
            return conn;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException ex){
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);

        }
          return null;
    }
}
