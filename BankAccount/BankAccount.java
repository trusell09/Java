public class BankAccount {
    private double checkingBalance = 0;
    private double savingBalance = 0;
    public BankAccount(double account1, double account2){
        this.checkingBalance = account1;
        this.savingBalance = account2;
        Member.setCount();
        Member.setTotal(account1, account2);
    }
    public double getChecking(){
        return this.checkingBalance;
    }
    public double getSaving(){
        return this.savingBalance;
    }
    public void deposit(double value1, double value2){
        this.checkingBalance += value1;
        this.savingBalance += value2;
        Member.setTotal(value1, value2);
    }
    public String withdraw(double value1, double value2){
        if(this.checkingBalance < value1 || this.savingBalance < value2){
            return "No";
        }
        this.checkingBalance -= value1;
        this.savingBalance -= value2;
        return "Done";
    }
    public double totalBal(){
        return this.checkingBalance + this.savingBalance;
    }
}