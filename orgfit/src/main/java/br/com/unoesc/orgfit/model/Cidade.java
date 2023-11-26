package br.com.unoesc.orgfit.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", allocationSize = 1, initialValue = 1)
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codcid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
	private Long id;

	@Column(name = "nomcid", length = 40)
	private String nome;

	@Column(name = "estcid", length = 2)
	private String uf;

	@Column(name = "cepcid", length = 8)
	private Long cep;

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
