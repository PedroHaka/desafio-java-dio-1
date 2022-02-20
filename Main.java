package bancodigitaldio;

import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> lista_Clientes = new ArrayList<>();
        ArrayList<Conta> lista_Contas = new ArrayList<>();

        Banco bancoDIO = new Banco(lista_Clientes,lista_Contas);

        bancoDIO.startApp();
    }
}
