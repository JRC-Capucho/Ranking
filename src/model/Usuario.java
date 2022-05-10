package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
<<<<<<< HEAD
import java.util.Map;
import java.util.HashMap;
import controller.PerfilController;
public class Usuario {

    //private int id;
    private PerfilController pControl;
    private String nome;
    private String senha;
    private String confirmarSenha;
    private static Map<String, String> usuarioAdd = new HashMap<>();
=======
import java.util.ArrayList;
public class Usuario {

    private static ArrayList<Integer>id = new ArrayList<>();
    private static int posicao;
    private static ArrayList<String>apelido = new ArrayList<>();
    private static ArrayList<String>senha = new ArrayList<>();
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e

    public Usuario(){
    }
  
    public boolean validarLogin(String username, String pass)
    {
<<<<<<< HEAD

        if(usuarioAdd.containsKey(nome) == false)
        {
            return false;
        }
        else if(usuarioAdd.get(nome).equals(senha))
        {
            pControl = new PerfilController();
            pControl.setUsername(nome);
            return true;
        }
        else
        {
            return false;
=======
        for (int i = 0; i < id.size(); i++)
        {
            if(apelido.get(i).equals(username) && senha.get(i).equals(pass))
                return true;   
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e
        }
        msgLoginErro();
        return false;
    }

    
    public void verificarDados(String pass, String confPass, String username)
    {
        boolean aux = false;
        if(!confPass.equals(pass))
        {
<<<<<<< HEAD
            verificarDuplicata();
        }
        else
        {
            msgErro();
        }
    }

    public void verificarDuplicata()
    {
        if(usuarioAdd.containsKey(nome))
        {
            msgCadastroExistente();
=======
            msgErroSenhas();
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e
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
            if(!aux)
                cadastrar(pass,username);
        }
    }
        
    public void cadastrar(String pass,String username)
    {
        id.add(posicao);
        apelido.add(username);
        senha.add(pass);       
        posicao++;
        msgSucesso();
    }

    public void msgSucesso()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Realizado com sucesso!");
        alert.setContentText("Conta criada com sucesso!");
        alert.show();
    }
    
    public void msgErroSenhas()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa");
        alert.setContentText("Senhas diferentes!");
        alert.show();
    }

    public void msgLoginErro()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Erro ao realizar tarefa!");
        alert.setContentText("Nome de usuário ou senha invalidas!");
        alert.show();
    }

    public void msgCadastroExistente()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Nome de usuário já existe");
        alert.setContentText("Esse Nome de usuário já esta cadastrado");
        alert.show();
    }

    /*
    public void msgIrParaCadastro()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Deseja Cadastrar conta");
        alert.setHeaderText("Email e senha invalidas");
        alert.setContentText("Email ou senha não cadastrado");
        alert.show();
    }
    */

<<<<<<< HEAD
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
=======
>>>>>>> 16178e907e9c78636e0bd60a46e5f9120e6fc09e
}
