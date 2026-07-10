package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.payloads.DipendentePayload;
import save.u5_w2_d5.services.DipendenteService;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public Dipendente save(@RequestBody @Valid DipendentePayload body) {
        return dipendenteService.save(body);
    }
}