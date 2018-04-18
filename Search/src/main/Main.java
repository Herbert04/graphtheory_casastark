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

		Vertice v1 = new Vertice("v1");
		Vertice v2 = new Vertice("v2");
		Vertice v3 = new Vertice("v3");
		Vertice v4 = new Vertice("v4");
		Vertice v5 = new Vertice("v5");
		Vertice v6 = new Vertice("v6");
		Vertice v7 = new Vertice("v7");
		Vertice v8 = new Vertice("v8");

		Aresta aresta1 = new Aresta(v1, v2, 0);
		Aresta aresta2 = new Aresta(v3, v1, 0);
		Aresta aresta3 = new Aresta(v2, v4, 0);
		Aresta aresta4 = new Aresta(v4, v3, 0);
		Aresta aresta5 = new Aresta(v2, v5, 0);
		Aresta aresta6 = new Aresta(v4, v5, 0);
		Aresta aresta7 = new Aresta(v4, v6, 0);
		Aresta aresta8 = new Aresta(v6, v7, 0);
		Aresta aresta9 = new Aresta(v6, v8, 0);
		Aresta aresta10 = new Aresta(v7, v8, 0);

		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		vertices.add(v8);

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

		Grafo grafo = new Grafo(vertices, arestas);

		
		//System.out.println(grafo.getAdjacentes(v3));
		//grafo.buscaProfundidade(v1);
		grafo.buscaLargura(v1);
		//System.out.println(grafo.ehConexo());

	}
}