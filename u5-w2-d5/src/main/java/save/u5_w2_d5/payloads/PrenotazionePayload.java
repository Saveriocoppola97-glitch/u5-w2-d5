package save.u5_w2_d5.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PrenotazionePayload(
        @NotNull(message = "ID dipendente obbligatorio")
        Long dipendenteId,

        @NotNull(message = "ID viaggio obbligatorio")
        Long viaggioId,

        @NotNull(message = "Data obbligatoria")
        LocalDate dataPrenotazione,

        String note
) {}