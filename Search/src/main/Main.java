package main;

import graph.Aresta;
import graph.Grafo;
import graph.Vertice;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<Vertice> vertices = new HashSet<Vertice>();
		Set<Aresta> arestas = new HashSet<Aresta>();

		Vertice A = new Vertice("A");
		Vertice B = new Vertice("B");
		Vertice C = new Vertice("C");
		Vertice D = new Vertice("D");
		Vertice E = new Vertice("E");
		Vertice F = new Vertice("F");
		Vertice G = new Vertice("G");
		

		Aresta aresta1 = new Aresta(A, B, 7);
		Aresta aresta2 = new Aresta(A, D, 5);
		Aresta aresta3 = new Aresta(B, C, 8);
		Aresta aresta4 = new Aresta(B, E, 7);
		Aresta aresta5 = new Aresta(B, D, 9);
		Aresta aresta6 = new Aresta(C, E, 5);
		Aresta aresta7 = new Aresta(E, F, 8);
		Aresta aresta8 = new Aresta(E, G, 9);
		Aresta aresta9 = new Aresta(E, D, 15);
		Aresta aresta10 = new Aresta(F, G, 11);
                Aresta aresta11 = new Aresta(F, D, 6);
               
		vertices.add(A);
		vertices.add(B);
		vertices.add(C);
		vertices.add(D);
		vertices.add(E);
		vertices.add(F);
		vertices.add(G);
		

		arestas.add(aresta1);
		arestas.add(aresta2);
		arestas.add(aresta3);
		arestas.add(aresta4);
		arestas.add(aresta5);
		arestas.add(aresta6);
		arestas.add(aresta7);
		arestas.add(aresta8);
		arestas.add(aresta9);
		arestas.add(aresta10);
                arestas.add(aresta11);

		Grafo grafo = new Grafo(vertices, arestas);

		
		//System.out.println(grafo.getAdjacentes(v3));
		//grafo.buscaProfundidade(v1);
		//grafo.buscaLargura(A);
                grafo.Dijkstra(D, grafo);
		//System.out.println(grafo.ehConexo());

	}
}