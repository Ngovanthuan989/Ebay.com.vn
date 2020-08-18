package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Product_Options_DetailsDAL;
import ebay.com.persistance.Product_Options_Details;

public class Product_Options_DetailsBL {
    static List<Product_Options_Details> POD = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void show_options_details()throws SQLException{
        System.out.println("Enter Supplier_ID:");
        int Supplier_ID = Integer.parseInt(sc.nextLine());
        POD = new Product_Options_DetailsDAL().select_options_details(Supplier_ID);

        CommandLineTable CT = new CommandLineTable();

        CT.setShowVerticalLines(true);
        CT.setHeaders("Product_ID","Product_Code","Product_Name","Options","Options_Name");

        for (int i = 0; i < POD.size(); i++) {

            CT.addRow(String.valueOf(POD.get(i).getProduct_id()),String.valueOf(POD.get(i).getProduct_code()),String.valueOf(POD.get(i).getProduct_name()),
            String.valueOf(POD.get(i).getTbl_options_name()),String.valueOf(POD.get(i).getOptions_name()));
        }
        CT.print();
    }
}
