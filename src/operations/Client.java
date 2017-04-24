package operations;

import banque.CompteBancaire;

public class Client {
	
	protected String codeClient;
	protected String nomClient;
	protected CompteBancaire compte;
	
	public Client(String codeClient, String nomClient) {
		this.codeClient = codeClient;
		this.nomClient = nomClient;
	}

	public String getCodeClient() {
		return codeClient;
		
	}

	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public CompteBancaire getCompte() {
		return compte;
	}

	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Client [codeClient=" + codeClient + ", nomClient=" + nomClient + ", compte=" + compte + "]";
	}
	
	
	

}
