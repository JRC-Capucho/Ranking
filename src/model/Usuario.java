package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    public Usuario(){
    }
  
    public boolean validarLogin()
    {

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
        }
    }

    public void verificarSenha()
    {
        if(confirmarSenha.equals(senha))
        {
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
        }
        else
        {
            cadastrar();
        }
    }
        
    public void cadastrar()
    {
        usuarioAdd.put(nome, senha);
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
    
    public void msgErro()
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
}
