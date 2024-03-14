package tech.ada.librarymanager.member;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String create(@RequestBody MemberDTO member){
        return service.create(member);
    }

    @GetMapping()
    public List<MemberEntity> findAll(){
        return service.findAll();
    }

    @PutMapping()
    public MemberEntity change(@RequestBody MemberEntity member){
        return service.change(member);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return String.format("Usuário com Id %d deletado com sucesso! ", id);
    }
}
