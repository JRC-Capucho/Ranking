package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Map;
import java.util.HashMap;
public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String email;
    private String confirmarSenha;
    private  static Map<String, String> usuarioAdd = new HashMap<>();

    public Usuario(){
    }
   
    public boolean validarLogin()
    {
        System.out.println(usuarioAdd);

        if(usuarioAdd.containsKey(email) == false)
        {
            return false;
        }
        else if(usuarioAdd.get(email).equals(senha))
        {
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
            msgErro();
    }

    public void verificarDuplicata()
    {
        if(usuarioAdd.containsKey(email))
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
        usuarioAdd.put(email, senha);
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
        alert.setContentText("Email ou senha invalidas!");
        alert.show();
    }

    public void msgCadastroExistente()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Email ja existe");
        alert.setContentText("Esse email já esta cadastrado");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}
