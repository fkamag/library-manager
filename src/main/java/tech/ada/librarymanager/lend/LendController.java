package tech.ada.librarymanager.lend;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.librarymanager.member.MemberDTO;
import tech.ada.librarymanager.member.MemberEntity;
import tech.ada.librarymanager.member.MemberService;

@RestController
@RequestMapping("/lend")
public class LendController {
  private LendService service;

  public LendController(LendService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public String create(@RequestBody LendDTO lend){
    return service.create(lend);
  }

  @GetMapping()
  public List<LendEntity> findAll(){
    return service.findAll();
  }

  /*
  Método exclusivo para testar a multa
  Não vai para produção
   */
  @PutMapping
  public LendEntity changeDate(@RequestBody LendDTO lendDTO) {
    return service.changeDate(lendDTO);
  }

  @PutMapping("/{id}")
  public LendEntity change(@PathVariable Long id){
    return service.change(id);
  }

//  @DeleteMapping("/{id}")
//  public String delete(@PathVariable Long id){
//    service.delete(id);
//    return String.format("Usuário com Id %d deletado com sucesso! ", id);
//  }

}
