/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOM_PROJECT;

/**
 *
 * @author Taru
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
public class Bank implements Serializable {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    Customer getCustomer(int account)
    {
        return customers.get(account);
    }
    ArrayList<Customer> getCustomers(){
        return customers;
    }

    Customer getCustomerByAccountNumber(String accountnumber) {
      Customer customer = null;
     // System.out.println("a");
        for(Customer c : customers){
           if(c.getAccount().getAccountno().equals(accountnumber)){
                customer = c;
                    //  System.out.println("c");
               break;
           }
       }
      //  Customer customer;
       return customer;
    }

    void removeCustomer(Customer customer) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        customers.remove(customer);
    }
    public static double round(double value,int places){
        if(places < 0){
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places,RoundingMode.FLOOR);
        return bd.doubleValue();
    }
}
