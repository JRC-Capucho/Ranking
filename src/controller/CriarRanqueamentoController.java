package controller;


import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import viewii.CriarRanqueamento;
import viewii.Perfil;
import model.Ranque;
import model.Items;

public class CriarRanqueamentoController
{
    Ranque ranque = new Ranque();

    private ArrayList<String> escolhas = new ArrayList<>();
    
    @FXML
    private Button btAdicionarItem;

    @FXML
    private ToggleGroup meuGrupo;

    @FXML
    private DatePicker dpEncerramentoRanque;

    @FXML
    private Button btCriar;

    @FXML
    private Button btExcluir;

    @FXML
    private TableView<Items> tabela;    

    @FXML
    private TableColumn<Items, String> itens;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private TextField tfNomeDoRanque;

    @FXML
    private RadioButton rbAberto;

    @FXML
    private RadioButton rbFechado; 


    public void initialize()
    {

        itens.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        btVoltar.setOnMouseClicked((MouseEvent e)->{
            voltarPerfil();
        });    
        
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                voltarPerfil();
        });        
        
        btAdicionarItem.setOnMouseClicked((MouseEvent e)->{
            adicionarItemNaTabela();
        });    

        btAdicionarItem.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                adicionarItemNaTabela(); 
        });
        
        btExcluir.setOnMouseClicked((MouseEvent e)->{
            removerItemDaTabela();
        });

        btExcluir.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                removerItemDaTabela(); 
        });

        btCriar.setOnMouseClicked((MouseEvent e)->{
            criarRanque();
        });

    }    

    @FXML
    void tipoRanque(ActionEvent event)
    {
        if(rbAberto.isSelected())
        {
            System.out.println("Aberto");
        }
        if(rbFechado.isSelected())
        {
            System.out.println("Fechado");
        }
    }
 
    @FXML
    void getData(ActionEvent event)
    {
        LocalDate data = dpEncerramentoRanque.getValue();
        System.out.println(data);
    }

    private void adicionarItemNaTabela() 
    {
        Items ite = new Items(ranque.adicionarOpcoesDeEscolha());
        ObservableList<Items> lista = tabela.getItems();

        if(ite.getItem() != null)
        {
            escolhas.add(ite.getItem());
            lista.add(ite);
            tabela.setItems(lista);
        }
    }

    private void removerItemDaTabela()
    {   
        int posicao = tabela.getSelectionModel().getSelectedIndex();
        if(ranque.msgConfirmarExclusao())
        {
            tabela.getItems().remove(posicao);
            escolhas.remove(posicao);
        }
        
    }

    private void criarRanque()
    {
        ranque.criarVetor(escolhas.size());
        ranque.addEscolharDeVotos(escolhas);
        ranque.setTituloaux(tfNomeDoRanque.getText());
        msgRanqueCriado();
        voltarPerfil();
    }

    private void voltarPerfil()
    {
        Perfil perfil = new Perfil();
        fechar();
        try {
            perfil.start(new Stage());
        } catch (Exception e) {
        }
        
    }

    private void msgRanqueCriado()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Criado Sucesso");
        alert.setHeaderText("Realizado com sucesso!");
        alert.setContentText("Ranque criada com sucesso!");
        alert.showAndWait();
    }
   
    
    private void fechar()
    {
        CriarRanqueamento.getStage().close();
    }
    
    
}

