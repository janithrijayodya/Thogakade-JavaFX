package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private DBConnection(){}

    public static DBConnection getInstance(){
        if(instance==null){
            instance=new DBConnection();
        }
        return instance;
    }

    List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList(){
        return customerList;
    }



}
