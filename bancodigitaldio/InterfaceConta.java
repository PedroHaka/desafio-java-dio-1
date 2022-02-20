package bancodigitaldio;

public interface InterfaceConta {
    /*public*/ void deposit(double value);
    void withdraw(double value);
    void transfer(double value, Conta destinationAccount); 
}
