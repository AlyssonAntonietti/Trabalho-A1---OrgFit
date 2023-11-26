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
@Table(name = "venda")
@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda", allocationSize = 1, initialValue = 1)
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codven")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venda")
	private Long id;

	@Column(name = "datven")
	@Temporal(TemporalType.DATE)
	private Calendar dataVenda;

	@ManyToOne
	@JoinColumn(name = "codcli")
	private Cliente codigoCliente;

	@ManyToOne
	@JoinColumn(name = "codfun")
	private Funcionario codigoFuncionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Funcionario getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Funcionario codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
