package bancodigitaldio;

import java.util.ArrayList;
import javax.swing.*;

public class Banco {
    // atributes
    private ArrayList<Cliente> lista_Clientes;
    private ArrayList<Conta> lista_Contas;

    // constructors
    public Banco() {
    }

    public Banco(ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
        this.lista_Clientes = clientes;
        this.lista_Contas = contas;
    }

    // methods
    public void startApp() {
        String main_menu = "";
        try {// try 1
            do {
                main_menu = JOptionPane.showInputDialog("Bem Vindo ao Banco Digital da DIO!"
                        + "\n\nSelecione uma opção digitando o número correspondente:"
                        + "\n-------->>"
                        + "\n1 -> Criar Cliente"
                        + "\n2 -> Criar Conta"
                        + "\n3 -> Gerenciar Contas"
                        + "\n4 -> Sair do Sistema");

                switch (main_menu) {
                    case "1":
                        createClientMenu();
                        break;
                    case "2":
                        createAccountMenu();
                        break;
                    case "3":
                        manageAccountMenu();
                        break;
                    case "4":
                        endApp();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção inválida!! Verifique os campos digitados!!");
                        break;

                }
            } while (main_menu != "4");
        } catch (Exception erro_root) {// try 1
            JOptionPane.showMessageDialog(null, "\nSessão encerrada!"
                    + "\nObrigado e volte sempre!");
            System.exit(0);
        }
    }
    //option "1"
    private void createClientMenu() {
        try {// try 1.1
            String name_client_1 = JOptionPane.showInputDialog("Digite"
                    + " o nome do cliente: ");
            String cpf_client_1 = JOptionPane.showInputDialog("Digite"
                    + " o cpf do cliente: ");
            lista_Clientes.add(new Cliente(name_client_1, cpf_client_1));
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n" +
                    lista_Clientes.toString());
        } catch (Exception erro_1_1) {// try 1
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    //option "2"
    private void createAccountMenu() {
        try {// try 1.2
            String submenu_2 = JOptionPane.showInputDialog(
                    "Selecione uma opção digitando o número correspondente"
                            + "\nao tipo de conta que deseja criar:"
                            + "\n-------->>"
                            + "\n1 -> Conta Corrente"
                            + "\n2 -> Conta Poupança"
                            + "\n3 -> Retornar ao menu principal");
            switch (submenu_2) {
                case "1":
                    createCurrentAcc();
                    break;
                case "2":
                    createSavingsAcc();
                    break;
                default:
                    break;
            }
        } catch (Exception erro_1_2) {
            JOptionPane.showMessageDialog(null, "Opção Inválida! Utilize apenas "
                    + "os números indicados: [1, 2 ou 3]");
        }
    }

    private void createCurrentAcc() {
        try {// try 1.2.1
            Double balance_1 = Double.parseDouble(JOptionPane.showInputDialog("Digite"
                    + " o saldo da conta: "));
            String cpfclient_2 = JOptionPane.showInputDialog("Digite"
                    + " o cpf do cliente: ");
            for (Cliente client2 : lista_Clientes) {
                if (client2.getCpf() == cpfclient_2)
                    lista_Contas.add(new ContaCorrente(balance_1, client2));
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n" +
                        "Cliente: " + client2.getName() + "\nTipo de Conta: Corrente"
                        + "\nID da conta: " + String.format("%d", lista_Contas.size()));
            }
        } catch (Exception erro_1_2_1) {
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    private void createSavingsAcc() {
        try {// try 1.2.2
            Double balance_1 = Double.parseDouble(JOptionPane.showInputDialog("Digite"
                    + " o saldo da conta: "));
            String cpfclient_2 = JOptionPane.showInputDialog("Digite"
                    + " o cpf do cliente: ");
            for (Cliente client : lista_Clientes) {
                if (client.getCpf() == cpfclient_2)
                    lista_Contas.add(new ContaPoupanca(balance_1, client));
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n" +
                        "Cliente: " + client.getName() + "\nTipo de Conta: Poupança"
                        + "\nID da conta: " + String.format("%d", lista_Contas.size()));
            }
        } catch (Exception erro_1_2_2) {
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    //option "3"
    private void manageAccountMenu() {
        try {// try 1_3
            String submenu_3 = JOptionPane.showInputDialog(
                    "Selecione uma opção digitando o número correspondente"
                            + "\nao tipo de operação que deseja realizar:"
                            + "\n-------->>"
                            + "\n1 -> Depósito"
                            + "\n2 -> Saque"
                            + "\n3 -> Transferência"
                            + "\n4 -> Retornar ao menu principal");
            switch (submenu_3) {
                case "1":
                    depositMenu();
                    break;
                case "2":
                    withdrawMenu();
                    break;
                case "3":
                    transferMenu();
                    break;
                default:
                    break;
            }
        } catch (Exception erro_1_3) {
            JOptionPane.showMessageDialog(null, "Opção Inválida! Utilize apenas "
                    + "os números indicados: [1, 2, 3 ou 4]");
        }
    }

    private void depositMenu() {
        try {// try 1_3_1
            String cpf_client_3 = JOptionPane.showInputDialog(
                    "Digite o cpf do titular da conta para depósito:");
            double valueDeposit = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Digite o valor que deseja depositar:"
                                    + "\n(Separar decimais com ponto. Ex: 19.99)"));
            for (Conta conta : lista_Contas) {
                if (conta.client.getCpf() == cpf_client_3) {
                    conta.deposit(valueDeposit);
                    JOptionPane.showMessageDialog(null,
                            "Operação realizada com sucesso!"
                                    + "\nSaldo da conta: " + conta.getBalance());
                }
            }
        } catch (Exception erro_1_3_1) {
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    private void withdrawMenu() {
        try {// try 1_3_2
            String cpf_client_4 = JOptionPane.showInputDialog(
                    "Digite o cpf do titular da conta para saque:");
            double valueWithdraw = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Digite o valor que deseja sacar:"
                                    + "\n(Separar decimais com ponto. Ex: 19.99)"));
            for (Conta conta : lista_Contas) {
                if (conta.client.getCpf() == cpf_client_4) {
                    conta.withdraw(valueWithdraw);
                    JOptionPane.showMessageDialog(null,
                            "Operação realizada com sucesso!"
                                    + "\nSaldo da conta: " + conta.getBalance());
                }
            }
        } catch (Exception erro_1_3_2) {
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    private void transferMenu() {
        try {// try 1_3_3
            String cpf_client_5 = JOptionPane.showInputDialog(
                    "Digite o cpf do titular da conta para sacar:");
            double valueTransfer = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            "Digite o valor que deseja transferir:"
                                    + "\n(Separar decimais com ponto. Ex: 19.99)"));
            String cpf_client_6 = JOptionPane.showInputDialog(
                    "Digite o cpf do titular da conta para transferir:");
            for (Conta contaWithdraw : lista_Contas) {
                if (contaWithdraw.client.getCpf() == cpf_client_5) {
                    for (Conta contaTransfer : lista_Contas) {
                        if (contaTransfer.client.getCpf() == cpf_client_6)
                            contaWithdraw.transfer(valueTransfer, contaTransfer);
                        JOptionPane.showMessageDialog(null,
                                "Operação realizada com sucesso!"
                                        + "\nSaldo da conta de origem: " + contaWithdraw.getBalance()
                                        + "\nSaldo da conta de destino: " + contaTransfer.getBalance());
                    }
                }
            }
        } catch (Exception erro_1_3_1) {
            JOptionPane.showMessageDialog(null,
                    "Certifique a integridade dos dados!");
        }
    }

    //option "4"
    private void endApp() {
        JOptionPane.showMessageDialog(null, "\nSessão encerrada!"
                + "\nObrigado e volte sempre!");
        System.exit(0);
    }

}
