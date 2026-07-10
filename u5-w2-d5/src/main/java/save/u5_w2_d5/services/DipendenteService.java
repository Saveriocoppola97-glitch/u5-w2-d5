package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.payloads.DipendentePayload;
import save.u5_w2_d5.repositories.DipendenteRepository;

import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dr;

    // GET
    public List<Dipendente> findAll() {
        return dr.findAll();
    }

    // FIND BY ID
    public Dipendente findById(long id) {
        return dr.findById(id).orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
    }

    // SAVE
    public Dipendente save(DipendentePayload body) {
        Dipendente d = new Dipendente();
        d.setUsername(body.username());
        d.setNome(body.nome());
        d.setCognome(body.cognome());
        d.setEmail(body.email());
        return dr.save(d);
    }

    // UPDATE
    public Dipendente update(long id, DipendentePayload body) {
        Dipendente d = findById(id);
        d.setUsername(body.username());
        d.setNome(body.nome());
        d.setCognome(body.cognome());
        d.setEmail(body.email());
        return dr.save(d);
    }

    // DELETE
    public void delete(long id) {
        Dipendente found = findById(id);
        dr.delete(found);
    }
}
