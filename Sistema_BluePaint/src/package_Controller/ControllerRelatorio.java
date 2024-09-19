package package_Controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import package_controle.CompraDAO;
import package_model.Compra;

public class ControllerRelatorio implements Initializable {

    @FXML
    private Text btnButon1;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Compra, String> columnClientes;

    @FXML
    private TableColumn<Compra, String> columnID;

    @FXML
    private TableColumn<Compra, String> columnPreço;

    @FXML
    private TableColumn<Compra, String> columnProduto;

    @FXML
    private TableColumn<Compra, String> columnQuantidade;

    @FXML
    private TableColumn<Compra, String> columnVendedor;

    @FXML
    private TextField labelPesquisar;

    @FXML
    private TableView<Compra> tableRelatorio;

    private ObservableList<Compra> arrayCompra;
    private static CompraDAO compraDAO = new CompraDAO();

    @FXML
    void btnCadastrar(ActionEvent event) {
        // Implementar ação para o botão Cadastrar, se necessário
    }

    @FXML
    void btnPesquisar(ActionEvent event) {
        arrayCompra = FXCollections.observableArrayList(compraDAO.read());

        columnID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
        columnClientes.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        columnProduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnPreço.setCellValueFactory(new PropertyValueFactory<>("Preço_Total"));

        tableRelatorio.setItems(arrayCompra);
        tableRelatorio.refresh();
    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	Main.changeScreen("main");	
    }
    
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarTableRelatorio();
    }

    private void carregarTableRelatorio() {
        arrayCompra = FXCollections.observableArrayList(compraDAO.read());

        columnID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
        columnClientes.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        columnProduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnPreço.setCellValueFactory(new PropertyValueFactory<>("Preço_Total"));

        tableRelatorio.setItems(arrayCompra);
    }
}
