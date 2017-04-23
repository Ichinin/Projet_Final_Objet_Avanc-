package securite;


import java.util.Optional;

import javafx.scene.control.TextInputDialog;



public class ServiceAuthentification {
	
	protected String userName ;
	
	
	
	public boolean isAuthenticated() {	return getUserName() != null; }
		
	 public void authenticated()
	    {
	    	if(!isAuthenticated())
	    	{
	    		TextInputDialog inDialog = new TextInputDialog("");
	    		//inDialog.setTitle("A Text-Input Dialog");
	    		inDialog.setHeaderText("Account Login");
	    		inDialog.setContentText("Username :");
	    		Optional<String> textIn = inDialog.showAndWait();
	    		if (textIn.isPresent()) {
	    			setUserName(textIn.get());
	    			}
	    		else authenticated();

	    	}
	    }
	    public void setUserName(String txt)
	    {
	    	if(txt.equals("")) this.authenticated(); 
	    	else userName = txt;
	    }
	    public String getUserName()
	    {
	    	return userName;
	    }	 

}
