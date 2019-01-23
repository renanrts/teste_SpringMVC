package br.com.renantorres.dominio;

public class Produto {
	
	private String titulo;
	private String descricao;
	private int numeroPags;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumeroPags() {
		return numeroPags;
	}
	public void setNumeroPags(int numeroPags) {
		this.numeroPags = numeroPags;
	}

	 @Override
	    public String toString() {
	        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + numeroPags + "]";
	    }
}
