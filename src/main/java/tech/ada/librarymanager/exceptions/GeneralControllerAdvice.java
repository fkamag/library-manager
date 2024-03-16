package tech.ada.librarymanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerAdvice {

  @ExceptionHandler
  public ResponseEntity<String> handleAddressNotFoundException(AddressNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
  }

  @ExceptionHandler
  public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
  }

  @ExceptionHandler
  public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
  }

  @ExceptionHandler
  public ResponseEntity<String> handleLendNotFoundException(LendNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empréstimo não encontrado");
  }

  @ExceptionHandler
  public ResponseEntity<String> genericException(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  }


}
