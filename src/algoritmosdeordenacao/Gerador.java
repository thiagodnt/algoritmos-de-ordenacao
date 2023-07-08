package algoritmosdeordenacao;

import java.io.IOException;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class Gerador {
    
    static int quantidade;
    static String dir = getDirectory();
    
    public static String geraDados() throws IOException {
        
        Random random = new Random();
        DecimalFormat decimal = new DecimalFormat("#.##");
        Scanner input = new Scanner(System.in);
        
        String fileName = "\\dados-desordenados.txt";
        String fullPath = dir + fileName;
                
        System.out.print("\nDigite a quantidade de dados que deseja gerar >>> ");
        quantidade = input.nextInt();
        
        double vetor[] = new double[quantidade];
        
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextDouble()*100; // Gera uma sequência desordenada de números aleatórios
        }
        
        gravarArquivo(fullPath, vetor); // Grava em um arquivo .txt a sequência de números aleatórios
        
        return fullPath;
    }
    
    public static String getDirectory() {
        String dir = System.getProperty("user.home") + File.separator + "Documents";
        return dir;
    }
    
    public static void gravarArquivo(String caminho, double v[]) throws IOException {
        
        File file = new File(caminho);
       
       try {
           if(!file.exists()){
               file.createNewFile();    // Se o arquivo já existir no diretório especificado, um novo arquivo será criado substituindo o mesmo
           }
           
           FileWriter fileWriter = new FileWriter(caminho); // Especifica através do caminho o arquivo que será gerado pelo programa
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);  // Gera a saída do arquivo através do buffer
           
           for (int i = 0; i < v.length; i++){
               bufferedWriter.write(v[i]+"");  // Grava no arquivo o conteúdo do vetor 'v[]'
               bufferedWriter.newLine();
           }
           
           bufferedWriter.close();
           fileWriter.close();
           
       } catch (IOException error){
           System.out.println(error);
       }
    } 
}
