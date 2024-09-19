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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import package_controle.VendedorDAO;
import package_model.Vendedor;

public class controllerVendedor implements Initializable {

	@FXML
	private Button btnPesquisar;

	@FXML
	private TextField labelPesquisar;

	@FXML
	private Text IdButtonFornecedor;

	@FXML
	private Text IdButtonProduto;

	@FXML
	private Text idButtonCliente;

	@FXML
	private TableView<Vendedor> TableVendedor;

	@FXML
	private Button btnDeletar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Text btnButon;

	@FXML
	private Text btnButon1;

	@FXML
	private Button btnVoltar;

	@FXML
	private TableColumn<Vendedor, String> columnCPF;

	@FXML
	private TableColumn<Vendedor, String> columnDataCont;

	@FXML
	private TableColumn<Vendedor, String> columnDataNasc;

	@FXML
	private TableColumn<Vendedor, String> columnEmail;

	@FXML
	private TableColumn<Vendedor, String> columnEndereço;

	@FXML
	private TableColumn<Vendedor, String> columnID;

	@FXML
	private TableColumn<Vendedor, String> columnNome;

	@FXML
	private TableColumn<Vendedor, String> columnTelefone;

	@FXML
	private TableColumn<Vendedor, String> columnTotalVend;

	public static Vendedor vendedorEditor = new Vendedor();

	private ObservableList<Vendedor> ArrayVendedor;
	private VendedorDAO vendedorDAO = new VendedorDAO();

	@FXML
	void btnButtonTeste(MouseEvent event) {
		// Implementar ação do botão de teste, se necessário
	}

  

	@FXML
	void ViewBtnCliente(MouseEvent event) {
		Main.changeScreen("Cliente");
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
	void btnVoltarVendedor(ActionEvent event) {
		Main.changeScreen("main");
	}

	@FXML
	void btnCadastrarVendedor(ActionEvent event) throws IOException {
		vendedorEditor = null;
		Main.telaCadastrarVendedor();
	}

	@FXML
	void btnEditarVendedor(ActionEvent event) throws IOException {
		if (TableVendedor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = TableVendedor.getSelectionModel().getSelectedIndex();
			vendedorEditor = TableVendedor.getItems().get(i);
			Main.telaCadastrarVendedor();
		}
	}

	@FXML
	void btnDeletarAction(ActionEvent event) {
		int i = TableVendedor.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			Vendedor vendedor = TableVendedor.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o vendedor: " + vendedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				vendedorDAO.delete(vendedor.getCPF());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Vendedor excluído com sucesso");
				mensagemDeExclusao.show();
				CarregarTableVendedor();
			}
		}
	}

	@FXML
	void btnPesquisar(ActionEvent event) {
		ArrayVendedor = FXCollections.observableArrayList(vendedorDAO.search(labelPesquisar.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("Id_Vendedor"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataCont.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVend.setCellValueFactory(new PropertyValueFactory<>("Total_Vend"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		TableVendedor.setItems(ArrayVendedor);
		TableVendedor.refresh();
	}

	public void CarregarTableVendedor() {
		ArrayVendedor = FXCollections.observableArrayList(vendedorDAO.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("Id_Vendedor"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNasc.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataCont.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVend.setCellValueFactory(new PropertyValueFactory<>("Total_Vend"));
		columnEndereço.setCellValueFactory(new PropertyValueFactory<>("Endereço"));

		TableVendedor.setItems(ArrayVendedor);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableVendedor();
	}
}
