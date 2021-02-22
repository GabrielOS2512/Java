

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.util.Scanner;

public class Client {  //Cliente
   private Client() {}  
   public static void main(String[] args) {  
      try {  
    	  Scanner sc = new Scanner(System.in);
    	  String nome;
    	  
          // Recebe o registry 
          Registry registry = LocateRegistry.getRegistry(null); 
     
          // Procura no registry o obj remoto
          Mensagem stub = (Mensagem) registry.lookup("Mensagem"); 
          
          System.out.println("|-------- Insira seu nome --------|");//nome
          nome = sc.nextLine();         
          stub.conectado(nome);//Informa ao Servidor que o cliente conectou
          
    	  String a;String x="";
    	  while(!x.contentEquals("FIM")) {    	  
	    	  System.out.println("|-------- Informe a Mensagem ou FIM para parar --------|");
	    	  a = sc.nextLine();
			  stub.mensagem(nome,a);//envia mensagem
	    	  x = a;
    	  }
    	  
         stub.printMsg(nome);//envia final       
         sc.close();
         
      } catch (Exception e) {
         System.err.println("Erro no Cliente : " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}