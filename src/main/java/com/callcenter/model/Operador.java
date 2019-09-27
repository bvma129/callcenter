package com.callcenter.model;

/**
 * 
 * @author SERGIO MURUA
 *
 */
public class Operador extends BaseModel  {

	/**
	 * Constructor
	 * @param nombre
	 */
	public Operador(String nombre){
        this.setNombre(nombre);
        this.setTipoOperador("Operador");
    }
	

	
}
