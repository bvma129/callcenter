package com.callcenter.model;

public abstract class BaseModel extends Thread {

	private String nombre;
	private String tipoOperador;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoOperador() {
		return tipoOperador;
	}

	public void setTipoOperador(String tipoOperador) {
		this.tipoOperador = tipoOperador;
	}
	
	public void answerCall() {
        System.out.println(getTipoOperador() + " " + getNombre() + " atiende la llamada");
    }

    public void endCall() {
        System.out.println(getTipoOperador() + " " + getNombre() + " cuelga la llamada");
    }
	
	@Override
    public void run() {
            int callTime = (int) (Math.random() * ((10 - 5)+1) + 5);

            this.answerCall();

            try {
                sleep(callTime * 1000);
                this.endCall();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

	
    
}
