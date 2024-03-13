package tech.ada.librarymanager.member;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {
    private MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public String create(MemberEntity member){
        MemberEntity saved = repository.save(member);
        return String.format("Salvo usuário id %d", saved.getId());
    }

    public List<MemberEntity> findAll() {
        return repository.findAll();
    }

    public MemberEntity change(MemberEntity member) {
        MemberEntity changed = repository.save(member);
        return changed;
    }

    public void delete(Long id) {
        MemberEntity address = repository.findById(id)
                .orElseThrow();
        repository.delete(address);
    }
}


