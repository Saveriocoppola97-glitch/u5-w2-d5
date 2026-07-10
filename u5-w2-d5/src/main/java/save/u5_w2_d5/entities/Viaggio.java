package save.u5_w2_d5.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinazione;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public Viaggio() {
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }
}