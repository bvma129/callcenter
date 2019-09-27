package com.callcenter;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.callcenter.model.Director;
import com.callcenter.model.Operador;
import com.callcenter.model.Supervisor;


/**
 * 
 * @author SERGIO MURUA
 *
 */
public class Dispatcher extends Thread {

	private List<Director> directores = new ArrayList<Director>();
    private List<Supervisor> supervisores = new ArrayList<Supervisor>();
    private List<Operador> operadores = new ArrayList<Operador>();
    private LinkedList<Integer> llamadas=new LinkedList<Integer>();

    /**
     * Constructor
     * @param operadores
     * @param supervisores
     * @param directores
     * @param llamadas
     */
    public Dispatcher(List<Operador> operadores, List<Supervisor> supervisores, List<Director> directores, LinkedList<Integer> llamadas){
        this.llamadas=llamadas;
        this.supervisores=supervisores;
        this.operadores=operadores;
        this.directores=directores;
    }

    /**
     * DispatchCall
     */
    public void dispatchCall() {
        System.out.println("Inicia el dispatchCall ...");
        this.start();
    }

    /**
     * Run
     */
    @Override
    public void run() {
        try {

            while (true) {

                //Verifico que haya llamadas
                if(llamadas.size()>0){

                    // Verifico que haya algun personal disponible para atender la llamada
                    if(!operadores.isEmpty() || !supervisores.isEmpty() || !directores.isEmpty()){
                    	//Obtengo el id de cliente
                        Integer idCliente = llamadas.remove();

                        //Verifico que haya operadores para atender
                        if (!operadores.isEmpty()) {
                        	//remuevo el operador que atiende la llamada
                            Operador operador = operadores.remove(0);
                            System.out.println("Llamada deli cliente: " + idCliente + " Atendida por: "+ operador.getNombre());
                            operador.start();
                        } else if (!supervisores.isEmpty()) {
                            Supervisor supervisor = supervisores.remove(0);
                            System.out.println("Llamada deli cliente: " + idCliente + " Atendida por: "+supervisor.getNombre());
                            supervisor.start();
                        } else if(!directores.isEmpty()){
                            Director director = directores.remove(0);
                            System.out.println("Llamada deli cliente: " + idCliente + " Atendida por: "+director.getNombre());
                            director.start();
                        }

                    }else {
                    	throw new Exception("No hay ningun operador disponible para atender si llamada.");
                 
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
