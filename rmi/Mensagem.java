import java.rmi.Remote; 
import java.rmi.RemoteException;  

public interface Mensagem extends Remote { //Interface Remota 
   void printMsg(String nome) throws RemoteException;  //nome desconectado + Mensagem Final
   void mensagem(String nome,String a) throws RemoteException; //nome + msg
   void conectado(String nome) throws RemoteException; // nome conectado
} 