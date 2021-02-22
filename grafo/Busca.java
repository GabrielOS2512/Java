package grafo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Busca {
	Stack<Integer> pilha = new Stack<Integer>();
	Queue<Integer> fila = new LinkedList<>(); 
	public int[] visitados;
	public boolean achado = false;
	
	public void BuscaLargura(int m[][],int tamanho,int buscado){
		int s =0;//Inicio
		boolean conectado=false;
		this.visitados= new int[tamanho];
		System.out.println("|=== Iniciando Busca em Largura ===|");
		visitados[s]=1;
		fila.add(s);
		while(!fila.isEmpty()) {
			int u = fila.remove();
			System.out.println("Entrou:"+(u+1));
			for (int i = s + 1; i < m[s].length; i++) {
	            if (m[u][i] != 0 && visitados[i] == 0) {
	                visitados[i] = 1;
	                fila.add(i);
	                System.out.println("Visitou:"+(i+1));
	                if(i==buscado-1) {
	                	System.out.println("|== Achou o Vertice Buscado : "+(buscado)+" ==|");
	                	this.achado = true;
	                }                
	            }   
			}
			System.out.println("Saiu:"+(u+1));
		}
		for (int v = 0; v < tamanho; v++)
        {
            if (visitados[v] == 1)
            {
                conectado = true;
            } else
            {
                conectado = false;
                break;
            }
        }
		if(!achado)
			System.out.println("Vertice buscado não foi encontrado");
		if (conectado)
            System.out.println("|=== O grafo é Conexo ===|");
        else
        	System.out.println("|=== O grafo é Desconexo ===|");
		System.out.println("|=== Finalizou Busca em Largura ===|");
	}
   
	public void BuscaP(int i, int m[][], boolean[] visitado, int buscado) {
        
	    if(!visitado[i]) {        
	        visitado[i] = true;
	        System.out.print("("+ (i+1) + ")");     
	        for (int j = 0; j < m[i].length; j++) {
	            if (m[i][j]==1 && !visitado[j]) {   
	            	BuscaP(j, m, visitado, buscado);
	            }
	        }
	    }
	    if(i+1==buscado) {
        	System.out.print("{Vertice Buscado Encontrado}");
        	this.achado = true;
        }
	}
	
	public void Prof(int m[][],int tamanho,int buscado) {
	    boolean [] visitado = new boolean[10];
	    int componente = 0;
	    for(int i = 0; i < tamanho; i++) {
	        if(!visitado[i]) {
	        	componente++;
	            System.out.println("\n|== Componente "+(componente)+" ==|" );
	            System.out.print("[" );
	            BuscaP(i,m,visitado,buscado);           
	            System.out.print("]" );
	        }
	    }
	    
	    System.out.println("\n|== Total de Componentes no Grafo :  " + componente +" ==|");
	    if(!achado)
			System.out.println("{Vertice buscado não foi encontrado}");
	    if (componente <=1) 
            System.out.println("|=== O grafo é Conexo ===|");
        else
        	System.out.println("|=== O grafo é Desconexo ===|");
	    
		System.out.println("|=== Finalizou Busca em Profundidade ===|");
	}
	
	public void BuscaProfundidade2(int m[][],int tamanho,int buscado) {
		int s = 0;//Vertice inicio(raiz)
		System.out.println("|=== Iniciando Busca em Profundidade ===|");
		this.visitados= new int[tamanho];
		visitados[s]=1;
		pilha.add(s);
		while(!pilha.isEmpty()) {
			int u = (int) pilha.pop();
			System.out.println("Entrou em :"+(u+1));
			for (int i = s; i < tamanho; i++) {
	            if (m[u][i] != 0 && visitados[i] == 0) {
	                visitados[i] = 1;
	                pilha.add(i);
	                System.out.println("Visitou:"+(i+1));
	                if(i==buscado) {
	                	System.out.println("|== Achou o Vertice Buscado : "+(buscado)+" ==|");
	                	this.achado = true;
	                }
	            }
			}
			
		}
		if(!achado)
			System.out.println("{Vertice buscado não foi encontrado}");
		System.out.println("|=== Finalizou Busca em Profundidade ===|");
	}
}
