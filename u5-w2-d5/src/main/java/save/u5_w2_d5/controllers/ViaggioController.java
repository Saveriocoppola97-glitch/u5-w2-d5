package save.u5_w2_d5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.services.ViaggioService;
import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getAll() {
        return viaggioService.findAll();
    }

    @PostMapping
    public Viaggio save(@RequestBody Viaggio v) {
        return viaggioService.save(v);
    }
}
