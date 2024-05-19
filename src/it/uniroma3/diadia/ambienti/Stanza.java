package it.uniroma3.diadia.ambienti;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;
	private Map<String, Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>();
		
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(stanzeAdiacenti.size()<NUMERO_MASSIMO_DIREZIONI) {
			this.stanzeAdiacenti.put(direzione, stanza);
		}else {
			System.out.println("Non puoi inserire più di "+ NUMERO_MASSIMO_DIREZIONI + " direzioni!");
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if (this.stanzeAdiacenti.containsKey(direzione))
			stanza = this.stanzeAdiacenti.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(attrezzi.values());
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzi.size()< NUMERO_MASSIMO_ATTREZZI) {
			attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}
		return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Nome: " + getNome() + "\n");
		sb.append("Uscite:");
		for(Map.Entry<String, Stanza> e: stanzeAdiacenti.entrySet()) {
			Stanza s = getStanzaAdiacente(e.getKey());
			if(s!= null && !s.isBloccata())
				sb.append(" " + e.getKey());
		}
		sb.append("\n");
		sb.append("Attrezzi:");
		for(Map.Entry<String, Attrezzo> e: attrezzi.entrySet()) {
			Stanza s = getStanzaAdiacente(e.getKey());
			if(s!= null && !s.isBloccata())
				sb.append(" " + e.getKey());
		}
		return sb.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzi.containsKey(attrezzo.getNome())) {
			attrezzi.remove(attrezzo.getNome());
			return true;
		}
		return false;
	}

	public List<String> getDirezioni() {
		return new ArrayList<>(stanzeAdiacenti.keySet());
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		return stanzeAdiacenti;
	}

	public boolean isMagica() {
		return false;
	}

	public boolean isBloccata() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
}


