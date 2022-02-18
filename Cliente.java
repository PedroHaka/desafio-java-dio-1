package bancodigitaldio;

public class Cliente {
    private String name;
    private String cpf;

    //constructors
    public Cliente(){}

    public Cliente(String A, String B){
        this.name = A;
        this.cpf = B;
    }

    //methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nCliente {" +
            "\nname='" + getName() +
            "\ncpf='" + getCpf() +
            "\n}";
    }

}
