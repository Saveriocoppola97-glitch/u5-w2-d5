package save.u5_w2_d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViaggioPayload(
        @NotBlank(message = "Destinazione obbligatoria")
        String destinazione,

        @NotNull(message = "Data obbligatoria")
        LocalDate data,

        @NotBlank(message = "Inserire uno stato di viaggio obbligatorio")
        String statoViaggio
) {}
