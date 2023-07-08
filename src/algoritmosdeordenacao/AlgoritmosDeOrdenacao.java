package algoritmosdeordenacao;

import static algoritmosdeordenacao.Gerador.getDirectory;
import java.util.Scanner;
import java.io.IOException;

public class AlgoritmosDeOrdenacao {

        static Arquivo arquivo = new Arquivo();
    
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        int opcao;
        
        System.out.println("     ***///       ALGORITMOS DE ORDENACAO       ///***\n");
        
        //Gerador.geraDados();    // Executa função que gera o arquivo com os dados desordenados
        String filePath = Gerador.geraDados();  // Salva em uma variável o caminho + nome do arquivo gerado;
        
        double vetorDesordenado[] = new double[Gerador.quantidade];
        
        System.out.println("\nVetor desordenado:");
        vetorDesordenado = arquivo.lerArquivo(filePath, vetorDesordenado);

        System.out.print("\nDigite a opção de ordenacao desejada:\n1 - Bubble Sort\n2 - Insertion Sort\n3 - Selection Sort\n>>> ");
        opcao = input.nextInt();
        
        verificaOpcao(opcao, vetorDesordenado);    // Verifica a opção de ordenação desejada
        
        System.out.println("Um arquivo contendo os dados ordenados foi criado COM SUCESSO na pasta Documentos\n");
        
    }
    
    public static void imprimeVetor(double v[], String msg) {
        
        System.out.println(msg);
        
        for (int i = 1; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
    
    public static void verificaOpcao(int opcao, double v[]) throws IOException{
        
        double vetorOrdenado[] = new double[Gerador.quantidade];
        String fileName = "\\dados-ordenados.txt";
        String fullPath = Gerador.dir + fileName;
        
        switch(opcao){
            case 1:
                vetorOrdenado = Ordenacao.bubbleSort(v);
                arquivo.gravarArquivo(fullPath,"ORDENACAO BUBBLE SORT", "Tempo total de execucao da ordenacao Bubble Sort >> " + Cronometragem.stop() + " milissegundos", v);
                break;
            case 2:
                vetorOrdenado = Ordenacao.insertionSort(v);
                arquivo.gravarArquivo(fullPath,"ORDENACAO INSERTION SORT", "Tempo total de execucao da ordenacao Insertion Sort >> " + Cronometragem.stop() + " milissegundos", v);
                break;
            case 3:
                vetorOrdenado = Ordenacao.selectionSort(v);
                arquivo.gravarArquivo(fullPath,"ORDENACAO SELECTION SORT", "Tempo total de execucao da ordenacao Selection Sort >> " + Cronometragem.stop() + " milissegundos", v);
                break;
            default:
                System.out.println("\nOpcao invalida");
                break;
        }
    }
}
