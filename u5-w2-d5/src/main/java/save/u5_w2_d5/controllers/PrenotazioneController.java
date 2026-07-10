package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Prenotazione> getAll() {
        return prenotazioneService.findAll();
    }

    @PostMapping
    public Prenotazione save(@RequestBody @Valid PrenotazionePayload body) {
        return prenotazioneService.save(body);
    }
}
