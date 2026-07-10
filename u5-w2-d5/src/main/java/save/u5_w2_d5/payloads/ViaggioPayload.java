package save.u5_w2_d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViaggioPayload(
        @NotBlank(message = "La destinazione è obbligatoria")
        String destinazione,

        @NotNull(message = "La data è obbligatoria")
        LocalDate data,

        @NotBlank(message = "Lo stato del viaggio è obbligatorio")
        String statoViaggio
) {}
