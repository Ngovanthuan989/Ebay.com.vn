package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Address_DetailsDAL;
import ebay.com.persistance.Address_Details;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;

public class Address_DetailsBL {

    static List<Address_Details> ADT = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void add_address_details() throws SQLException{
        Address_Details ad = new Address_Details();
        Address_DetailsDAL adt = new Address_DetailsDAL();

        ad.setCustomer_id(application.id_customer);
        System.out.println("Enter Address_name");
        String address_name = new Validate().checkEmpty();
        ad.setAddress_name(address_name);

        ADT.add(ad);

        adt.insert_address_details(ad);
    }

    public static void update_address_details()throws SQLException{
        Address_Details ad = new Address_Details();
        Address_DetailsDAL adt = new Address_DetailsDAL();
        boolean check = true;
        while (check) {
            System.out.println("Enter Address_id:");
            int address_id = Integer.parseInt(new Validate().checkINT());

            ADT = new Address_DetailsDAL().select_address_details2();
            int kt = 0;

            for (int i = 0; i < ADT.size(); i++) {
                if (ADT.get(i).getAddress_id()==address_id) {
                    kt = 1;

                }
            }
            if (kt == 1) {
                System.out.println("ID Tồn Tại");
                check = false;
                ad.setAddress_id(address_id);
                ad.setCustomer_id(application.id_customer);
                System.out.println("Enter Address_Name:");
                String address_name = new Validate().checkEmpty();
                ad.setAddress_name(address_name);


                ADT.add(ad);

                adt.update_address_details(ad, address_id);

            } else {
                System.out.println("ID không tồn tại!Mời Nhập Lại");
                check = true;

            }

        }


    }

    public static void show_address_details()throws SQLException{

        ADT = new Address_DetailsDAL().select_address_details(application.id_customer);

        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Address_ID","Customer_ID","Address_Name:");

        for (int i = 0; i < ADT.size(); i++) {

            CT.addRow(String.valueOf(ADT.get(i).getAddress_id()),String.valueOf(ADT.get(i).getCustomer_id()),String.valueOf(ADT.get(i).getAddress_name()));
        }
        CT.print();
    }

}
