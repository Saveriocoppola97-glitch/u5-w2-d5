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
    private PrenotazioneRepository pr;
    @Autowired
    private DipendenteService dipendenteService;
    @Autowired
    private ViaggioService viaggioService;

    // GET ALL
    public List<Prenotazione> findAll() {
        return pr.findAll();
    }

    // FIND BY ID
    public Prenotazione findById(long id) {
        return pr.findById(id).orElseThrow(() -> new RuntimeException("Prenotazione con id " + id + " non trovata"));
    }

    // SAVE
    public Prenotazione save(PrenotazionePayload body) {
        // GIA PERNOTATO
        boolean giaPrenotato = pr.existsByDipendenteIdAndDataPrenotazione(body.dipendenteId(), body.dataPrenotazione());
        if (giaPrenotato) {
            throw new RuntimeException("C'è già una prenotazione per la data " + body.dataPrenotazione());
        }

        Dipendente d = dipendenteService.findById(body.dipendenteId());
        Viaggio v = viaggioService.findById(body.viaggioId());
        Prenotazione p = new Prenotazione();
        p.setDipendente(d);
        p.setViaggio(v);
        p.setDataPrenotazione(body.dataPrenotazione());
        p.setNote(body.note());
        return pr.save(p);
    }

    // UPDATE
    public Prenotazione update(long id, PrenotazionePayload body) {
        Prenotazione p = findById(id);
        Dipendente d = dipendenteService.findById(body.dipendenteId());
        Viaggio v = viaggioService.findById(body.viaggioId());
        p.setDipendente(d);
        p.setViaggio(v);
        p.setDataPrenotazione(body.dataPrenotazione());
        p.setNote(body.note());
        return pr.save(p);
    }

    // DELETE
    public void delete(long id) {
        Prenotazione found = findById(id);
        pr.delete(found);
    }
}
