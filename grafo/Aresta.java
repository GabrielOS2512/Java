package grafo;

public class Aresta {

	public int id;
	public Vertice origem;
	public Vertice destino;
	public int peso;
	
	
	public Aresta(int id, Vertice origem, Vertice destino,int peso2) {
		this(id, origem, destino);
		this.peso = peso2;
	}
	
	public Aresta(int a_id, Vertice a_origem, Vertice a_destino) {
		id = a_id;
		origem = a_origem;
		destino = a_destino;
		peso = 0;
	}

	public void setPeso(int peso2) {
		this.peso = peso2;		
	}
	
	public Vertice getOrigem() {
		return origem;
	}
	
	public Vertice getDestino() {
		return destino;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void print() {
		System.out.println("{ ID-Aresta: " + id + " ORIGEM->" + origem + " DESTINO->" + destino + " PESO:" + peso +" }");
	}

}
