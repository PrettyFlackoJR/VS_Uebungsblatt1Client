package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@FeignClient(name="service", url="http://localhost:8080")
public interface Interface {

    @GetMapping(path = "/kunden")
    Collection<Kunde> getAllKunden();

    @GetMapping(path = "/kunden/{id}")
    Kunde getKunde(@PathVariable Long id);

    @GetMapping(path = "/bestellungen/kundenNr/{value}")
    ArrayList<Bestellung> getKundeFromBestellung(@PathVariable Long value);

    @GetMapping(path = "/bestellpositionen/bestellungsNr/{value}")
    ArrayList<Bestellposition> getBestellungFromBestellposition(@PathVariable Long value);

    @GetMapping(path = "/artikel/{id}")
    Artikel getArtikel(@PathVariable Long id);

}
