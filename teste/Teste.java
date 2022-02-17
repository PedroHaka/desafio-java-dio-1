package teste;

public class Teste{
    //atributes
    public String var1;
    public String var2;

    //methods
    //empty constructor
    public Teste(){}


    public Teste(String A, String B){
        this.var1 = A;
        this.var2 = B;
    }

    public void sayWords(){
        String A = this.var1;
        String B = this.var2;
        System.out.println(A + " " + B + "!!");
    }
    
}