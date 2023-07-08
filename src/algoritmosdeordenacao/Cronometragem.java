package algoritmosdeordenacao;

public class Cronometragem {
    private static long tempoInicial;
    private static long tempoFinal;
    private static long tempoDecorrido;
    
    public static void start(){
        tempoInicial = System.currentTimeMillis();
        tempoFinal = 0;
        tempoDecorrido = 0;
    }
    
    public static long stop(){
        tempoFinal = System.currentTimeMillis();
        tempoDecorrido = tempoFinal - tempoInicial;
        return tempoDecorrido;
    }
    
//    public static long tempoDecorrido(){
//        System.out.println(System.currentTimeMillis() + "\n");
//        return tempoDecorrido;
//    }
}
