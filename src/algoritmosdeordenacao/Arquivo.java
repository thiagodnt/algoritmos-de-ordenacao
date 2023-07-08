package algoritmosdeordenacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    
    public double[] lerArquivo(String caminho, double vetor[]) throws FileNotFoundException, IOException {
        
        File file = new File(caminho);  // Cria o arquivo no caminho especificado
        FileReader fileReader = new FileReader(file);   // Lê o arquivo especificando qual arquivo deve ser lido pelo programa
        BufferedReader bufferedReader = new BufferedReader(fileReader); // Leitura do arquivo no buffer
        
        String dados = null;
        int i = 0;
        
        while(bufferedReader.ready()){
            dados = bufferedReader.readLine();  // Armazena na String 'dados' cada linha do arquivo .txt
            System.out.println(dados);          // Sempre imprimindo na tela o conteúdo da mesma
            vetor[i] = Double.parseDouble(dados);   // Armazena no vetor o conteúdo da String 'dados' (cada linha do arquivo .txt)
            i++;
        }
        
        bufferedReader.close();
        fileReader.close();
        
        return vetor;
   }

    public void gravarArquivo(String caminho, String tipoAlgoritmo, String msgTempo, double v[]) throws IOException {
       
       File file = new File(caminho);
       
       try {
           if(!file.exists()){
               file.createNewFile();    // Se o arquivo já existir no diretório especificado, um novo arquivo será criado substituindo o mesmo
           }
           
           FileWriter fileWriter = new FileWriter(caminho); // Especifica através do caminho o arquivo que será gerado pelo programa
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);  // Gera a saída do arquivo através do buffer
           
           bufferedWriter.write(tipoAlgoritmo);
           bufferedWriter.newLine();
           
           for (int i = 0; i < v.length; i++){
               bufferedWriter.write(v[i]+"");  // Grava no arquivo o conteúdo do vetor 'v[]'
               bufferedWriter.newLine();
           }
           
           bufferedWriter.write(msgTempo);
           bufferedWriter.newLine();
           
           bufferedWriter.close();
           fileWriter.close();
           
       } catch (IOException error){
           System.out.println(error);
       }
   }
}
