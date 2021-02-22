package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class MatrizInc {
	
	private HashSet<Aresta> g_Aresta = new HashSet<Aresta>();
	protected boolean direcao;	
	int matriz[][];int matrizb[][];
	int n_vertice;
	int n_aresta;
	boolean completo = true;
	
	public void Arquivo(String arquivo) throws IOException {
		try {
		String cor = "";
		FileReader fr = new FileReader(arquivo);
	    BufferedReader br = new BufferedReader(fr);
	     
	    String texto = br.readLine();
	    
	    String linha1[] = texto.split(" ");
	    //System.out.println("Numero de Vertices : "+linha1[0]);
	    n_vertice = Integer.parseInt(linha1[0]);
	    
	    //System.out.println("Numero de Arestas : "+linha1[1]);
	    n_aresta = Integer.parseInt(linha1[1]);
	    
	    this.matriz = new int[n_vertice][n_aresta];
	    this.matrizb = new int[n_vertice][n_aresta];
	    for (int i = 0; i < this.n_vertice; i++) {
	        for (int j = 0; j < this.n_aresta; j++)
	        	this.matriz[i][j] = 0;
	    }
	    
	    
	    int f=1;
	    while (f <= n_aresta) {
	    	if(texto.contentEquals("fim"))
	    	{
	    		break;
	    	}
	    	else {
	    		texto = br.readLine();
	    		//System.out.println(texto);
	    		
	    		String linha2[] = texto.split(" ");
                //System.out.println("Vertice 1 : "+linha2[0]);
                int origem = Integer.parseInt(linha2[0]);                
                //System.out.println("Vertice 2 : "+linha2[1]);              
                int destino = Integer.parseInt(linha2[1]);
                //System.out.println("Peso : "+linha2[2]);
                int peso = Integer.parseInt(linha2[2]);    
                
            	Vertice v1 = new Vertice(origem);
            	Vertice v2 = new Vertice(destino);
            	
            	Aresta aresta = new Aresta(f,v1,v2,peso);
        	    addAresta(aresta);
            	
            	matrizinc(v1,aresta,n_vertice,n_aresta);
            	}                                             
               f++;
	    	}  
	    br.close();
	    print();
		}
	    catch (Exception E) 
        {
            System.out.println("Error");
        }
	}
	
	public void addAresta(Aresta aresta) {	
		g_Aresta.add(aresta);
	}
	
	public void matrizinc(Vertice v,Aresta a,int n_vert,int n_aresta) {
		for(int i=1;i<=n_vertice;i++)
		{
			for(int j=1;j<=n_aresta ;j++)
			{		
				if(j==a.id)
					if(i==a.destino.id)
					{
						this.matriz[i-1][j-1]=1;
					}			
			}			
		}	
		for(int i=1;i<=n_vertice;i++)
		{
			for(int j=1;j<=n_aresta;j++)
			{		
				if(j==a.id)
					if(i==a.origem.id)
					{
						this.matriz[i-1][j-1]=1;
					}	
			}			
		}	
	}	
	
	public void print() {
		System.out.println ("|=== Imprimindo Matriz de Incidencia ===|");
	    System.out.print ("   ");
	    for (int i = 0; i < this.n_aresta; i++) 
	      System.out.print (i+1 + "   ");
	    System.out.println ();
	    for (int i = 0; i < this.n_vertice; i++) { 
	      System.out.print (i+1 + "  ");
	      for (int j = 0; j < this.n_aresta; j++)
	        System.out.print (this.matriz[i][j] + "   ");
	      System.out.println ();
	    }
	}
}
