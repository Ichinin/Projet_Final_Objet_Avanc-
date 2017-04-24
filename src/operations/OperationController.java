package operations;

import java.util.ArrayList;

import Application.MainApp;
import banque.CompteBancaire;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
/*
 * Class de controle des opérations
 * interface qui appelle les méthodes de CompteBancaire
 * il enregistre la date et l'heure, l'utilisateur, l'opération, le montant et le compte
 */
public class OperationController {
	@FXML
	protected TextField numCompteField;
	@FXML
	protected TextField montantField;
	private MainApp mainApp;
	ArrayList<CompteBancaire> listeCompte = new ArrayList<CompteBancaire>();
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
	}
	public void cancelHandle()
	{
		numCompteField.setText("");
		montantField.setText("");
	}
	
	public void depot()
	{
		if(isValide())
		{
			CompteBancaire monCompte = AddCompte(this.numCompteField.getText());
			
			// 2 : Retrait
			monCompte.depot(Double.parseDouble(this.montantField.getText()));
			infoAlerte("Depot"); 
		}
	}
	public void retrait()
	{
		if(isValide())
		{
			CompteBancaire monCompte = AddCompte(this.numCompteField.getText());
			if(monCompte.getSolde() >= Double.parseDouble(montantField.getText()))
			{
			monCompte.retrait(Double.parseDouble(this.montantField.getText()));
			infoAlerte("Retrait");
			}
			else {showAlerte("Retrait impossible : Solde insuffisant("+ monCompte.getSolde()+")");}
			
		}
	}
	private void showAlerte(String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
        //alert.initOwner(dialogStage);
        alert.setTitle("Invalid Fields");
        alert.setHeaderText("Please correct invalid fields");
        alert.setContentText(message);

        alert.showAndWait();
	}
	
	private void infoAlerte(String message)
	{
		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setContentText(message);
		al.show();
	}
	private boolean isValide()
	{
		if(this.numCompteField.getText().isEmpty() || this.montantField.getText().isEmpty() )
		{	
			showAlerte("champs invalides");
			return false;
		}
		try
		{
			Double.parseDouble(this.montantField.getText());
			return true;
		} catch (NumberFormatException n)
		{
			showAlerte("Montant invalide");
			return false;
		}
		
	}
	public CompteBancaire AddCompte(String numC)
	{	//ajout d'un nouveau compte à la liste 
		for(CompteBancaire compte : listeCompte)
		{
			if(compte.getNumero().equals(numC))
			{
				return compte;	
			}
		}
		
		CompteBancaire cb = new CompteBancaire(numC, 0);
		listeCompte.add(cb);
		return cb;
	}

}
