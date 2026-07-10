package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Prenotazione;
import save.u5_w2_d5.payloads.PrenotazionePayload;
import save.u5_w2_d5.services.PrenotazioneService;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione save(@RequestBody @Valid PrenotazionePayload body) {
        return prenotazioneService.save(body);
    }

    // GET
    @GetMapping
    public List<Prenotazione> findAll() {
        return prenotazioneService.findAll();
    }

    // GET ID
    @GetMapping("/{id}")
    public Prenotazione findById(@PathVariable long id) {
        return prenotazioneService.findById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Prenotazione update(@PathVariable long id, @RequestBody @Valid PrenotazionePayload body) {
        return prenotazioneService.update(id, body);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        prenotazioneService.delete(id);
    }
}
