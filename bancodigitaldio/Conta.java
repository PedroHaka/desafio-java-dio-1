package bancodigitaldio;
import javax.swing.*;

public abstract class Conta implements InterfaceConta{
    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 2201;
    
    protected int number;
    protected int agency;
    protected String type;
    protected double balance;
    protected Cliente client;

    //constructors
    public Conta(){
        this.agency = AGENCIA_PADRAO;
        this.number = SEQUENCIAL++;
        this.balance = 0.00;
    }

    public Conta(double balance, Cliente client){
        this.agency = 141;
        this.number = SEQUENCIAL++;
        this.balance = balance;
        this.client = client;
    }

    //methods
    public int getNumber() {
        return this.number;
    }

    public int getAgency() {
        return this.agency;
    }

    public String getType() {
        return this.type;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cliente getClient() {
        return this.client;
    }

    @Override
    public void deposit(double value) {
        if(value > 0)
            this.balance += value;
        if(value <= 0)
            JOptionPane.showMessageDialog(null, "Insira um valor válido, maior que zero.");
    }

    @Override
    public void withdraw(double value) {
        if(value <= this.balance)
            this.balance -= value;
        if(value > this.balance)
            JOptionPane.showMessageDialog(null, "Quantia excede o saldo total, tente novamente!");

    }

    @Override
    public void transfer(double value, Conta destinationAccount) {
        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    @Override
    public String toString() {
        return "number=" + getNumber() +
            "\nagency=" + getAgency() +
            "\ntype =" + getType() +
            "\nbalance=" + getBalance() +
            "\nclient=" + this.client.getName();
    }

}
