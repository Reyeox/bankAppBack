package com.bco.bankApp.model;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "movements")
public class Movement {
	
	@Column(name = "id")
	private Long id;
	
	@Id
	@Column(name="movementId")
	private Long movementId;

	@Column(name = "tipo_cuenta")
    private String tipoCuenta;
    
    @Column(name = "saldo_inicial")
    private String saldoInicial;
    
    @Column(name = "clientId")
    private String clientId;
    
    @Column(name = "numero_cuenta")
    private Long numeroCuenta;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "movimiento")
    private Long movimiento;
    
    @Column(name = "saldo_disponible")
    private Long saldoDisponible;
    
    @Column(name="createDate")
    private Date createDate;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Long movimiento) {
		this.movimiento = movimiento;
	}

	public Long getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Long saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
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
    
	public Long getMovementId() {
		return movementId;
	}

	public void setMovementId(Long movementId) {
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
