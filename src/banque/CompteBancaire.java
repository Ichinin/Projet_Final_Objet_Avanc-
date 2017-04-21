package banque;

public class CompteBancaire {
	
 protected double solde;
 protected String numero;

 public CompteBancaire(String numero, int solde) {
	super();
	this.numero = numero;
	this.depot(solde);
}

public void depot (double sommeDepot){
	 solde = solde + sommeDepot;
 }

 public void retrait (double sommeRetrait){
	 solde = solde - sommeRetrait;
 }
 
public double getSolde() {
	return solde;
}

public void setSolde(double solde) {
	this.solde = solde;
}

public String getNumero()
{
	return this.numero;
}
 
}
