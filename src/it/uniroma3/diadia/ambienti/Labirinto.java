package it.uniroma3.diadia.ambienti;

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}
