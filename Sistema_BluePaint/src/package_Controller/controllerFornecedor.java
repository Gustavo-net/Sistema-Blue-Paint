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
import package_controle.FornecedorDAO;
import package_model.Fornecedor;

public class controllerFornecedor implements Initializable {

	@FXML
	private Text IdButtonCliente;

	@FXML
	private Text IdButtonProduto;

	@FXML
	private Text IdButtonVendedor;

	@FXML
	private Text btnButon;

	@FXML
	private Text btnButon1;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnDeletar;

	@FXML
	private Button btnPesquisar;

	@FXML
	private Button btnVoltar;

	@FXML
	private TableColumn<Fornecedor, String> columnCNPJ;

	@FXML
	private TableColumn<Fornecedor, String> columnEmail;

	@FXML
	private TableColumn<Fornecedor, String> columnEndereço;

	@FXML
	private TableColumn<Fornecedor, Integer> columnID;

	@FXML
	private TableColumn<Fornecedor, String> columnNome;

	@FXML
	private TableColumn<Fornecedor, String> columnTelefone;

	@FXML
	private TextField labelPesquisar;

	@FXML
	private TableView<Fornecedor> tableFornecedor;

	private ObservableList<Fornecedor> arrayFornecedor;
	private FornecedorDAO fornecedorDAO = new FornecedorDAO();
	public static Fornecedor fornecedorEditor = new Fornecedor();

	@FXML
	void btnCadastrarFornecedor(ActionEvent event) throws IOException {
		fornecedorEditor = null;
		Main.telaCadastrarFornecedor();
	}

	@FXML
	void btnEditarFornecedor(ActionEvent event) throws IOException {
		if (tableFornecedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableFornecedor.getSelectionModel().getSelectedIndex();
			fornecedorEditor = tableFornecedor.getItems().get(i);
			Main.telaCadastrarFornecedor();
		}
	}

	@FXML
	void btnDeletarAction(ActionEvent event) {
		int i = tableFornecedor.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor primeiro");
			mensagemDeErro.show();
		} else {
			Fornecedor fornecedor = tableFornecedor.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o fornecedor: " + fornecedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				fornecedorDAO.delete(fornecedor.getIdFornecedor());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Fornecedor excluído com sucesso");
				mensagemDeExclusao.show();
				carregarTableFornecedor();
			}
		}
	}

	@FXML
	void btnPesquisar(ActionEvent event) {
		arrayFornecedor = FXCollections.observableArrayList(fornecedorDAO.search(labelPesquisar.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		tableFornecedor.setItems(arrayFornecedor);
		tableFornecedor.refresh();
	}

	@FXML
    void btnVoltar(ActionEvent event) {
		Main.changeScreen("main");	

    }

	@FXML
	void ViewBtnCliente(MouseEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void ViewBtnProduto(MouseEvent event) {
		Main.changeScreen("Produto");
	}

	@FXML
	void ViewBtnVendedor(MouseEvent event) {
		Main.changeScreen("Vendedor");
	}

	public void carregarTableFornecedor() {
		arrayFornecedor = FXCollections.observableArrayList(fornecedorDAO.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		tableFornecedor.setItems(arrayFornecedor);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTableFornecedor();
	}
}
