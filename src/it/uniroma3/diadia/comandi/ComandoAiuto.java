package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private IO io;
	private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };
	

	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < this.elencoComandi.length; i++)
			io.mostraMessaggio(this.elencoComandi[i] + " ");
		io.mostraMessaggio("");
		
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "aiuto";
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
