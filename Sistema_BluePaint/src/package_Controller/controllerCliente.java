package package_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import package_controle.ClienteDAO;
import package_model.Cliente;

public class controllerCliente implements Initializable {
	
    @FXML
    private Button btnVoltar;

	@FXML
	private Button btnEditar;

	@FXML
	private Text IdButtonVendedor;

	@FXML
	private Text IdButtonFornecedor;

	@FXML
	private Text IdButtonProduto;

	@FXML
	private Button btnPesquisar;

	@FXML
	private TextField labelPesquisar;

	@FXML
	private Text btnButon;

	@FXML
	private Button btnDeletar;

	@FXML
	private TableColumn<Cliente, String> columnCPF_CNPJ;

	@FXML
	private TableColumn<Cliente, String> columnDataNasc;

	@FXML
	private TableColumn<Cliente, String> columnDataPrimComp;

	@FXML
	private TableColumn<Cliente, String> columnEmail;

	@FXML
	private TableColumn<Cliente, String> columnEndereço;

	@FXML
	private TableColumn<Cliente, String> columnID;

	@FXML
	private TableColumn<Cliente, String> columnNome;

	@FXML
	private TableColumn<Cliente, String> columnTelefone;

	@FXML
	private TableColumn<Cliente, String> columnTipoJurd;

	@FXML
	private TextField txtPesquisar;

	@FXML
	private TableView<Cliente> tableCliente;

	private ObservableList<Cliente> arrayCliente;
	private ClienteDAO clienteDAO = new ClienteDAO();

	public static Cliente clienteEditor = new Cliente();

	@FXML
	void ViewBtnVendedor(MouseEvent event) {
		Main.changeScreen("vendedor");

	}

	@FXML
	void ViewBtnFornecedor(MouseEvent event) {
		Main.changeScreen("Fornecedor");

	}

	@FXML
	void ViewBtnProduto(MouseEvent event) {
		Main.changeScreen("Produto");

	}

    @FXML
    void btnVoltar(ActionEvent event) {
    	Main.changeScreen("main");	

    }

	@FXML
	void btnButonAction(MouseEvent event) {
		// Implement button action here
	}

	public void carregarTableCliente() {
		arrayCliente = FXCollections.observableArrayList(clienteDAO.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		columnCPF_CNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataPrimComp.setCellValueFactory(new PropertyValueFactory<>("DataPrimCom"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		tableCliente.setItems(arrayCliente);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		carregarTableCliente();
	}

	@FXML
	void btnDeletarAction(ActionEvent event) {
		int i = tableCliente.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro");
			mensagemDeErro.show();
		} else {
			Cliente cliente = new Cliente();
			cliente = tableCliente.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir a clientee: " + cliente.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();
				c.delete(cliente.getCPF_CNPJ());

				Alert mensagemDeExclusivo = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusivo.setContentText("Cliente excluido com sucesso");
				mensagemDeExclusivo.show();
				carregarTableCliente();
			}
		}
	}

	@FXML
	void btnPesquisar(ActionEvent event) {

		arrayCliente = FXCollections.observableArrayList(clienteDAO.search(labelPesquisar.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		columnCPF_CNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataPrimComp.setCellValueFactory(new PropertyValueFactory<>("DataPrimCom"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		tableCliente.setItems(arrayCliente);
		tableCliente.refresh();

	}

	@FXML
	void btnEditarCliente(ActionEvent event) throws IOException {

		if (tableCliente.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableCliente.getSelectionModel().getSelectedIndex();
			clienteEditor = tableCliente.getItems().get(i);
			Main.telaCadastrarCliente();
		}

	}
}
