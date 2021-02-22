package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertice {
	
	public int id;
	public String cor;
	public boolean visitado;
	private ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
	
	public Vertice(int n) {
		id = n;
		this.visitado=false;
	}
	
	public Vertice(int n, String v_cor) {
		this.id = n;
		this.cor = v_cor;
		this.visitado=false;
	}
	
	public String getCor() {
		return cor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCor(String p_cor) {
		cor = p_cor;
	}
	
	public void setVisitado() {
		this.visitado = true;	
	}
	
	public void removeVisitado() {
		this.visitado = false;	
	}
	
	public Boolean getVisitado() {
		return visitado;	
	}
	
	public void addVizinhos(Vertice vizinho) {
		this.vizinhos.add(vizinho);
	}

	public ArrayList<Vertice> getVizinhos() {
		return vizinhos;
	}
	
	public boolean isVizinho(Vertice vizinho){
		int i;
		
		for (i=0; i<this.vizinhos.size() ; i++)
			if (this.vizinhos.get(i).getId()==vizinho.getId()) {
				System.out.println("E");
				return true;
			}
		System.out.println("N");
		return false;
	}
	
	public String toString() {
		return "ID: " + id;
	}

}
