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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import package_controle.ProdutoDAO;
import package_model.Produto;

public class controllerProduto implements Initializable{
	
	  @FXML
	    private Text IdBtnFornecedor;

	    @FXML
	    private Text IdButtonCliente;

	    @FXML
	    private Text IdButtonVendedor;


    @FXML
    private Text btnButon;
    

    @FXML
    private Button btnDeletar;


    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnEditar;


    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltar;

    @FXML
    private  TableColumn<Produto, Integer> columnCodigo;

    @FXML
    private  TableColumn<Produto, String> columnNome;

    @FXML
    private  TableColumn<Produto, String> columnData_fab;

    @FXML
    private  TableColumn<Produto, String> columnData_val;

    @FXML
    private  TableColumn<Produto, Integer> columnEstoque;

    @FXML
    private  TableColumn<Produto, Integer> columnID;

    @FXML
    private  TableColumn<Produto, Double> columnPreço_Un;

    @FXML
    private  TableColumn<Produto, String> columnTipo_un;

    @FXML
    private  TableView<Produto> tableProduto;
    
    @FXML
    private  TextField labelPesquisar;

    private  ObservableList<Produto> arrayProduto;
    private static ProdutoDAO produtoDAO = new ProdutoDAO();

  
    @FXML
    void btnCadastrarProduto(ActionEvent event) throws IOException  {
    	produtoEditor = null;
    	Main.telaCadastrarProduto();
    	
    }
    public static Produto produtoEditor = new Produto();
    @FXML
    void btnEditarProduto(ActionEvent event) throws IOException{
    	if(tableProduto.getSelectionModel().getSelectedIndex() == -1){
    		Alert mensagemDeErro = new Alert(AlertType.INFORMATION);
    		mensagemDeErro.setContentText("Selecione um produto para editar primeiro! ");
    		mensagemDeErro.show();    		
    		
    	}else {
    		int i = tableProduto.getSelectionModel().getSelectedIndex();
    		produtoEditor = tableProduto.getItems().get(1);
    		Main.telaCadastrarProduto();
    	}
    }

    


    @FXML
    void btnPesquisar(ActionEvent event) {
    	 arrayProduto = FXCollections.observableArrayList(produtoDAO.search(labelPesquisar.getText()));

         columnID.setCellValueFactory(new PropertyValueFactory<>("id_produto"));
         columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
         columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
         columnData_fab.setCellValueFactory(new PropertyValueFactory<>("data_fab"));
         columnData_val.setCellValueFactory(new PropertyValueFactory<>("data_val"));
         columnEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
         columnPreço_Un.setCellValueFactory(new PropertyValueFactory<>("Preco_un"));
         columnTipo_un.setCellValueFactory(new PropertyValueFactory<>("Tipo_un"));

         tableProduto.setItems(arrayProduto);
         tableProduto.refresh();

    }
    @FXML
    void btnDeletarAction(ActionEvent event) {
        int i = tableProduto.getSelectionModel().getSelectedIndex();
        if (i == -1) {
            Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
            mensagemDeErro.setContentText("Selecione um produto primeiro");
            mensagemDeErro.show();
        } else {
            Produto produto = tableProduto.getItems().get(i);

            Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
            mensagemDeAviso.setContentText("Deseja realmente excluir o produto: " + produto.getNome());

            Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                produtoDAO.delete(produto.getId_produto()); 
               
                Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
                mensagemDeExclusao.setContentText("Produto excluído com sucesso");
                mensagemDeExclusao.show();
                carregarTableProduto();  
            }
        }
    }
  
    
    @FXML
    void btnVoltarAction(MouseEvent event) {
        // Implement voltar button action here
    }
    
    @FXML
    void ViewBtnVendedor(MouseEvent event) {
    	Main.changeScreen("vendedor");

    }
    
    @FXML
    void ViewBtnFornecedor(MouseEvent event) {
    	Main.changeScreen("Fornecedor");

    }

    @FXML
    void ViewBtnCliente(MouseEvent event) {
    	Main.changeScreen("Cliente");
    }
    
    @FXML
    void btnVoltarProduto(ActionEvent event) {
    	Main.changeScreen("main");	
    }

    public void carregarTableProduto() {
        arrayProduto = FXCollections.observableArrayList(produtoDAO.read());

        columnID.setCellValueFactory(new PropertyValueFactory<>("id_produto"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        columnData_fab.setCellValueFactory(new PropertyValueFactory<>("data_fab"));
        
        columnData_val.setCellValueFactory(new PropertyValueFactory<>("data_val"));
        columnEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
        columnPreço_Un.setCellValueFactory(new PropertyValueFactory<>("Preco_un"));
        columnTipo_un.setCellValueFactory(new PropertyValueFactory<>("Tipo_un"));

        tableProduto.setItems(arrayProduto);
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTableProduto();
	}
}
