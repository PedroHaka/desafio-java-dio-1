package teste;

public class Main {
    public static void main(String[] args) {
        //variables
        String var1 = "Hello";
        String var2 = "World";
        String var3 = "Heavy";
        String var4 = "Metal";

        //creating an object "Teste"
        Teste compliment = new Teste(var1, var2);
        Teste rock = new Teste();
        rock.var1 = var3;
        rock.var2 = var4;

        //calling functions/methods
        compliment.sayWords();
        rock.sayWords();

        //System.out.println("Olá Mundo!");
    }
}
