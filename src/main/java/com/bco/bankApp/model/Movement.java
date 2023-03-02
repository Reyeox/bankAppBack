package com.bco.bankApp.model;


import javax.persistence.*;

@Entity
@Table(name = "movements")
public class Movement {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movementId")
	private Number movementId;

	@Column(name = "tipo_cuenta")
    private String tipoCuenta;
    
    @Column(name = "saldo_inicial")
    private String saldoInicial;
    
    @Column(name = "clientId")
    private String clientId;
    
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "movimiento")
    private String movimiento;
    
    @Column(name = "saldo_disponible")
    private String saldoDisponible;

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public String getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(String saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
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
    
	public Number getMovementId() {
		return movementId;
	}

	public void setMovementId(Number movementId) {
		this.movementId = movementId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

    // otros atributos y getters/setters
   
}
