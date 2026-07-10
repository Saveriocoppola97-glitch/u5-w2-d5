package save.u5_w2_d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import save.u5_w2_d5.entities.Viaggio;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
