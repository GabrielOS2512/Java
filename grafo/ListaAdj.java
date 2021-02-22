package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListaAdj {
	
	private Map<Integer, List<Integer>> ListaAdj;
	private HashSet<Aresta> g_Aresta = new HashSet<Aresta>();
	 
    public ListaAdj(int v) 
    {
        ListaAdj = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= v; i++)
            ListaAdj.put(i, new LinkedList<Integer>());
    }
 
    public void setEdge(int destino, int origem) 
    {
        if (destino > ListaAdj.size() || origem > ListaAdj.size())
            System.out.println("Não exite o vertice");
 
        List<Integer> sls = ListaAdj.get(destino);
        sls.add(origem);
        List<Integer> dls = ListaAdj.get(origem);
        dls.add(destino);
    }
 
    public List<Integer> getEdge(int destino) 
    {
        if (destino > ListaAdj.size()) 
        {
            System.out.println("Não exite o vertice");
            return null;
        }
        return ListaAdj.get(destino);
    }
 
    public void Lista(String arquivo) throws IOException
    {
        try 
        {
        	String cor = "";
    		FileReader fr = new FileReader(arquivo);
    	    BufferedReader br = new BufferedReader(fr);
    	     
    	    String texto = br.readLine();
    	    
    	    String linha1[] = texto.split(" ");
    	    //System.out.println("Numero de Vertices : "+linha1[0]);
    	    int n_vertice = Integer.parseInt(linha1[0]);
    	    
    	    //System.out.println("Numero de Arestas : "+linha1[1]);
    	    int n_aresta = Integer.parseInt(linha1[1]);
    	    
    	    //System.out.println("Dados do Grafo :");
    	   	ListaAdj lista = new ListaAdj(n_vertice);
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
                   // System.out.println("Vertice 1 : "+linha2[0]);
                    int origem = Integer.parseInt(linha2[0]);                
                    //System.out.println("Vertice 2 : "+linha2[1]);              
                    int destino = Integer.parseInt(linha2[1]);
                  //System.out.println("Peso : "+linha2[2]);
                    int peso = Integer.parseInt(linha2[2]);   
                    
                    Vertice v1 = new Vertice(origem);
                	Vertice v2 = new Vertice(destino);
                	
                	Aresta aresta = new Aresta(f,v1,v2,peso);
            	    addAresta(aresta);
                       
                    lista.setEdge(destino, origem);
                   f++;
    	    	}  
    		
    	    }	
    	    System.out.println("|=== Imprimindo Lista de Adjacencia ===|");
   		 
            for (int i = 1; i <= n_vertice; i++) 
            {
                System.out.print("["+i + "] -> ");
                List<Integer> l_aresta = lista.getEdge(i);
                for (int j = 1;; j++) 
                {
                    if (j != l_aresta.size())
                        System.out.print(l_aresta.get(j - 1) + " -> ");
                    else 
                    {
                        System.out.print(l_aresta.get(j - 1));
                        break;
                    }
                }
                System.out.println();
            }
    	    br.close();
    	    
        } 
       catch (Exception E) 
        {
            System.out.println("Error");
        }
    }
    public void addAresta(Aresta aresta) {	
		g_Aresta.add(aresta);
	}
    
    
}
