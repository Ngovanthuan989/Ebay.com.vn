package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.OptionsDAL;
import ebay.com.persistance.Options;

public class OptionsBL {

    static List<Options> OP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void add_new_options()throws SQLException{

        Options op = new Options();
        OptionsDAL opd = new OptionsDAL();
        System.out.println("Enter Option_Name:");
        String option_name = sc.nextLine();
        op.setTbl_options_name(option_name);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        op.setTbl_options_date(""+year+"-"+(month+1)+"-"+day);

        OP.add(op);
        opd.insert_options(op);


    }

    public static void show_options()throws SQLException{

        OP = new OptionsDAL().Select_Options();
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("options_id","options_name","options_date");

        for (int i = 0; i < OP.size(); i++) {
            CT.addRow(String.valueOf(OP.get(i).getTbl_options_id()),String.valueOf(OP.get(i).getTbl_options_name()),String.valueOf(OP.get(i).getTbl_options_date()));
        }
        CT.print();

    }
}
