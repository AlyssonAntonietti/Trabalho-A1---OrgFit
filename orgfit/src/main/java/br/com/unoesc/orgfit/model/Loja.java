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
@Table(name = "loja")
@SequenceGenerator(name = "seq_loja", sequenceName = "seq_loja", allocationSize = 1, initialValue = 1)
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codloj")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loja")
	private Long id;

	@Column(name = "cnploj", precision = 14)
	private BigDecimal cnpj;

	@Column(name = "razsocloj", length = 80)
	private String razaoSocial;

	@Column(name = "nomfanloj", length = 50)
	private String nomeFantasia;

	@Column(name = "numtelloj", precision = 11)
	private BigDecimal telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCnpj() {
		return cnpj;
	}

	public void setCnpj(BigDecimal cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public BigDecimal getTelefone() {
		return telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
