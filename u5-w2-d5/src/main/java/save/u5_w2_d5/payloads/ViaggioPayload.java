package save.u5_w2_d5.payloads;

import java.time.LocalDate;

public record ViaggioPayload(
        String destinazione,
        LocalDate data,
        String stato
) {}
