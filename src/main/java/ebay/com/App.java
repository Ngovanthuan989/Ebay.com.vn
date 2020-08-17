package ebay.com;

import java.sql.Connection;
import java.sql.SQLException;

import ebay.com.UI.Menu;

import static ebay.com.connection.JDBCConnection.getJDBConnection;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = getJDBConnection();

            if (connection != null) {
                Menu.ShowMenu();
            }
            else{
                System.out.println("Faild Connect");
            }


    }


}
