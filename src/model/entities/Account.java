package model.entities;

import model.exceptions.WithdrawException;

import java.util.InputMismatchException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if (number < 0 || balance < 0 || withdrawLimit < 0){
            throw new InputMismatchException("Unexpected number inputted");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (amount > withdrawLimit){
            throw new WithdrawException("The amount exceeds withdraw limit");
        } else if (amount > balance) {
            throw  new WithdrawException("Not enough balance");
        } else {
            this.balance -= amount;
            System.out.printf("New balance: %.2f%n", balance);
        }
    }

}
