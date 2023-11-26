package br.com.unoesc.orgfit.model;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mercadoria")
@SequenceGenerator(name = "seq_mercadoria", sequenceName = "seq_mercadoria", allocationSize = 1, initialValue = 1)
public class Mercadoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codmer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mercadoria")
	private Long id;

	@Column(name = "desmer", length = 60)
	private String descricao;

	@Column(name = "valvenmer", precision = 8, scale = 2)
	private BigDecimal valor;

	@Column(name = "quamer")
	private int quantidade;
	
	@Column(name = "codloj")
	private Long loja;
	
//	@ManyToOne
//	@JoinColumn(name = "codloj")
//	private Loja loja;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Long getLoja() {
		return loja;
	}

	public void setLoja(Long loja) {
		this.loja = loja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
