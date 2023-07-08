package algoritmosdeordenacao;

public class Ordenacao {
    public static double[] bubbleSort(double v[]) {
        
        int i, j;
        double aux;
        
        Cronometragem.start();
        
        for (i = 0; i < v.length-1; i++) {
            for (j = 1; j < v.length; j++) {
                if (v[j] < v[j-1]) {
                    aux = v[j];
                    v[j] = v[j-1];
                    v[j-1] = aux;
                }                          
            }
        }
        
        Cronometragem.stop();
        
        AlgoritmosDeOrdenacao.imprimeVetor(v, "\nOrdenacao Bubble Sort:");
        System.out.println("\nTempo total de execucao da ordenacao Bubble Sort >> " + Cronometragem.stop() + " milissegundos");
        
        return v;
        }
    
    public static double[] insertionSort(double v[]) {
        
        int i, j;
        double aux;
        
        Cronometragem.start();
        
        for (j = 1; j < v.length; j++) {
            aux = v[j];
                for (i = j-1; i >= 0 && v[i] > aux; --i) {
                    v[i+1] = v[i];
                }
            v[i+1] = aux;
        }
        
        Cronometragem.stop();
        
        AlgoritmosDeOrdenacao.imprimeVetor(v, "\nOrdenacao Insertion Sort:");
        System.out.println("\nTempo total de execucao da ordenacao Insertion Sort >> " + Cronometragem.stop() + " milissegundos");
        
        return v;
        }
    
    public static double[] selectionSort(double v[]) {
        
        int i, j, min;
        double aux;
        
        Cronometragem.start();
        
        for (i = 0; i < v.length; i++) {
            min = i;
            for (j = i + 1; j < v.length; j++) {
                if (v[j] < v[min]) {
                    min = j;
                }
            }
 
            aux = v[min];
            v[min] = v[i];
            v[i] = aux;
        
        }
            
        Cronometragem.stop();
        
        AlgoritmosDeOrdenacao.imprimeVetor(v, "\nOrdenacao Selection Sort:");
        System.out.println("\nTempo total de execucao da ordenacao Selection Sort >> " + Cronometragem.stop() + " milissegundos");
        
        return v;
        }
}
