package bancodigitaldio;

public interface InterfaceConta {
    /* Interface methods are always public, 
    so it´s redundant to use the public access modifier */
    /*public*/ void deposit(double value);
    void withdraw(double value);
    void transfer(double value, Conta destinationAccount); 
}
