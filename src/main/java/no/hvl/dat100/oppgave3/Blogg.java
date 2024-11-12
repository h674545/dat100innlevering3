package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int lengde;
	private int antall;

	public Blogg() {
		lengde = 20;
		innleggtabell = new Innlegg[lengde];
		antall = 0;
	}

	public Blogg(int lengde) {
		this.lengde = lengde;
		innleggtabell = new Innlegg[lengde];
		antall = 0;

	}

	public int getAntall() {
		return antall;

	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < antall; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;

	}

	public boolean ledigPlass() {
		return antall < lengde;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[antall] = innlegg;
			antall++;
			return true;
		}
		return false;
	}

	public String toString() {
		String str = antall + "\n";
		for (int i = 0; i < antall; i++) {
			str += innleggtabell[i].toString();
		}
		return str;

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nyTab = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < antall; i++) {
			nyTab[i] = innleggtabell[i];
		}
		innleggtabell = nyTab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			innleggtabell[antall] = innlegg;
			antall++;
			return true;
		}
		return false;
	}

	public boolean slett(Innlegg innlegg) {

		int index = finnInnlegg(innlegg);
		if (index != -1) {
			antall--;
			innleggtabell[index] = innleggtabell[antall];
			innleggtabell[antall] = null;
			return true;
		}
		return false;
	}

	public int[] search(String keyword) {

		int[] idTab = new int[antall];
		int j = 0;
		for (int i = 0; i < antall; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				idTab[j] = innleggtabell[i].getId();
				j++;
			}
		}
		return idTab;

	}
}