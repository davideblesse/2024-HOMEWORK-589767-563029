package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoVaiTest {
	
	private ComandoVai comandoVai;
	private Partita partita;
	private IO io;
	
	

	@Before
	public void setUp() throws Exception {
		comandoVai = new ComandoVai();
		partita = new Partita();
		io = new IOConsole();
		comandoVai.setIO(io);
	}
	
	/*Test riguardanti */

	@Test
	public void testVaiInDirezioneNulla() {
		comandoVai.setParametro(null);
		comandoVai.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "Atrio");
	}
	
	@Test
	public void testVaiInDirezioneNonValida() {
		comandoVai.setParametro("up");
		comandoVai.esegui(partita);
		assertEquals(partita.getStanzaCorrente().getNome(), "Atrio");
	}
	
	@Test
	public void testVaiInDirezioneValida() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getStanzaCorrente().getNome(), "Aula N10");
	}
	
	/*Test riguardanti i CFU*/
	
	@Test
	public void testCfuInalteratiDirezioneNonValida() {
		comandoVai.setParametro("up");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getGiocatore().getCfu(), 20);
	}
	
	@Test
	public void testCfuAggiornatiDirezioneValida() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		
		assertEquals(partita.getGiocatore().getCfu(), 19);
	}

}
