package graph;

public class Vertice implements Comparable<Vertice> {

    private String nome;
	private boolean visitado;

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.getNome();
    }
	
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean isVisitado() {
		return this.visitado;
	}

    public int compareTo(Vertice vertice) {
        return this.getNome().compareTo(vertice.getNome());
    }

}
