package com.bco.bankApp.model;


import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

	


	@Column(name = "id")
	private Long id;

	@Id
    @Column(name = "numero_cuenta")
    private Long numeroCuenta;

	@Column(name = "tipo_cuenta")
    private String tipoCuenta;
    
    @Column(name = "saldo_inicial")
    private String saldoInicial;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name="client_id")
    private String clientId;
    
	public Account(Long id,Long numerocuenta, String tipoCuenta, String saldoInicial, boolean estado, String clientId) {
		// TODO Auto-generated constructor stub
		this.numeroCuenta = numerocuenta;
		this.id = id;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.clientId = clientId;
		
	}
	public Account() {}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(String saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
    

    // otros atributos y getters/setters
}
