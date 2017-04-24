package aspects;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import banque.CompteBancaire;
/*
 * Aspect de journalisation
 * il journalise tous les appels aux méthodes de CompteBancaire
 */

@Aspect
public class LoggerAspect {
	
String logerUser  = AuthentificationAspect.logerUser;
	//logger du retrait
	@Pointcut("execution(* *.CompteBancaire.retrait(double))&& args(montant)")
	public void pcRetrait(double montant){}
	
	@After("pcRetrait(montant)")
	public void logRetrait(double montant, JoinPoint thisjp){
		CompteBancaire cb = (CompteBancaire)thisjp.getTarget();
		addLog("R" , montant, cb.getNumero());	
	}
	//logger depot
		@Pointcut("execution(* *.CompteBancaire.depot(double))&& args(montant)")
		public void pcDepot(double montant){}
		
		@After("pcDepot(montant)")
		public void logDepot(double montant, JoinPoint thisjp){
			CompteBancaire cb = (CompteBancaire)thisjp.getTarget();
			addLog("D" , montant, cb.getNumero());	
		}
		
		
		@After("execution(*.CompteBancaire.new(..))")
		public void logNew(JoinPoint thisjp){
			CompteBancaire cb = (CompteBancaire)thisjp.getTarget();
			addLog("C" , 0, cb.getNumero());	
		}
	void addLog(String operation, double montant, String numero){
		PrintWriter logValidation;
		try {
			logValidation = new PrintWriter(new FileWriter("LoggerApp.txt", true));
			logValidation.println(Calendar.getInstance().getTime() + "|" 
									+ logerUser + "|" 
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
