package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.payloads.ViaggioPayload;
import save.u5_w2_d5.services.ViaggioService;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio save(@RequestBody @Valid ViaggioPayload body) {
        return viaggioService.save(body);
    }

    @GetMapping
    public List<Viaggio> findAll() {
        return viaggioService.findAll();
    }

    @GetMapping("/{id}")
    public Viaggio findById(@PathVariable long id) {
        return viaggioService.findById(id);
    }

    @PutMapping("/{id}")
    public Viaggio update(@PathVariable long id, @RequestBody @Valid ViaggioPayload body) {
        return viaggioService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        viaggioService.findByIdAndDelete(id);
    }
}