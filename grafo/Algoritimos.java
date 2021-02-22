package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algoritimos {
	int[] dist;
	String[] pred;
	boolean[] visitado;
	int tamanho;
	List<Integer> ordenacao = new ArrayList<>();
	Queue<Integer> fila = new LinkedList<>(); 
	
	public void Fleury(int m[][], int n_vertice, int u) {
		System.out.println("|=== Iniciando Algoritimo de Fleury ===|");
		int g[][] = new int[n_vertice][n_vertice];
		g=m;
		
	}
	
	public boolean Euleriano(int m[][], int n_vertice) {
		int x=0;
		int[] verificado = new int[n_vertice];
		int soma = 0;
		
		for(int i=0;i<n_vertice ;i++)
		{
			for(int j=0;j<n_vertice ;j++)
			{
				x = m[i][j]+x;
			}
			if(x % 2 == 0) 
				verificado[i] = 1;
			else {
				System.out.println("|=== Não é Euleriano ===|");
				return false;
			}
			for(int a=0;a<n_vertice;a++)
			{	
				soma = soma + verificado[a];
			}
			if(soma == n_vertice) {
				System.out.println("|=== Euleriano ===|");
				return true;
			}
			soma = 0;
		}
		System.out.println("|=== Não é Euleriano ===|");
		return false;
	}
	
	public void Dijkstra(int m[][], int n_vertice, int s) {
		try {
		this.dist = new int[n_vertice];
		this.pred = new String[n_vertice];
		this.visitado = new boolean[n_vertice];
		this.tamanho = n_vertice;
		int u;int inicio = s-1;
		
		for(int i=0;i<n_vertice;i++) {
			dist[i] = 9999; //infinito
			pred[i] = null;
		}
		dist[inicio] = 0;

		
		for (int i = 0; i < tamanho ; i++) {			
			
			u = VerticeMinimo(visitado, dist);
			visitado[u] = true;
			
			
			for(int v=0;v<n_vertice ;v++) {	
				if (m[u][v] != 0) {
					if(dist[v] > (dist[u]+m[u][v])) {
						dist[v]=dist[u]+m[u][v];
						pred[v]=Integer.toString(u);
					}
				}
			}				
		}		
		printDijk();
		}
		catch(ArrayIndexOutOfBoundsException E) {
			System.out.println("Não Foi Possivel Achar um caminho para todos os vertices");
		}
	}
	
	public int VerticeMinimo(boolean [] visita, int [] d){
        int min = 9999;//infinito
        int vertice = -1;
        for (int i = 0; i < tamanho ; i++) {
            if(visita[i]==false && min>d[i]){
                min = d[i];
                vertice = i;
            }
        }
        return vertice;
    }
	
	public void printDijk() {
		System.out.println("|=== Iniciando Algoritimo de Dijkstra ===|");
		System.out.print("Vertices  -> ");
		for(int i=0;i<tamanho ;i++) {
			System.out.print("[" + (i+1) + "]  ");
		}
		System.out.print("\nDistancia -> ");
		for(int i=0;i<tamanho ;i++) {
			System.out.print("[" + dist[i] + "]  ");
		}
		System.out.print("\nPercurso  -> ");
		for(int i=0;i<tamanho ;i++) {
			if(pred[i] == null)
				System.out.print("[-]  ");
			else {
				int p = Integer.parseInt(pred[i]);
				System.out.print("[" + (p+1) + "]  ");
			}
		}
		System.out.println("\n|=== Finalizando Dijkstra ===|");
	}

	public void OrdTopo(int m[][], int n_vertice) {
		int visitar[] = new int[n_vertice];
		this.tamanho = n_vertice;
		
		for(int i = 0; i< tamanho; i++) {
			visitar[i] = 0;
		}
		for(int i = 0; i< tamanho; i++) {
			if(visitar[i] == 0) {
				ProfOrd(i,m,visitar);
			}
		}
		System.out.println("|=== Ordenação Topológica ===|");
		System.out.print("{ "+ordenacao.toString()+" } \n");
	}
	
	public void ProfOrd(int u,int m[][],int visitar[]) {
		visitar[u] = 1;
		
		for(int v=0;v<tamanho ;v++) {
			if(m[u][v] == 1 && visitar[v] == 0) {
				
				ProfOrd(v,m,visitar);
				
			}
		}
		
		ordenacao.add(0,u+1);
	}
	
}
