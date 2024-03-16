package tech.ada.librarymanager.book;

import org.springframework.stereotype.Service;

import java.util.List;
import tech.ada.librarymanager.exceptions.AddressNotFoundException;
import tech.ada.librarymanager.exceptions.BookNotFoundException;

@Service
public class BookService {

    private BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public String create(BookEntity book){
        BookEntity saved = repository.save(book);
        return String.format("Salvo livro id %d", saved.getId());
    }

    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    public BookEntity change(BookEntity book) {
        BookEntity changed = repository.save(book);
        return changed;
    }

    public void delete(Long id) {
        BookEntity book = repository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        repository.delete(book);
    }



}
