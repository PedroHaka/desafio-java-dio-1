package bancodigitaldio;

public class ContaCorrente extends Conta{
    
    public ContaCorrente(double value, Cliente client){
        this.agency = super.getAgency();
        this.number = super.getNumber();
        this.type = "Corrente";
        this.balance = value;
        this.client = client;
    }
}
