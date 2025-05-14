package zadanie_4;

public class BankAccount {

    private Long accountNumber;
    private Double balance;
    private String ownerName;


    public BankAccount(String ownerName, Double balance, Long accountNumber) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }



    public String getOwnerName() {
        return ownerName;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }


    public void deposit(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
    }
    public void withdraw(Double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        }
        this.balance -= amount;
    }

    public void displayBalance() {
        System.out.println(this.balance);
    }

}
