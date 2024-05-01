package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public String getParametro() {
		return "Questo comando non ha parametri";
	}

	@Override
	public void setIO(IO io) {
		this.io = io;	
	}

}