package kaspper.matheusmalta.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoBancoY implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String cpf;
	private String favorecido;
	private int agencia;
	private int conta;
	private double vlDecimal;
	private String tpTransacao;
	private String dtTransacao;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFavorecido() {
		return favorecido;
	}
	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
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
	public double getVlDecimal() {
		return vlDecimal;
	}
	public void setVlDecimal(int vlDecimal) {
		this.vlDecimal = vlDecimal;
	}
	public String getTpTransacao() {
		return tpTransacao;
	}
	public void setTpTransacao(String tpTransacao) {
		this.tpTransacao = tpTransacao;
	}
	public String getDtTransacao() {
		return dtTransacao;
	}
	public void setDtTransacao(String dtTransacao) {
		this.dtTransacao = dtTransacao;
	}
	
	public void setInfoBancoY(InfoBancoX ibx) {
		
		this.cpf = ibx.getCpf();
		this.favorecido = ibx.getFavorecido();
		this.agencia = ibx.getAgencia();
		this.conta = ibx.getConta() + ibx.getdConta();
		this.vlDecimal = ibx.getVlInteiro()+(ibx.getVlDecimal()/100);
		this.tpTransacao = ibx.getTpTransacao();
		this.dtTransacao = ibx.getDtTransacao().substring(0, 4) + ibx.getDtTransacao().substring(6, 8);
		
	}

}
