package tech.ada.librarymanager.member;

import org.springframework.stereotype.Service;

import java.util.List;
import tech.ada.librarymanager.address.AddressEntity;
import tech.ada.librarymanager.address.AddressRepository;
import tech.ada.librarymanager.exceptions.AddressNotFoundException;
import tech.ada.librarymanager.exceptions.MemberNotFoundException;

@Service
public class MemberService {
    private MemberRepository repository;
    private AddressRepository addressRepository;

    public MemberService(MemberRepository repository, AddressRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    public String create(MemberDTO member){
        AddressEntity address = addressRepository.findById(member.address_id())
            .orElseThrow(AddressNotFoundException::new);
        MemberEntity memberEntity = new MemberEntity(member);
        memberEntity.setAddress(address);

        MemberEntity saved = repository.save(memberEntity);

        return String.format("Salvo usuário id %d", saved.getId());
    }

    public List<MemberEntity> findAll() {
        return repository.findAll();
    }

    public MemberEntity change(MemberDTO member) {
        repository.findById(member.id()).orElseThrow(MemberNotFoundException::new);
        AddressEntity address = addressRepository.findById(member.address_id())
            .orElseThrow(AddressNotFoundException::new);
        MemberEntity memberEntity = new MemberEntity(member);
        memberEntity.setAddress(address);
        return repository.save(memberEntity);
    }

    public void delete(Long id) {
        MemberEntity address = repository.findById(id)
                .orElseThrow(MemberNotFoundException::new);
        repository.delete(address);
    }
}


