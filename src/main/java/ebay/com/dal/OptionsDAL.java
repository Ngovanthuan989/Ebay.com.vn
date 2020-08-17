package ebay.com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ebay.com.connection.JDBCConnection;
import ebay.com.persistance.Options;

public class OptionsDAL {
    public void insert_options(Options op)throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBConnection();

        try {
            String sql="insert into tbl_options(tbl_options_name,tbl_options_date)values(?,?)";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1, op.getTbl_options_name());
            preparedStatement.setString(2, op.getTbl_options_date());

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

    public ArrayList<Options>Select_Options()throws SQLException{
        Connection connection = JDBCConnection.getJDBConnection();
        Statement statement = connection.createStatement();

        ArrayList<Options> List = new ArrayList<>();
        try {
            String sql ="select * from tbl_options";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int tbl_options_id = rs.getInt(1);
                String tbl_options_name = rs.getString(2);
                String tbl_options_date = rs.getString(3);

                List.add(new Options(tbl_options_id, tbl_options_name, tbl_options_date));
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
