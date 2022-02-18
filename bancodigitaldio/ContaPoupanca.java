package bancodigitaldio;

public class ContaPoupanca extends Conta{

    double interestRate;
    
    public ContaPoupanca(double value, Cliente client){
        this.agency = super.getAgency();
        this.number = super.getNumber();
        this.type = "Poupança";
        this.interestRate = 0.012;
        this.balance = value;
        this.client = client;
    }

    public String monthlyInterest(double value, double interestRate){
        return String.valueOf(value * interestRate);
    }
}
