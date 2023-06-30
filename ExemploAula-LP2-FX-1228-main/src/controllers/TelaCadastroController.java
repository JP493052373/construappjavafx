package controllers;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoConstrutor;
import entidades.Construtor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaCadastroController {
	
	@FXML
	private BorderPane raizTelaCadastro;
	
	@FXML
	private TextField textFieldEmail;
	
	@FXML
	private PasswordField passwordField;
	
	
	
	public void clickCadastrar() throws IOException{
		String email = textFieldEmail.getText().trim();
		String senha = passwordField.getText();
		
		
		Construtor construtor = new Construtor(0, email, senha);
		
		DaoConstrutor daoConstrutor = new DaoConstrutor();
		
		try {
			daoConstrutor.inserir(construtor);
			
			clickCancelar();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Atenção");
			alert.setContentText("Erro ao cadastrar: " + e.getMessage());
			alert.show();
		}
	}
	
	public void clickCancelar() throws IOException {
		BorderPane fxml = new FXMLLoader(
				getClass().getResource("/views/TelaInicial.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) raizTelaCadastro.getScene().getWindow();
		
		stage.setScene(cena);
	}
	
	
	
}
