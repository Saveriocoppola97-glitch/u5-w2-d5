package save.u5_w2_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import save.u5_w2_d5.entities.Prenotazione;
import java.time.LocalDate;@Repository


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    // Metodo controllo dipendente
    boolean existsByDipendenteIdAndDataPrenotazione(long dipendenteId, LocalDate dataPrenotazione);
}
