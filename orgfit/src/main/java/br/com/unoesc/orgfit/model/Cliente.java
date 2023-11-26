package br.com.unoesc.orgfit.model;

import java.io.Serializable;
import java.util.Calendar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1, initialValue = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codcli")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	private Long id;

	@Column(name = "nomcli", length = 50)
	private String nome;

	@Column(name = "cpfcli", length = 11)
	private Long cpf;

	@Column(name = "datnascli")
	@Temporal(TemporalType.DATE)
	private Calendar dataDeNascimento;

	@Column(name = "numtelcli", length = 11)
	private Long telefone;

	@ManyToOne
	@JoinColumn(name = "codcid")
	private Cidade codigoCidade;

	@Column(name = "sexcli", length = 1)
	private String sexo;

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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Cidade getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Cidade codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
