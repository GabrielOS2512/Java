package grafo;

import java.io.IOException;
import java.util.Scanner;

public class Grafo {
	public static boolean completo;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("|=== Bem-Vindo ===|");
		System.out.println("|=== Insira o nome do arquivo ===|");
		String arquivo = sc.nextLine();
		System.out.println("|=== {1}-Lista Adj {2}-Matriz Adj {3}-Matriz Inc ===|");
		int opcao =1;
		opcao = sc.nextInt();	
		
		switch(opcao) {
		case 1://Lista ADJ
			ListaAdj la = new ListaAdj(0);
			la.Lista(arquivo);
			break;
		case 2://Matriz ADJ
			MatrizAdj ma = new MatrizAdj();
			ma.Arquivo(arquivo);
			completo = ma.completo();
			if(completo) 
				System.out.println("|===  O Grafo é Completo  ===|");
			else {
				System.out.println("|=== O Grafo é Incompleto ===|");
				ma.completar();
			}
			break;
		case 3://Matriz INC
			MatrizInc mi = new MatrizInc();
			mi.Arquivo(arquivo);
			break;
		}	
		sc.close();
		System.out.println("|======= Execução Finalizada =======|");
	}	
	
}
