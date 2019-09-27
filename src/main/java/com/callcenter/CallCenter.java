package com.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.callcenter.model.Director;
import com.callcenter.model.Operador;
import com.callcenter.model.Supervisor;
import com.callcenter.services.impl.LlamadaServicesImpl;


public class CallCenter {

	private List<Director> directores = new ArrayList<Director>();
	private List<Supervisor> supervisores = new ArrayList<Supervisor>();
    private List<Operador> operadores = new ArrayList<Operador>();
    private LinkedList<Integer> llamadas=new LinkedList<Integer>();
    private int cantidadMaximaLlamadas;
	
    public LinkedList<Integer> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(LinkedList<Integer> llamadas) {
		this.llamadas = llamadas;
	}

    public List<Director> getDirectores() {
		return directores;
	}

	public void setDirectores(List<Director> directores) {
		this.directores = directores;
	}

	public List<Supervisor> getSupervisores() {
		return supervisores;
	}

	public void setSupervisores(List<Supervisor> supervisores) {
		this.supervisores = supervisores;
	}

	public List<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}
    
    public CallCenter(int cantidadMaximaLlamadas) {
    	this.cantidadMaximaLlamadas = cantidadMaximaLlamadas;
    }
    
	public void iniciaCallCenter() throws Exception {
		
		if (this.cantidadMaximaLlamadas > 10) {
			throw new Exception("La cantidad de llamadas supera el maximo permitido.");
		}
		
		//Creo los directores, supervisores y operadores
		directores.add(new Director("Diego"));
        directores.add(new Director("Leonel"));
        
        supervisores.add(new Supervisor("Javier"));
        supervisores.add(new Supervisor("Leonardo"));
        supervisores.add(new Supervisor("Miguel"));

        operadores.add(new Operador("Daniel"));
        operadores.add(new Operador("Laura"));
        operadores.add(new Operador("Cristian"));
        operadores.add(new Operador("Kiara"));
        operadores.add(new Operador("Cristian"));

        //Instancio el dispacher
        Dispatcher dispatcher = new Dispatcher(operadores, supervisores, directores, llamadas);
        dispatcher.dispatchCall();

        //Cargo los 10 clientes que van a llamar
        for (int i = 0; i < 10; i++) {
            LlamadaServicesImpl llamadaService = new LlamadaServicesImpl(i, llamadas);
            llamadaService.start();
        }
	}
}
