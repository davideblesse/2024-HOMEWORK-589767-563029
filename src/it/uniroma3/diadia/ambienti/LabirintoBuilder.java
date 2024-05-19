package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String, Stanza> nome2stanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<String, Stanza>();
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza iniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.labirinto.setStanzaCorrente(iniziale);
		this.aggiungiAMappaEAggiornaUltima(iniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		Stanza vincente = new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(vincente);
		this.aggiungiAMappaEAggiornaUltima(vincente);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
		Stanza stanzaPartenza =  this.nome2stanza.get(partenza);
		Stanza stanzaAdiacente =  this.nome2stanza.get(adiacente);
		stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);;
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a = new Attrezzo(nome, peso);
		this.ultimaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		StanzaMagica stanza = new StanzaMagica(nome, soglia);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		StanzaBuia stanza = new StanzaBuia(nome, attrezzoPerVedere);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoPerSbloccare) {
		StanzaBloccata stanza = new StanzaBloccata(nome, direzioneBloccata, attrezzoPerSbloccare);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
		this.ultimaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Map<String, Stanza> getListaStanze() {
		return nome2stanza;
	}

}
