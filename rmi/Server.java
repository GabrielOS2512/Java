
        
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class Server extends ImplementoMSG { //Servidor
   public Server() {} 
   public static void main(String args[]) { 
      try { 
         // Instanciar classe de implementacao 
    	  ImplementoMSG obj = new ImplementoMSG(); 

         // Exporta objeto da classe de implementacoa
         Mensagem stub = (Mensagem) UnicastRemoteObject.exportObject(obj, 0);  
                  
         // rmiregistry 
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("Mensagem", stub);  
         System.err.println("|------- Server Pronto -------|"); 
         
         

      } catch (Exception e) { 
         System.err.println("Erro no Server: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 