package com.bco.bankApp.model;


import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="cliente_id")
	    private Long clienteId;
	 
	 	@Column(name="nombre")
	    private String nombre;
	 
	 	@Column(name="direccion")
	    private String direccion;
	 
	 	@Column(name="telefono")
	    private String telefono;
	 

		@Column(name="contrasena")
	    private String contrasena;
	    
	    @Column(name="estado")
	    private Boolean estado;
	    
	   

	    

	    // Getters y Setters
	    public Long getClienteId() {
	        return clienteId;
	    }

	    public void setClienteId(Long clienteId) {
	        this.clienteId = clienteId;
	    }
	    
	    public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setContrasena(String contrasena) {
	        this.contrasena = contrasena;
	    }

	    public Boolean getEstado() {
	        return estado;
	    }

	    public void setEstado(Boolean estado) {
	        this.estado = estado;
	    }
}
