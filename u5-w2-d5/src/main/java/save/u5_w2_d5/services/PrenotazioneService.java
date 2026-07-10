package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.*;
import save.u5_w2_d5.payloads.PrenotazionePayload;
import save.u5_w2_d5.repositories.*;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione save(PrenotazionePayload body) {
        Dipendente d = dipendenteRepository.findById(body.dipendenteId())
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        Viaggio v = viaggioRepository.findById(body.viaggioId())
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));

        Prenotazione p = new Prenotazione();
        p.setDipendente(d);
        p.setViaggio(v);
        p.setDataPrenotazione(body.dataPrenotazione());
        p.setNote(body.note());

        return prenotazioneRepository.save(p);
    }
}
