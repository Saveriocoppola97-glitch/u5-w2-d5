package save.u5_w2_d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DipendentePayload(
        @NotBlank(message = "Username obbligatorio")
        String username,

        @NotBlank(message = "Nome obbligatorio")
        String nome,

        @NotBlank(message = "Cognome obbligatorio")
        String cognome,

        @Email(message = "Email non valida")
        @NotBlank(message = "Email obbligatoria")
        String email
) {}
