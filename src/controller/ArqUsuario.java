package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArqUsuario
{

    public String read(String caminho)
    {
        String conteudo = "";

        try{
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";

            try {
                linha = lerArq.readLine();
                while (linha != null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException e) {
                System.out.println("Erro: Nao foi possível ler o arquivo!");
            return "";
            }
        }catch(FileNotFoundException ex){
            System.out.println("Erro: Arquivo nao encontrado!");
            return "";
        }
    }

    public boolean Write(String caminho, String texto)
    {
        try {
            FileWriter arq = new FileWriter(caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

  

   }
