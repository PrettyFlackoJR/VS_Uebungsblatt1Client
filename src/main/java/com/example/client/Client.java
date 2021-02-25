package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Client implements CommandLineRunner {

    @Autowired
    Interface service;

    public void run(String... commandlineArgs) {

        // Alle Kunden
        Collection<Kunde> alle = service.getAllKunden();
        System.out.println("\n" + alle + "\n");

        // Kunde mit nr. 2
        Kunde kunde = service.getKunde(2L);
        System.out.println(kunde + "\n");

        // Bestellung von Kunde 2
        ArrayList<Bestellung> b = service.getKundeFromBestellung(2L);
        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i).toString());
            System.out.println(service.getKunde(2L));
            for (Bestellposition bp : service.getBestellungFromBestellposition(b.get(i).bestellungsNr)) {
                System.out.println(bp.anzahl + " * " + service.getArtikel(bp.artikelNr).toString());
            }
        }
    }
}
