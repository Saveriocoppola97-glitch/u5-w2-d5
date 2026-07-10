package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.payloads.DipendentePayload;
import save.u5_w2_d5.services.DipendenteService;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public Dipendente save(@RequestBody @Valid DipendentePayload body) {
        return dipendenteService.save(body);
    }

    @GetMapping
    public List<Dipendente> findAll() {
        return dipendenteService.findAll();
    }

    @GetMapping("/{id}")
    public Dipendente findById(@PathVariable long id) {
        return dipendenteService.findById(id);
    }

    @PutMapping("/{id}")
    public Dipendente update(@PathVariable long id, @RequestBody @Valid DipendentePayload body) {
        return dipendenteService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204: Operazione avvenuta con successo senza corpo di risposta
    public void delete(@PathVariable long id) {
        dipendenteService.findByIdAndDelete(id);
    }
}