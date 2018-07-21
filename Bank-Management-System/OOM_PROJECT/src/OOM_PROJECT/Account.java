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
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.io.Serializable;
public abstract class Account implements Serializable{
     public float balance;
    private String account_no;
    private double transactionFee;
     StringBuilder warnings = new StringBuilder();
        
   
    Account(float balance)
    {
        
        Random rand = new Random();
        this.balance = balance;
        account_no =" "+rand.nextInt(1000)+rand.nextInt(1000);
       // this.account_no = account_no;
    }
    public void Withdraw(float amount,Component c)
    {
        if(amount + transactionFee > balance){
                 JOptionPane.showMessageDialog(c,"Insufficient Funds","Deposit Warnings",JOptionPane.WARNING_MESSAGE);
                 return ;
        }
        balance = balance - amount-5;
    }
    public void Deposit(float amount)
    {
        balance = balance + amount;
    }
     public float BalanceEnquiry()
     {
         return balance;
     }
     public String getAccountno()
     {
         return account_no;
     }
     abstract public void updateBalance(float months);
     abstract public String getAccounttype();

    public double getTransactionFee() {
         //double transactionFee = 0;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return transactionFee;
    }
    public void setTransactionFee(double fee){
        this.transactionFee = fee;
    }
}
 class Savings extends Account {
    private float InterestRate;
    private String accountType = "Savings";
    Savings(float balance)
    {
        super(balance);
        this.InterestRate = 5;
        this.setTransactionFee(5);
    }
   public void updateBalance(float months)
    {
        float b = balance;
           b = b + (b*InterestRate*months)/100;
         super.balance = b;
    }
    public String getAccounttype()
    {
        return "Savings";
    }
    public String toString(){
        return "Account Type: " + accountType + "Account\n" +
                "Account Number: " + this.getAccountno() + "\n" +
                "Balance: " + this.BalanceEnquiry();
                
    }
}
class Checking extends Account{
    private float InterestRate;
    private static String accountType = "Checking";
    Checking(float balance)
    {
        super(balance);
        this.setTransactionFee(5);
        InterestRate = 4;
    }
    public void updateBalance(float months)
    {
        float b = balance;
           b = b + (b*InterestRate*months)/100;
         super.balance = b;
    }
    public String getAccounttype()
    {
        return "Checking";
    }
    public String toString(){
        return  "Account Type: " + accountType + "Account\n" +
                "Account Number: " + this.getAccountno() + "\n" +
                "Balance: " + this.BalanceEnquiry();
                
    }
}
class Loan extends Account{
    private float principalAmount;
    private float InterestRate;
    private float timePeriod;
    private String accountType = "Loan";
    Loan(float balance){
        super(balance);
        this.setTransactionFee(5);
    }
   public  void updateBalance(float months)
    {
        
    }
   public String getAccounttype()
   {
       return "Loan";
   }
   public String toString(){
        return "Account Type: " + accountType + "Account\n" +
                "Account Number: " + this.getAccountno() + "\n" +
                "Balance: " + this.BalanceEnquiry();
                
    }
}
class Customer implements Serializable{
    private String firstname,lastname;
    private Account account;
    private String mobile;
    Customer(String firstname,String lastname,Account account,String mobile)
    {
        this.account = account;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
    }
    public String getFirstName()
    {
        return firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public Account getAccount()
    {
        return account;
    }

    String getMobile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return mobile;
    }
}