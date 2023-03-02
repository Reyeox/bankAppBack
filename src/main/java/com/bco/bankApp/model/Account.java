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
    private String estado;
    
    @Column(name="client_id")
    private String clientId;
    
	public Account(Long id,Long numerocuenta, String tipoCuenta, String saldoInicial, String estado, String clientId) {
		// TODO Auto-generated constructor stub
		this.numeroCuenta = numerocuenta;
		this.id = id;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.clientId = clientId;
		
	}

	

	public Account(long id2, long numerocuenta2, String tipoCuenta2, String saldoInicial2, String estado2,
			String clientId2) {
		// TODO Auto-generated constructor stub
	}



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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    

    // otros atributos y getters/setters
}
