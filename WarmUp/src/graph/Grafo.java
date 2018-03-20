package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;


import graph.interfaces.IGrafo;
import sun.security.util.Length;


public class Grafo implements IGrafo {

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();
	private List<Vertice> visitados;

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
		this.visitados = new ArrayList<Vertice>();

    }

    // completo
    @Override
    public boolean ehCompleto() {
        
            for(Vertice vertice: this.vertices){
                if(this.getAdjacentes(vertice).size() == this.vertices.size() -1){
                    return true;
                }
            }
      return false; 

    }
        
      // Lista de vertices adjacentes
    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        
        Set<Vertice> adjacentes = new HashSet<Vertice>();
        
           for (Aresta aresta: this.arestas) {
                if(aresta.getA() == v){
                    adjacentes.add(aresta.getB());
                }
                if(aresta.getB() == v){
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

	// conexo
    @Override
    public boolean ehConexo() {
		
        for (Vertice vertice : vertices) {
            vertice.setVisitado(false);
	}
                
        Vertice v = this.getNaoVisitado();
        int conexo =0;
		
        while (v != null) {
            v = getNaoVisitado();
		conexo++;
	}
	if(conexo%2==0){ // falta	
            System.out.println("O grafo é conexo");
                    return true;
        }
        return false; 
    }

	// Regular
    @Override
    public boolean ehRegular() {
                /* professor
        Vertice[] vertices_array = vertices.toArray(new Vertice[0]);
        for(int i = 0; i < vertices_array.length; i++) {
           System.out.print(vertices_array[i]);
        }
        */
        int tamanho, cont=0;
        int aux = -1; 
        for(Vertice vertice: this.vertices){
           tamanho = getAdjacentes(vertice).size();
            if(tamanho > aux){
                aux = tamanho;
                cont++;
            }
        }
       if(cont>=2)
           return false; 
        return true;
    }

    @Override
    public String toString() {

        String retorno = "";

        for(Vertice v: vertices) {
            retorno += v.toString() + "[ ";

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for(Vertice adj: adjacentes) {
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
