package controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import model.Usuario;
import model.Items;

public class CriarRanqueamentoController {
    private Ranque ranque = new Ranque();
    private PerfilController perfilController = new PerfilController();
    private Usuario user = new Usuario();
    private int id = user.getIdUser();

    private ArrayList<String> escolhas = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDateTime minimoDia;
    private LocalDate dataDeInicio, dataDeTermino;
    private Boolean tipoRanque;

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

    public void initialize() {

        itens.setCellValueFactory(new PropertyValueFactory<Items, String>("item"));
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        dpEncerramentoRanque.setValue(LocalDate.now());

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            voltarPerfil();
        });

        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                voltarPerfil();
        });

        btAdicionarItem.setOnMouseClicked((MouseEvent e) -> {
            adicionarItemNaTabela();
        });

        btAdicionarItem.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                adicionarItemNaTabela();
        });

        btExcluir.setOnMouseClicked((MouseEvent e) -> {
            removerItemDaTabela();
        });

        btExcluir.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                removerItemDaTabela();
        });

        btCriar.setOnMouseClicked((MouseEvent e) -> {
            criarRanque();
        });

        btCriar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER)
                criarRanque();
        });

    }

    @FXML
    void tipoRanque(ActionEvent event) {
        if (rbAberto.isSelected())
            tipoRanque = true;
        if (rbFechado.isSelected())
            tipoRanque = false;
    }

    @FXML
    void getData(ActionEvent event) throws ParseException {
        LocalDate dataCalendario = dpEncerramentoRanque.getValue();
        minimoDia = LocalDateTime.now();

        String sdc = dataCalendario.toString();
        String sdda = dtf.format(minimoDia).toString();

        converterDiaStringParaInt(sdc, sdda);
    }

    private void converterDiaStringParaInt(String sdc, String sdda) {

        int calendarioAno = Integer.parseInt(sdc.substring(0, 4));
        int calendarioMes = Integer.parseInt(sdc.substring(6, 7));
        int calendarioDia = Integer.parseInt(sdc.substring(9, 10));

        int atualAno = Integer.parseInt(sdda.substring(0, 4));
        int atualMes = Integer.parseInt(sdda.substring(6, 7));
        int atualDia = Integer.parseInt(sdda.substring(9, 10));

        if (atualAno == calendarioAno && atualMes <= calendarioMes && atualDia <= calendarioDia) {
            dataDeInicio = dpEncerramentoRanque.getValue();
            dataDeTermino = dpEncerramentoRanque.getValue().plusDays(7);
        } else {
            dpEncerramentoRanque.setValue(LocalDate.now());
            dataDeInicio = dpEncerramentoRanque.getValue();
            System.out.println(dpEncerramentoRanque);
            dataDeTermino = dpEncerramentoRanque.getValue().plusDays(7);
        }
    }

    private void adicionarItemNaTabela() {
        Items ite = new Items(ranque.adicionarOpcoesDeEscolha());
        ObservableList<Items> lista = tabela.getItems();

        if (ite.getItem() != null) {
            escolhas.add(ite.getItem());
            lista.add(ite);
            tabela.setItems(lista);
        }
    }

    private void removerItemDaTabela() {
        int posicao = tabela.getSelectionModel().getSelectedIndex();
        if (ranque.msgConfirmarExclusao()) {
            tabela.getItems().remove(posicao);
            escolhas.remove(posicao);
        }

    }

    private void criarRanque() {
        ranque.criarRanque(id, escolhas);
        ranque.adicionarNomeDoRanque(id, tfNomeDoRanque.getText());
        ranque.setDataDeInicio(id, dataDeInicio);
        ranque.setDataDeTermino(id, dataDeTermino);
        ranque.setTipoRanque(id, tipoRanque);
        perfilController.setExisteRanque(false);
        perfilController.setRestrigirAcesso(false);
        msgRanqueCriado();
        voltarPerfil();
    }

    private void voltarPerfil() {
        Perfil perfil = new Perfil();
        fechar();
        try {
            perfil.start(new Stage());
        } catch (Exception e) {
        }

    }

    private void msgRanqueCriado() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Criado Sucesso");
        alert.setHeaderText("Realizado com sucesso!");
        alert.setContentText("Ranque criada com sucesso!");
        alert.showAndWait();
    }

    private void fechar() {
        CriarRanqueamento.getStage().close();
    }
}
