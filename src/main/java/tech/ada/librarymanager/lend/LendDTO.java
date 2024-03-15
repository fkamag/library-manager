package tech.ada.librarymanager.lend;

import java.time.LocalDate;

public record LendDTO(
    Long id,
    Long bookId,
    Long memberId,
    Double dias
) {

}
