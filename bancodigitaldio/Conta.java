package bancodigitaldio;

public class Conta {
    private static int SEQUENCIAL = 1;
    
    protected int number;
    protected int agency;
    protected double balance;
    protected Cliente client;

    //constructors
    public Conta(){
        this.agency = 141;
        this.number = SEQUENCIAL++;
        this.balance = 0;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAgency() {
        return this.agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
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

    public void setClient(Cliente client) {
        this.client = client;
    }

}
