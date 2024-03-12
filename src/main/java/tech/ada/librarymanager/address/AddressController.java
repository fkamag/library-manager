package tech.ada.librarymanager.address;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String create(@RequestBody AddressEntity address){
        return service.create(address);
    }

    @GetMapping()
    public List<AddressEntity> findAll(){
        return service.findAll();
    }

    @PutMapping()
    public AddressEntity change(@RequestBody AddressEntity address){
        return service.change(address);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return String.format("Endereço com Id %d deletado com sucesso! ", id);
    }

}
