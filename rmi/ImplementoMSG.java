import java.rmi.RemoteException;

//Implementa��o da Mensagem
public class ImplementoMSG implements Mensagem {  

	
	public void printMsg(String nome) {  
		System.out.println("|----- "+nome+" Finalizou -----|");
		System.out.println("Trabalho  de Sistemas  Distribu�dos � Professora  Carla  Lara");  
	}
	public void mensagem(String nome,String a) {  
		   System.out.println(nome +" : " + a);  
	}
	public void conectado(String nome) {  
		   System.out.println("|----- "+nome+" Conectou -----|");  
	}
}