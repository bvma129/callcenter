package com.callcenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.callcenter.model.Director;
import com.callcenter.model.Operador;
import com.callcenter.model.Supervisor;
import com.callcenter.services.LlamadaServices;
import com.callcenter.services.impl.LlamadaServicesImpl;

import junit.framework.TestCase;

/**
 * 
 * @author SERGIO MURUA
 *
 */
public class CallCenterTest extends TestCase {

	/**
	 * Test de 10 llamadas
	 */
	@Test
    public void testDispatch10CallsOk(){
        CallCenter callCenter = new CallCenter(10);

        List<Director> directores = new ArrayList<Director>();
        List<Supervisor> supervisores = new ArrayList<Supervisor>();
        List<Operador> operadores = new ArrayList<Operador>();

        directores.add(new Director("Cristian"));
        directores.add(new Director("Claudio"));
        directores.add(new Director("Maria"));
        directores.add(new Director("Claudia"));

        supervisores.add(new Supervisor("Marina"));
        supervisores.add(new Supervisor("Cristina"));


        operadores.add(new Operador("Ruben"));
        operadores.add(new Operador("Franco"));
        operadores.add(new Operador("Nino"));
        operadores.add(new Operador("Juan"));


        callCenter.setDirectores(directores);
        callCenter.setOperadores(operadores);
        callCenter.setSupervisores(supervisores);

        Dispatcher dispatcher = new Dispatcher(operadores, supervisores, directores, callCenter.getLlamadas());


        dispatcher.dispatchCall();
      
        for (int i = 0; i < 10; i++) {
        	LlamadaServicesImpl llamadaService = new LlamadaServicesImpl(i, callCenter.getLlamadas());
        	llamadaService.start();
        }

        Assert.assertEquals(callCenter.getLlamadas(),10);
    }
	
}
