package save.u5_w2_d5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.payloads.ViaggioPayload;
import save.u5_w2_d5.services.ViaggioService;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    public Viaggio save(@RequestBody @Valid ViaggioPayload body) {
        return viaggioService.save(body);
    }
}
