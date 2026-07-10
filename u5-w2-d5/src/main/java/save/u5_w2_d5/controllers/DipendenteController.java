package save.u5_w2_d5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.services.DipendenteService;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAll() {
        return dipendenteService.findAll();
    }

    @PostMapping
    public Dipendente save(@RequestBody Dipendente d) {
        return dipendenteService.save(d);
    }
}