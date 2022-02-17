package bancodigitaldio;

public class Banco {
    public static void main(String[] args) {


        Cliente Pedro = new Cliente("Pedro Haka", "426.453.808-40");
        Cliente Bruno = new Cliente("Bruno Haka", "123.456.789.10");

        Conta contaPedro = new Conta(2000,Pedro);
        Conta contaBruno = new Conta(5000.99,Bruno);
        
        System.out.println(contaPedro.getNumber());
        System.out.println(contaBruno.getNumber());
        System.out.println(contaPedro.getClient());
        System.out.println(contaBruno.getClient());
    }
}
