package tech.ada.librarymanager.address;

public record AddressDTO(
        Long id,
        String userAddress,
        String city,
        String state,
        String zipCode
){}
