package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
			PrintWriter skriver = new PrintWriter(mappe + filnavn);
			Innlegg[] innleggtabell = samling.getSamling();
			int antall = samling.getAntall();
			for (int i = 0; i < antall; i++) {
				skriver.println(innleggtabell[i].toString());
			}
			skriver.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}
