package tech.ada.librarymanager.book;

public record BookDTO(
    Long id,
    String title,
    String author,
    Integer publicationDate,
    String genre,
    Integer numberOfPages,
    String isbn,
    Boolean isAvailable
){}
