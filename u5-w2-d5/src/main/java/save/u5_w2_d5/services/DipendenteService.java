package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.Dipendente;
import save.u5_w2_d5.repositories.DipendenteRepository;
import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente save(Dipendente d) {
        return dipendenteRepository.save(d);
    }
}
