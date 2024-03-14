package tech.ada.librarymanager.member;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tech.ada.librarymanager.address.AddressEntity;

public record MemberDTO(
    String name,
    String email,
    Boolean isAvailable,
    Long address_id
) {

}
