package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.entities.StatoViaggio;
import save.u5_w2_d5.payloads.ViaggioPayload;
import save.u5_w2_d5.repositories.ViaggioRepository;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository vr;

    public Viaggio save(ViaggioPayload body) {
        Viaggio v = new Viaggio();
        v.setDestinazione(body.destinazione());
        v.setData(body.data());
        v.setStato(StatoViaggio.valueOf(body.statoViaggio().toUpperCase()));
        return vr.save(v);
    }
}