package tech.ada.librarymanager.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String create(@RequestBody BookEntity book){
        return service.create(book);
    }

    @GetMapping()
    public List<BookEntity> findAll(){
        return service.findAll();
    }

    @PutMapping()
    public BookEntity change(@RequestBody BookEntity book){
        return service.change(book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return String.format("Livro com Id %d deletado com sucesso! ", id);
    }


}
