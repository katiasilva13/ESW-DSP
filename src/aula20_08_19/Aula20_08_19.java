/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula20_08_19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author ktia-
 */
public class Aula20_08_19 {

    /**
     * @param args the command line arguments
     */
    public int testeInteiro(int a) {
        return a;
    }

    //mostra no console o conteudo do arquivo csv
    public static void csvAquivo() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        InputStream is = new FileInputStream("src\\aula20_08_19\\ARQ.csv");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");

        try (BufferedReader br = new BufferedReader(isr)) {
            String s = br.readLine();

            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }
        }

        System.out.println("Unicode ");
    }

    //copia o arquivo mp3
    public static void mp3File() throws IOException {

        File file = new File("C:\\Users\\ktia-\\Music\\Bad Company\\Bad Company - Feel Like Makin' Love.mp3");
        byte[] bytes = Files.readAllBytes(file.toPath());
        FileOutputStream fos = new FileOutputStream(
                "C:\\Users\\ktia-\\Music\\Bad Company\\Bad Company - teste.mp3");

        fos.write(bytes);
        fos.close();
        System.out.println("Arquivo MP3 ");
    }

    //mostra no console o conteudo do arquivo .txt
    
    public static void txtFileRead(String path) throws IOException {
// public static void txtFileRead() throws IOException {
   // try (InputStream is = new FileInputStream("src\\aula20_08_19\\testando.txt")) {
        
        try (InputStream is = new FileInputStream(path)) {
            Scanner entrada = new Scanner(is);
            while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }
        }

    }
//edita o conteudo do arquivo .txt

    public static void textFileWrite() throws IOException {
        OutputStream os = new FileOutputStream("src\\aula20_08_19\\saida.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("Java");
        bw.newLine();
        bw.close();

    }

    //lê e edita o conteudo do arquivo .txt
    public static void leGrava() throws IOException {
        try (InputStream is = new FileInputStream("src\\aula20_08_19\\testando.txt")) {
        //    Scanner entrada = new Scanner(is);
        /*    while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }
            
  */        
            txtFileRead("src\\aula20_08_19\\testando.txt");
            
            OutputStream os = new FileOutputStream("src\\aula20_08_19\\testando.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("paçoca");
            bw.newLine();
            bw.close();
            txtFileRead("src\\aula20_08_19\\testando.txt");
            
        }

        /*  
         */
    }
    /*   OutputStream os = new FileOutputStream("src\\aula20_08_19\\testando.txt");
     OutputStreamWriter osw = new OutputStreamWriter(os);
     BufferedWriter bw = new BufferedWriter(osw);
     bw.write("21-08-19 01-02");
     bw.newLine();
     bw.close();
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        //  csvAquivo();
        //  mp3File();
        //txtFileRead();
        //    textFileWrite();
        leGrava();
    }

    private Path toPath() {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

}
