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
}
