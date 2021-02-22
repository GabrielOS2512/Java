import java.rmi.RemoteException;

//Implementação da Mensagem
public class ImplementoMSG implements Mensagem {  

	
	public void printMsg(String nome) {  
		System.out.println("|----- "+nome+" Finalizou -----|");
		System.out.println("Trabalho  de Sistemas  Distribuídos – Professora  Carla  Lara");  
	}
	public void mensagem(String nome,String a) {  
		   System.out.println(nome +" : " + a);  
	}
	public void conectado(String nome) {  
		   System.out.println("|----- "+nome+" Conectou -----|");  
	}
}