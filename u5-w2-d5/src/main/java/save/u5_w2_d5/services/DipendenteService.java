package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.payloads.DipendentePayload;
import save.u5_w2_d5.repositories.DipendenteRepository;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dr;

    public Dipendente save(DipendentePayload body) {
        Dipendente d = new Dipendente();
        d.setUsername(body.username());
        d.setNome(body.nome());
        d.setCognome(body.cognome());
        d.setEmail(body.email());
        return dr.save(d);
    }
}
