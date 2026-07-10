package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.payloads.DipendentePayload;
import save.u5_w2_d5.services.DipendenteService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente save(@RequestBody @Valid DipendentePayload body) {
        return dipendenteService.save(body);
    }

    // GET
    @GetMapping
    public List<Dipendente> findAll() {
        return dipendenteService.findAll();
    }

    // GET ID
    @GetMapping("/{id}")
    public Dipendente findById(@PathVariable long id) {
        return dipendenteService.findById(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Dipendente update(@PathVariable long id, @RequestBody @Valid DipendentePayload body) {
        return dipendenteService.update(id, body);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        dipendenteService.delete(id);
    }

    // AVATAR
    @PatchMapping("/{id}/avatar")
    public Dipendente uploadAvatar(@PathVariable long id, @RequestParam("avatar") MultipartFile file) throws IOException {
        return dipendenteService.uploadAvatar(id, file);
    }
}