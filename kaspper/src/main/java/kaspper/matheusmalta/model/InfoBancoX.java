package kaspper.matheusmalta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoBancoX implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tpTransacao;
	private int    agencia;
	private int    conta;
	private int    dConta;
	private String favorecido;
	private String cpf;
	private int    vlInteiro;
	private int    vlDecimal;
	private String dtTransacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTpTransacao() {
		return tpTransacao;
	}
	public void setTpTransacao(String tpTransacao) {
		this.tpTransacao = tpTransacao;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getdConta() {
		return dConta;
	}
	public void setdConta(int dConta) {
		this.dConta = dConta;
	}
	public String getFavorecido() {
		return favorecido;
	}
	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getVlInteiro() {
		return vlInteiro;
	}
	public void setVlInteiro(int vlInteiro) {
		this.vlInteiro = vlInteiro;
	}
	public int getVlDecimal() {
		return vlDecimal;
	}
	public void setVlDecimal(int vlDecimal) {
		this.vlDecimal = vlDecimal;
	}
	public String getDtTransacao() {
		return dtTransacao;
	}
	public void setDtTransacao(String dtTransacao) {
		this.dtTransacao = dtTransacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoBancoX other = (InfoBancoX) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
