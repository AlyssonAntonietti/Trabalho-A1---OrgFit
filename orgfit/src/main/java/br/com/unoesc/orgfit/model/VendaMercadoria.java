package br.com.unoesc.orgfit.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda_mercadoria")
@SequenceGenerator(name = "seq_venda_mercadoria", sequenceName = "seq_venda_mercadoria", allocationSize = 1, initialValue = 1)
public class VendaMercadoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codvenmer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venda_mercadoria")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codven")
	private Venda codigoVenda;

	@ManyToOne
	@JoinColumn(name = "codmer")
	private Mercadoria codigoMercadoria;

	@Column(name = "valmerven", precision = 8, scale = 2)
	private BigDecimal valor;

	@Column(name = "quamerven")
	private int quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venda getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Venda codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Mercadoria getCodigoMercadoria() {
		return codigoMercadoria;
	}

	public void setCodigoMercadoria(Mercadoria codigoMercadoria) {
		this.codigoMercadoria = codigoMercadoria;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
