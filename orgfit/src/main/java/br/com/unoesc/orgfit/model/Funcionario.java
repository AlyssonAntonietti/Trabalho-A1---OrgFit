package br.com.unoesc.orgfit.model;

import java.io.Serializable;
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
@Table(name = "funcionario")
@SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario", allocationSize = 1, initialValue = 1)
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codfun")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
	private Long id;

	@Column(name = "nomfun", length = 40)
	private String nome;

	@Column(name = "numtelfun", length = 11)
	private Long telefone;

	@ManyToOne
	@JoinColumn(name = "codloj")
	private Loja codigoLoja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Loja getCodigoLoja() {
		return codigoLoja;
	}

	public void setCodigoLoja(Loja codigoLoja) {
		this.codigoLoja = codigoLoja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
