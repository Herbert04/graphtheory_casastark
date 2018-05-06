/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


import graph.Vertice;

import java.util.Set;

public interface IGrafo {

	// Retorna um conjunto com todos os adjancetes de um vértice
	public Set<Vertice> getAdjacentes(Vertice v);

	// Retorna True se o grafo é Conexo e False caso contrário
	public boolean ehConexo();

	// Executa a busca em Largura
	public void buscaLargura(Vertice v);

	// Executa a busca em profundidade
	public void buscaProfundidade(Vertice v);

	/*
	 Retorna uma string que representa o grafo na forma:
	  v2 [ v1 v3 ] 
	  v1 [ v2 v3 ] 
	  v3 [ v2 v1 ] 
	  Por exemplo, nesse caso V2 é adjacente a v1 e v3.
	 */
	public String toString();

}