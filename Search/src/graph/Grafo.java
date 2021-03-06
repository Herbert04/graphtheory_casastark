package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import graph.IGrafo;
import java.util.Arrays;

public class Grafo implements IGrafo {

	private Set<Vertice> vertices = new HashSet<Vertice>();
	private Set<Aresta> arestas = new HashSet<Aresta>();
	private List<Vertice> visitados;
        private List<Vertice> caminhos = new ArrayList<>();

	Stack<Vertice> pilha = new Stack<Vertice>();

	public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
		this.visitados = new ArrayList<Vertice>();

	}

	// Lista de vertices adjacentes
	@Override
	public Set<Vertice> getAdjacentes(Vertice v) {

		Set<Vertice> adjacentes = new HashSet<Vertice>();

		for (Aresta aresta : this.arestas) {
			if (aresta.getA() == v) {
				adjacentes.add(aresta.getB());
			}
			if (aresta.getB() == v) {
				adjacentes.add(aresta.getA());
			}
		}
		return adjacentes;
	}

	// vertice não visitado
	public Vertice getNaoVisitado() {
		for (Vertice vertice : this.vertices) {
			if (vertice.isVisitado() == false) {
				return vertice;
			}
		}

		return null;
	}

	@Override
	public boolean ehConexo() {

		for (Vertice vertice : this.vertices) {

			if (this.getAdjacentes(vertice).size() >= 1) {

			} else {

				System.out.println("Não é conexo");

				return false;

			}

		}

		System.out.println("É conexo");

		return true;
	}

	@Override
	public void buscaLargura(Vertice v) {
		Queue<Vertice> fila = new PriorityQueue<Vertice>();
		v.setVisitado(true);
		this.visitados.add(v);
		fila.add(v);
		System.out.println(visitados.toString());
		Vertice w;

		while (!fila.isEmpty()) {
			Set<Vertice> adjacentes = getAdjacentes(fila.peek());
			for (Vertice adj : adjacentes) {
				if (adj != null && adj.isVisitado() == false) {
					w = adj;

					buscaProfundidade(w);
					fila.add(w);

				}
			}
			// if(!pilha.isEmpty()) {
			fila.poll();
		}
	}

	public void buscaProfundidade(Vertice v) {
		v.setVisitado(true);
		this.visitados.add(v);
		pilha.push(v);
		System.out.println(visitados.toString());
		Vertice w;

		while (!pilha.isEmpty()) {
			Set<Vertice> adjacentes = getAdjacentes(pilha.lastElement());
			for (Vertice adj : adjacentes) {
				if (adj != null && adj.isVisitado() == false) {
					w = adj;

					buscaProfundidade(w);
					pilha.push(w);

				}
			}
			// if(!pilha.isEmpty()) {
			pilha.pop();
		}
	}
        
        public void Dijkstra (Vertice v, Grafo g){
            String [][] resultado_dijkstra = new String [g.vertices.size()][4];
            int i = 0;
            for (Vertice vertice : g.vertices) {
                if(vertice.getNome().equals(v.getNome())){
                    vertice.setCaminho(0);
                    resultado_dijkstra[i][0] = (String)vertice.getNome();
                    resultado_dijkstra[i][1] = "sim";
                    resultado_dijkstra[i][2] = "0";
                    resultado_dijkstra[i][3] = "-";
                    i++;
                }else{
                    vertice.setCaminho((int) Double.POSITIVE_INFINITY);                            
                    resultado_dijkstra[i][0] = (String)vertice.getNome();
                    resultado_dijkstra[i][1] = "não";
                    resultado_dijkstra[i][2] = Integer.toString(vertice.getCaminho());
                    resultado_dijkstra[i][3] = "-";
                 i++;
                }
            }            
            Set<Vertice> adjacentes = getAdjacentes(v);
                for (Vertice adj : adjacentes) {
                    
                }
            
        
        }
             
        
	@Override 
        
	public String toString() {

		String retorno = "";

		for (Vertice v : vertices) {
			retorno += v.toString() + "[ ";

			Set<Vertice> adjacentes = this.getAdjacentes(v);

			for (Vertice adj : adjacentes) {
				retorno += adj.toString() + " ";
				if (adj.isVisitado()) {
					retorno += "(*) ";
				} else {
					retorno += "( ) ";
				}
			}

			retorno += "]\n";

		}
		

		return retorno;
	}

}
