package animator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Automato {
	public ArrayList<String> Estados;
	public ArrayList<String> EstadosIniciais;
	public ArrayList<String> EstadosFinais;
	public Map<String, String> Transicoes;
	public String EstadoAtual;

	public void AFD(String[] linha1, ArrayList<String> transicao1, String palavra) {
		Stack<Character> word = new Stack<>();
		char[] ch = palavra.toCharArray();
        for (int i = 0; i < palavra.length(); i++) {
        	word.push(ch[i]);
        }
        for(int i = 0; i < palavra.length(); i++) {
        	ch[i] = word.pop();
        }
        palavra = String.valueOf(ch);
        for (int i = 0; i < palavra.length(); i++) {
        	word.push(ch[i]);
        }

		this.Estados = new ArrayList<String>();
		this.EstadosIniciais = new ArrayList<String>();
		this.EstadosFinais = new ArrayList<String>();
		ArrayList<String> trformato = new ArrayList<String>();
		String t;String[] t1;
		
		String i = linha1[0];String f = linha1[1];
		String[] iniciais = i.split(" "); String[] finais = f.split(" ");
		//Estados
		for(int x=0;x<iniciais.length; x++) {
			EstadosIniciais.add(iniciais[x]);
			Estados.add(iniciais[x]);
		}
		for(int x=1;x<finais.length; x++) {
			EstadosFinais.add(finais[x]);
			Estados.add(finais[x]);
		}
		for(int x=0;x<transicao1.size();x++) {
			t = transicao1.get(x);
			t = t.replace(">", "");t = t.replace("  ", " ");
			t1 = t.split(" ");
			if (!(Estados.contains(t1[0]))) {
				Estados.add(t1[0]);
			}
			if(!(Estados.contains(t1[2]))) {
				Estados.add(t1[2]);
			}
		}
		
		//System.out.println(EstadosFinais);
		montarTransicao(transicao1);
		executar(word);
	}
	
	public void montarTransicao(ArrayList<String> transicao1) {
		this.Transicoes = new HashMap<String, String>();
		String t;String[] t1;String s;
		for(int x=0;x<transicao1.size();x++) {
			t = transicao1.get(x);
			t = t.replace(">", "");t = t.replace("  ", " ");
			t1 = t.split(" ");
			s = t1[0]+":"+t1[1];
			Transicoes.put(s, t1[2]);
		}
		//System.out.println(Transicoes);
		//System.out.println(Transicoes.get("s2:b"));
	}
	
	public void executar(Stack<Character> word) {
		Character c;String transicao;
		if(EstadosIniciais.size() == 1) {
			this.EstadoAtual = EstadosIniciais.get(0);
			System.out.println("|--- Estado Inicial: " +EstadoAtual +" ---|");
			while(!word.isEmpty()) {
				c = word.pop();
				transicao = EstadoAtual+":"+c;
				//System.out.println("Estado Atual: " +EstadoAtual);
				//System.out.println("Char Lido:"+c);
				//System.out.println("Estado Destino: " +Transicoes.get(transicao));
				printTransicao(EstadoAtual,c,Transicoes.get(transicao));
				EstadoAtual = Transicoes.get(transicao);
				System.out.println("-------------------------------------------------------");
			}
			System.out.println("|--- Leu toda a palavra ---|");
			System.out.println("|---    Estado: (" +EstadoAtual +")    ---|");
			if(word.isEmpty() && EstadosFinais.contains(EstadoAtual)){
				System.out.println("|---   Palavra Aceita   ---|");
			} else {
				System.out.println("|--- Palavra Rejeitada ---|");
			}
		} else {
			
		}
	}
	
	public void printTransicao(String e1, Character c, String e2) {
		System.out.println("{ ESTADO ATUAL: " + e1 + "| CHAR LIDO: " + c + "| DESTINO-> " + e2 +" }");
	}


}
