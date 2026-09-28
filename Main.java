class Bank{
    class main{}
    private String bankName;
    private String bankAddress;
    Bank(String bankName,String bankAddress){
        this.bankName=bankName;
        this.bankAddress=bankAddress;
    }
    void printBankDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Bank Address: " + bankAddress);
    }
}
class BankAccount extends Bank {

    // Data members
    
     private String accountHolderName;//Encapsulation: Making the data members private to restrict direct access from outside the class.
     private long accountNumber;//Encapsulation: Making the data members private to restrict direct access from outside the class.
     private double balance;//Encapsulation: Making the data members private to restrict direct access from outside the class.
     
BankAccount(String bankName,String address,String accountHolderName, long accountNumber, double balance) {
    super(bankName,address);
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;

}
    // Method to deposit money
    void deposit(double amount) { 
        balance = balance + amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }
    void deposit(int amount,String desc){ //method overloading - compile time polymorphism
        balance=balance+amount;
        System.out.println("₹" + amount + " deposited successfully.");
        System.out.println("Description :" + desc);
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    double getBalance(){
        return balance;
    }

    // Method to display account details
    void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String bankName,String address,String accountHolderName, long accountNumber, double balance, double interestRate) {
        super(bankName,address,accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    void calculateInterest() {
        double interest = (getBalance() * interestRate) / 100;
        System.out.println("Interest earned: ₹" + interest);
    }

    @Override 
    void displayAccountDetails() { //method overriding - runtime polymorphism
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    // Getter for balance (to access private member of superclass)
}
class CurrentAccount extends BankAccount {

   private double interestRate;

    CurrentAccount(String bankName,String address,String accountHolderName, long accountNumber, double balance, double interestRate) {
        super(bankName,address,accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    void calculateInterest() {
        double interest = (getBalance() * interestRate) / 100;
        System.out.println("Interest earned: ₹" + interest);
    }
     @Override 
    void displayAccountDetails() { //method overriding - runtime polymorphism
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    }
   public class Main{ 
    public static void main(String[] args) {

        // Creating first BankAccount object
        BankAccount account1 = new BankAccount("SBi","GhZ",
        "Abhishek",10001,5000);

        // account1.accountHolderName = "Abhishek";
        // account1.accountNumber = 10001;
        // account1.balance = 5000;

        // Creating second BankAccount object
        BankAccount account2 = new BankAccount("SBi","GhZ",
        "Rahul",10002,3000);

        // account2.accountHolderName = "Rahul";
        // account2.accountNumber = 10002;
        // account2.balance = 3000;

        // Depositing money
        System.out.println("Account 1:");
        account1.deposit(2000);

        System.out.println("\nAccount 2:");
        account2.deposit(1500);

        // Withdrawing money
        System.out.println("\nAccount 1:");
        account1.withdraw(4000);

        System.out.println("\nAccount 2:");
        account2.withdraw(5006);

        // Display final account details
        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }}
//Polymorphism : ability to express data in multiple forms . 
//Compile time polymorphism- method overloading.
//Runtime polymorphism - method overriding..
