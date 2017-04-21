package securite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import Application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import securite.ServiceAuthentificationException;

public class ServiceAuthentification {
	public ThreadLocal<String> authenticatedUser = new ThreadLocal<String>();
	@FXML
	protected TextField userNameField;
	@FXML
	protected TextField passWordField;
	private MainApp mainApp;
	private Stage dialogStage;
	
	public void authenticate() {
		if (isAuthenticated()) {
			return;
		}
		String[] userNamePassword = getUserNamePassword();
		if (!userNamePassword[0].equals(userNamePassword[1])) {
			throw new ServiceAuthentificationException("utilisateur/mot de passe incorrect");
		}
		authenticatedUser.set(userNamePassword[0]);
	}
	
	public boolean isAuthenticated() {	return authenticatedUser.get() != null; }
	
	public String[] getUserNamePassword() {
		boolean usePrintln = Boolean.getBoolean("ant.run");
		String[] userNamePassword = new String[2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			if (usePrintln) {
				System.out.println("Nom utilisateur: ");
			} else {
				System.out.print("Nom utilisateur: ");
			}
			userNamePassword[0] = in.readLine().trim();
			if (usePrintln) {
				System.out.println("Mot de passe: ");
			} else {
				System.out.print("Mot de passe: ");
			}
			userNamePassword[1] = in.readLine().trim();
		} catch (IOException ex) {
			// ignoré...
		}
		return userNamePassword;
	}
	/*
	public void cancelHandle()
	{
		userNameField.setText("");
		passWordField.setText("");
	} */
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
	}
	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
}
