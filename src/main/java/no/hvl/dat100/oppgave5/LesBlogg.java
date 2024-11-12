package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg samling = new Blogg();
		File file = new File(mappe + filnavn);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String type = scanner.nextLine();
				if (type.equals(TEKST) || type.equals(BILDE)) {
					int id = Integer.parseInt(scanner.nextLine());
					String bruker = scanner.nextLine();
					String dato = scanner.nextLine();
					int likes = Integer.parseInt(scanner.nextLine());
					String tekst = scanner.nextLine();
					if (type.equals(TEKST)) {
						Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
						samling.leggTil(tekstInnlegg);
					} else if (type.equals(BILDE)) {
						String url = scanner.nextLine();
						Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
						samling.leggTil(bildeInnlegg);
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Filen ble ikke funnet");
		}
		return samling;
	}

}
