package com.callcenter.services.impl;

import java.util.LinkedList;

import com.callcenter.services.LlamadaServices;

/**
 * 
 * @author SERGIO MURUA
 *
 */
public class LlamadaServicesImpl extends Thread implements LlamadaServices{

	Integer idCliente;
	LinkedList<Integer> llamadas;
	
	/**
	 * Cargo los datos de la llamada
	 * @param idCliente
	 * @param llamadas
	 */
	public LlamadaServicesImpl(Integer idCliente, LinkedList<Integer> llamadas) {
		this.idCliente = idCliente;
		this.llamadas = llamadas;
	}
	
	@Override
    public void run() {
		//(int)(Math.random() * ((max - min) + 1)) + min;
        int sleep = (int) (Math.random() * ((10 - 5) + 1)) + 5;

        while(true){
        	//Verifico que el cliente no este en el array de las llamadas
            if(!llamadas.contains(this.idCliente)){
                //Imprimo la llamada del cliente
                System.out.println("El idCliente: "+ this.idCliente +" realiza una llamada");
                llamadas.add(this.idCliente);
                try {
                	//sleep del random entr 5 y 10
                    sleep(sleep * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	
}
