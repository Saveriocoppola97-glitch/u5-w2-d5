package save.u5_w2_d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w2_d5.entities.Viaggio;
import save.u5_w2_d5.repositories.ViaggioRepository;
import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> findAll() {
        return viaggioRepository.findAll();
    }

    public Viaggio save(Viaggio v) {
        return viaggioRepository.save(v);
    }
}