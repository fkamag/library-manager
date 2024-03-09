package tech.ada.librarymanager.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book {
  private Long id;
  private String title;
  private String author;
  private Integer yearPublication;
  private String genre;
  private Integer numberPages;


}
