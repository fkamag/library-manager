package tech.ada.librarymanager.member;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import tech.ada.librarymanager.address.AddressEntity;
import tech.ada.librarymanager.address.AddressRepository;

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
            .orElseThrow();
        MemberEntity memberEntity = new MemberEntity(member);
        memberEntity.setAddress(address);

        MemberEntity saved = repository.save(memberEntity);

        return String.format("Salvo usuário id %d", saved.getId());
    }

    public List<MemberEntity> findAll() {
        return repository.findAll();
    }

    public MemberEntity change(MemberDTO member) {
        AddressEntity address = addressRepository.findById(member.address_id())
            .orElseThrow();
        MemberEntity memberEntity = new MemberEntity(member);
        memberEntity.setAddress(address);
        return repository.save(memberEntity);
    }

    public void delete(Long id) {
        MemberEntity address = repository.findById(id)
                .orElseThrow();
        repository.delete(address);
    }
}


