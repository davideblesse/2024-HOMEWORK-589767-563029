package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	private IO io;
	

	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPosa = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPosa)) {
				io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
			}else {
				io.mostraMessaggio("La stanza è piena, l'attrezzo non è stato posato");
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPosa);
			}
		} else {
			io.mostraMessaggio("Non è presente l'attrezzo " + nomeAttrezzo);
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}
	
	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;	
	}

}
