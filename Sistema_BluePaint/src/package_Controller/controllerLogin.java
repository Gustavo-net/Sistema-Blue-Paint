package package_Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import package_controle.VendedorDAO;
import package_model.Vendedor;

public class controllerLogin {

    @FXML
    private Button btnButton;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtUser;
    @FXML
    private ToggleButton VerSenha;
    static Vendedor vendedor = new Vendedor();

    @FXML
    void btnButtonTeste(ActionEvent event) {
    	
    	   VendedorDAO v = new VendedorDAO();
    	  
    	    
    	    vendedor = v.autenticarUser(txtUser.getText(), txtPassword.getText());
    	    
    	    if(vendedor.getCPF()!=null && vendedor.getPassword()!=null) {
    	    	Alert saudacao = new Alert(Alert.AlertType.CONFIRMATION);
    	    	saudacao.setHeaderText("Saudação");
    	    	saudacao.setTitle("Bem-vindo");
    	    	saudacao.setContentText("Seja bem vindo de volta"+ vendedor.getNome()+"!");
    	    	saudacao.show();
    	    	Main.changeScreen("main");
    	    } else {
    	    	Alert erro = new Alert(Alert.AlertType.ERROR);
    	    		erro.setTitle("Falha ao realizar o login");
    	    		erro.setHeaderText("Erro!");
    	    		erro.setContentText("Usuário ou senha incorreta! Verifique as informações se estão fornecidas corretamente");
    	    		erro.show();
    	    }
    	    
    }
    
    @FXML
    void visualizarSenha(ActionEvent event) {
    	if(VerSenha.isSelected()){
    		txtSenha.setText(txtPassword.getText());
    		txtPassword.setVisible(false);
    		txtSenha.setVisible(true);
    	}else {
    		txtPassword.setText(txtSenha.getText());
    		txtPassword.setVisible(true);
    		txtSenha.setVisible(false);
    	}
    	
    	

    }

}
