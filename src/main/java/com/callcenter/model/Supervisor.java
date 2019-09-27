package com.callcenter.model;

/**
 * 
 * @author SERGIO MURUA
 *
 */
public class Supervisor extends BaseModel {

	/**
	 * Constructor
	 * @param nombre
	 */
	public Supervisor(String nombre) {
		this.setNombre(nombre);
		this.setTipoOperador("Supervisor");
	}
	
}
