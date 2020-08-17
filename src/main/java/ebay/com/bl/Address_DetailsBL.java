package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Address_DetailsDAL;
import ebay.com.persistance.Address_Details;

public class Address_DetailsBL {

    static List<Address_Details> ADT = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void add_address_details() throws SQLException{
        Address_Details ad = new Address_Details();
        Address_DetailsDAL adt = new Address_DetailsDAL();

        System.out.println("Enter Customer_id:");
        int customer_id = Integer.parseInt(sc.nextLine());
        ad.setCustomer_id(customer_id);
        System.out.println("Enter Address_name");
        String address_name = sc.nextLine();
        ad.setAddress_name(address_name);

        ADT.add(ad);

        adt.insert_address_details(ad);
    }

    public static void update_address_details()throws SQLException{
        Address_Details ad = new Address_Details();
        Address_DetailsDAL adt = new Address_DetailsDAL();

        System.out.println("Enter Address_id:");
        int address_id = Integer.parseInt(sc.nextLine());
        ad.setAddress_id(address_id);
        System.out.println("Enter Customer_id:");
        int customer_id = Integer.parseInt(sc.nextLine());
        ad.setCustomer_id(customer_id);
        System.out.println("Enter Address_Name:");
        String address_name = sc.nextLine();
        ad.setAddress_name(address_name);


        ADT.add(ad);

        adt.update_address_details(ad, address_id);
    }

    public static void show_address_details()throws SQLException{
        System.out.println("Enter Customer_ID:");
        int customer_id = Integer.parseInt(sc.nextLine());

        ADT = new Address_DetailsDAL().select_address_details(customer_id);

        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Address_ID","Customer_ID","Address_Name:");

        for (int i = 0; i < ADT.size(); i++) {

            CT.addRow(String.valueOf(ADT.get(i).getAddress_id()),String.valueOf(ADT.get(i).getCustomer_id()),String.valueOf(ADT.get(i).getAddress_name()));
        }
        CT.print();
    }

}
