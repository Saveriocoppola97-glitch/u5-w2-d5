package save.u5_w2_d5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPrenotazione;
    private String note;

    @ManyToOne
    private Dipendente dipendente;

    @ManyToOne
    private Viaggio viaggio;

    public Prenotazione() {
    }



    public void setDataPrenotazione(LocalDate data) {
        this.dataPrenotazione = data;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDipendente(Dipendente d) {
        this.dipendente = d;
    }

    public void setViaggio(Viaggio v) {
        this.viaggio = v;
    }
}
