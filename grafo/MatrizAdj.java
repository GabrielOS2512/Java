package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrizAdj {
	int matriz[][];//matriz principal
	int matrizpeso[][];//matriz com pesos de arestas
	int matrizcomp[][];//matriz complementar
	int n_vertice;int buscado=0;
	boolean completo = true;
	
	public void Arquivo(String arquivo) throws IOException {
		//try {
			FileReader fr = new FileReader(arquivo);
		    BufferedReader br = new BufferedReader(fr);
		    Scanner sc = new Scanner(System.in);
		    
		    String texto = br.readLine();
		    
		    String linha1[] = texto.split(" ");
		    //System.out.println("Numero de Vertices : "+linha1[0]);
		    n_vertice = Integer.parseInt(linha1[0]);
		    
		    //System.out.println("Numero de Arestas : "+linha1[1]);
		    int n_aresta = Integer.parseInt(linha1[1]);
		    
		    this.matriz = new int[n_vertice][n_vertice];
		    this.matrizcomp = new int[n_vertice][n_vertice];
		    this.matrizpeso = new int[n_vertice][n_vertice];
		    int buscar;
		    
		    for (int i = 0; i < this.n_vertice; i++) {
		        for (int j = 0; j < this.n_vertice; j++)
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
	               // System.out.println("Vertice 2 : "+linha2[1]);              
	                int destino = Integer.parseInt(linha2[1]);
	                //System.out.println("Peso : "+linha2[2]);
	                int peso = Integer.parseInt(linha2[2]);    
	                
	            	Vertice v1 = new Vertice(origem);
	            	Vertice v2 = new Vertice(destino);    
	            	
	            	Aresta aresta = new Aresta(f,v1,v2,peso);
	            	matrizadj(v1,v2,n_vertice,peso);
	        	
	            	}                                             
	               f++;
		    	}  
		    br.close();
		    Busca b = new Busca();
		    Algoritimos algo = new Algoritimos();
		    print();
					
		    System.out.println("|== {1}-Busca em Profundidade {2}-Busca em Largura {3}-Dijkstra {4}-Euleriano {5}-Ordenação Topologica==|");
			int opcao =2;
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1://Busca Prof
				System.out.println("|=== Insira o vertice a ser buscado ===|");
				buscar = sc.nextInt();
				System.out.println("|=== Iniciando Busca em Profundidade ===|");
				b.Prof(matriz, n_vertice, buscar);
				break;
			case 2://Busca Largura
				System.out.println("|=== Insira o vertice a ser buscado ===|");
				buscar = sc.nextInt();
				System.out.println("|=== Iniciando Busca em Largura ===|");
				b.BuscaLargura(matriz, n_vertice,buscar);
				//b.bfs(matriz, 0);
				break;
			case 3://Dijkstra
				System.out.println("|=== Insira o Vertice ===|");
				buscar = sc.nextInt();
				if(buscar>n_vertice)
					System.out.println("|=== Vertice Não Disponivel ===|");
				else
					algo.Dijkstra(matrizpeso, n_vertice, buscar);
				break;
			case 4://Fleury
				boolean euler = algo.Euleriano(matriz, n_vertice);
				if(euler)//se e euleriano executa fleury
					algo.Fleury(matriz, n_vertice, 0);
				break;
			case 5://OrdTopo
				algo.OrdTopo(matriz, n_vertice);
				break;
			}	
			
			sc.close();
		//}
	    //catch (Exception E) 
        //{
        //    System.out.println("Error");
        //}		
	}
	
	public void matrizadj(Vertice v1,Vertice v2,int tamanho, int peso) {
		int vert1,vert2;
		vert1 = v1.id;vert2=v2.id;
		for(int i=1;i<=n_vertice+1 ;i++)//Origem
		{
			for(int j=1;j<=n_vertice+1 ;j++)
			{		
				if(i==vert1)
				{
					if(j==vert2)
					{
						this.matrizpeso[i-1][j-1]=peso;//matriz com o peso
						this.matriz[i-1][j-1]=1;//matriz com 1
						this.matrizcomp[i-1][j-1]=1;//matriz complemento
					}
				}	
			}			
		}	
		for(int i=1;i<=n_vertice+1 ;i++)//Destino
		{
			for(int j=1;j<=n_vertice+1 ;j++)
			{		
				if(j==vert1)
				{
					if(i==vert2)
					{
						this.matrizpeso[i-1][j-1]=peso;
						this.matriz[i-1][j-1]=1;
						this.matrizcomp[i-1][j-1]=1;
					}
				}	
			}			
		}	
	}
	
	public boolean completo() {
		completo = true;
		for (int i = 0; i < this.n_vertice; i++) { 
		      for (int j = 0; j < this.n_vertice; j++) {
		    	  if(i!=j)
		    		  if(matriz[i][j]==0)
		    			  completo=false;
		      }
		}
		return completo;
	}
	
	public void completar() {
		
		for(int i=0;i<n_vertice ;i++)
		{
			for(int j=0;j<n_vertice ;j++)
			{	
				if(matrizcomp[i][j]==0)
					matrizcomp[i][j]=1;
				else
					matrizcomp[i][j]=0;		
			}			
		}
		System.out.println ("|=== Imprimindo o Complemento da Matriz de Adjacencia ===|");
	    System.out.print ("   ");
	    for (int i = 0; i < this.n_vertice; i++) 
	      System.out.print (i+1 + "   ");
	    System.out.println ();
	    for (int i = 0; i < this.n_vertice; i++) { 
	      System.out.print (i+1 + "  ");
	      for (int j = 0; j < this.n_vertice; j++)
	        System.out.print (this.matrizcomp[i][j] + "   ");
	      System.out.println ();
	      }
	}
	
	public void print() {
		System.out.println("|=== Imprimindo Matriz de Adjacencia ===|");
	    System.out.print("   ");
	    for (int i = 0; i < this.n_vertice; i++) 
	      System.out.print(i+1 + "   ");
	    System.out.println();
	    for (int i = 0; i < this.n_vertice; i++) { 
	      System.out.print(i+1 + "  ");
	      for (int j = 0; j < this.n_vertice; j++)
	        System.out.print(this.matrizpeso[i][j] + "   ");
	      System.out.println();
	    }     
	}

}
