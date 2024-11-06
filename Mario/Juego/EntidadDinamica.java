package Juego;

import Mario.BolaDeFuego;
import Utils.Visitor;

abstract public class EntidadDinamica extends Entidad {

	protected boolean 		eliminar = false;
	protected int 			velocidad = 1;
	protected int 			direccion = 1;
	protected MasterMind 	miMasterMind;
	protected double 		velY;
	protected int 			suelo = 535; 

	public void serGolpeadoBolaDeFuego(BolaDeFuego bf) {}

	public void serGolpeadoCaparazon() {};

	public abstract void moverse();

	public abstract void colision(String lugar, EntidadEstatica miBloque);

	public abstract void accept(Visitor v);

	public abstract void afectarJugador(Jugador j);
	
	public void caer() {
		this.velY = 2;
		if(this.posY <= suelo) { 
			this.posY += velY;
			this.miHitbox.setLocation(posX, posY);			
		}
	}
	
	public void setMasterMind(MasterMind m) {
		this.miMasterMind = m;
	}
	public void setEliminar() {
		this.eliminar = true;
	}
	public void setVelocidad(int i ) {
		this.velocidad = i;
	}
	public void setDireccion(int i) {
		this.direccion = i;
	}
	
	public int getDireccion() {
		return direccion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public boolean getEliminar() {
		return eliminar;
	}
	public double getVelocidadY() {
		return this.velY;
	}

}

