package br.com.renantorres.dominio;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

//fala que esta classe está contida em outra
@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo;
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	

}
