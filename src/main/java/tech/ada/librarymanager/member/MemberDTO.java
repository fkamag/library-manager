package tech.ada.librarymanager.member;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tech.ada.librarymanager.address.AddressEntity;

public record MemberDTO(
    Long id,
    String name,
    String email,
    Boolean hasPermission,
    Long address_id
) {}
