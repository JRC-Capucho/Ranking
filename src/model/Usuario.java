package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
public class Usuario {

    private static ArrayList<Integer>id = new ArrayList<>();
    private static int posicao;
    private static ArrayList<String>apelido = new ArrayList<>();
    private static ArrayList<String>senha = new ArrayList<>();

    public Usuario(){
    }
  
    public boolean validarLogin(String username, String pass)
    {
        for (int i = 0; i < id.size(); i++)
        {
            if(apelido.get(i).equals(username) && senha.get(i).equals(pass))
                return true;   
        }
        msgLoginErro();
        return false;
    }

    
    public void verificarDados(String pass, String confPass, String username)
    {
        boolean aux = false;

        if(username.length() > 0 && pass.length() > 0 && confPass.length() > 0)
        {
            if(!confPass.equals(pass))
            {
                msgErroSenhas();
                aux = true;
            }
            else
            {
                for (int index = 0; index < apelido.size(); index++) 
                {
                    if(apelido.get(index).equals(username))
                    {
                        msgCadastroExistente();
                        aux = true;
                    }
                }
            }
        }
        else
        {
            msgErroVazio();
            aux = true;
        }
        if(!aux)
            cadastrar(pass,username);
    }
        
    public void cadastrar(String pass,String username)
    {
        id.add(posicao);
        apelido.add(username);
        senha.add(pass);       
        posicao++;
        msgSucesso();
    }

    private void msgSucesso()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Realizado com sucesso!");
        alert.setContentText("Conta criada com sucesso!");
        alert.show();
    }
    
    private void msgErroSenhas()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa");
        alert.setContentText("Senhas diferentes!");
        alert.show();
    }

    private void msgLoginErro()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa!");
        alert.setContentText("Nome de usuário ou senha invalidas!");
        alert.show();
    }

    private void msgCadastroExistente()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Nome de usuário já existe");
        alert.setContentText("Esse nome de usuário já esta cadastrado");
        alert.show();
    }

    private void msgErroVazio()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Campos vazios");
        alert.setHeaderText("Nome de usuário e senha vazios");
        alert.setContentText("Por favor preencher os campos");
        alert.show();
    }

}
