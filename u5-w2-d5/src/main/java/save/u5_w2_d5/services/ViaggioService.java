package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.StatoViaggio;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.payloads.ViaggioPayload;
import save.u5_w2_d5.repositories.ViaggioRepository;

import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository vr;

    // GET
    public List<Viaggio> findAll() {
        return vr.findAll();
    }

    // FIND BY ID
    public Viaggio findById(long id) {
        return vr.findById(id).orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
    }

    // SAVE
    public Viaggio save(ViaggioPayload body) {
        Viaggio v = new Viaggio();
        v.setDestinazione(body.destinazione());
        v.setData(body.data());
        v.setStato(StatoViaggio.valueOf(body.statoViaggio().toUpperCase()));
        return vr.save(v);
    }

    // UPDATE
    public Viaggio update(long id, ViaggioPayload body) {
        Viaggio v = findById(id);
        v.setDestinazione(body.destinazione());
        v.setData(body.data());
        v.setStato(StatoViaggio.valueOf(body.statoViaggio().toUpperCase()));
        return vr.save(v);
    }

    // DELETE
    public void findByIdAndDelete(long id) {
        Viaggio found = findById(id);
        vr.delete(found);
    }
}