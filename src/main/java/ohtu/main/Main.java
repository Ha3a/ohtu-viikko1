package ohtu.main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static final double lul = 10.0;
    
    public static void main(String[] args) {

        
        
        Varasto v = new Varasto(lul);
        
        System.out.println(v.toString());

    }
}
