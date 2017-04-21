package aspects;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;


import Application.MainApp;
import banque.*;
import securite.ServiceAuthentification;

public aspect LogAspect { 

	private ServiceAuthentification authenticator = new ServiceAuthentification();
	MainApp mainapp;;

	pointcut secureAccess() : execution(* CompteBancaire.*(..));
	pointcut constructeur(String num, double solde) : call(CompteBancaire.new(String, double)) && args(num, solde);
	pointcut logRetrait(double somme) : call(* CompteBancaire.retrait(double))&& args(somme);
	pointcut logDepot(double somme) : execution(* CompteBancaire.depot(double))&& args(somme);
	

	before() : secureAccess() {
		//System.out.println("Authentification de l'utilisateur :");
		authenticator.authenticate();
		//System.out.println("yes");
		//mainapp.showPersonEditDialog();
		}
	
before(String num, double solde) : constructeur(num, solde)
{
	//authenticator.authenticate();
	//mainapp.showAuthentification();
	addLog("C" , 0, num);
}



after(double somme) : logRetrait(somme) { 
//System.out.println(authenticator.authenticatedUser.get());
CompteBancaire cb = (CompteBancaire)thisJoinPoint.getTarget();
addLog("R" , somme, cb.getNumero());
} 
after(double somme) : logDepot(somme) { 
//System.out.println(authenticator.authenticatedUser.get());
CompteBancaire cb = (CompteBancaire)thisJoinPoint.getTarget();
addLog("D" , somme, cb.getNumero());

} 

void addLog(String operation, double montant, String numero){
	PrintWriter logValidation;
	try {
		logValidation = new PrintWriter(new FileWriter("LogValidation.txt", true));
		logValidation.println(Calendar.getInstance().getTime() + "|" 
								+ authenticator.authenticatedUser.get() + "|" 
								+ operation + "|"
								+ montant + "|"
								+ numero
								);
		
		
		logValidation.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

}
}