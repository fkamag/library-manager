package tech.ada.librarymanager.lend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.stereotype.Service;
import tech.ada.librarymanager.address.AddressEntity;
import tech.ada.librarymanager.address.AddressRepository;
import tech.ada.librarymanager.book.BookEntity;
import tech.ada.librarymanager.book.BookRepository;
import tech.ada.librarymanager.member.MemberDTO;
import tech.ada.librarymanager.member.MemberEntity;
import tech.ada.librarymanager.member.MemberRepository;

@Service
public class LendService {
  private LendRepository repository;
  private MemberRepository memberRepository;
  private BookRepository bookRepository;

  public LendService(LendRepository repository, MemberRepository memberRepository,
      BookRepository bookRepository) {
    this.repository = repository;
    this.memberRepository = memberRepository;
    this.bookRepository = bookRepository;
  }

  public String create(LendDTO lend){
    MemberEntity member = memberRepository.findById(lend.memberId())
        .orElseThrow();
    BookEntity book = bookRepository.findById(lend.bookId())
        .orElseThrow();
    LendEntity lendEntity = new LendEntity(lend);
    lendEntity.setBook(book);
    lendEntity.setMember(member);

    LendEntity saved = repository.save(lendEntity);

    return String.format("Salvo empréstimo id %d", saved.getId());
  }

  public List<LendEntity> findAll() {
    return repository.findAll();
  }

  public LendEntity changeDate(LendDTO lendDTO) {
    LendEntity lend = repository.findById(lendDTO.id())
        .orElseThrow();
    lend.setLateFee(lendDTO.dias() * 5.00);

    return lend;
  }

  public LendEntity change(Long id) {
    LendEntity lend = repository.findById(id)
        .orElseThrow();
    LocalDate today = LocalDate.now();
    LocalDate dataRetorno = lend.getReturnDate();

    if (today.isAfter(dataRetorno)) {
      Long diasEntre = ChronoUnit.DAYS.between(dataRetorno, today);
      lend.setLateFee(diasEntre * 5.00);
    }

    return repository.save(lend);
  }



//  public void delete(Long id) {
//    MemberEntity address = repository.findById(id)
//        .orElseThrow();
//    repository.delete(address);
//  }

}
