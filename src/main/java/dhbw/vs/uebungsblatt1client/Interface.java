package dhbw.vs.uebungsblatt1client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

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

    @PostMapping(path = "/bestellpositionen")
    Bestellposition postBestellposition(@RequestBody Bestellposition bestellposition);

    @PutMapping(path = "/artikel/{id}")
    Artikel putArtikel(@PathVariable Long id,
                       @RequestBody Artikel newArtikel);

    @DeleteMapping(path = "/bestellungen/{id}")
    void deleteBestellung(@PathVariable Long id);

    @DeleteMapping(path = "/bestellpositionen/{id}")
    void deleteBestellposition(@PathVariable Long id);

}
