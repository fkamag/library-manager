package tech.ada.librarymanager.address;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public String create(AddressEntity address){
        AddressEntity saved = repository.save(address);
        return String.format("Salvo endereço id %d", saved.getId());
    }

    public List<AddressEntity> findAll() {
        return repository.findAll();
    }

    public AddressEntity change(AddressEntity address) {
       return repository.save(address);
    }

    public void delete(Long id) {
        AddressEntity address = repository.findById(id)
                .orElseThrow();
        repository.delete(address);
    }
}
