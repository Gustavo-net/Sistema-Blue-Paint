module Sistema_BluePaint {
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	exports package_Controller;
	exports package_model;
	exports package_controle;
	
	opens package_Controller to javafx.fxml;
	opens package_model to javafx.fxml;
    opens package_controle to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	
}
