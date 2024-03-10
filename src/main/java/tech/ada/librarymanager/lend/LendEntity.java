package tech.ada.librarymanager.lend;

import jakarta.persistence.*;
import tech.ada.librarymanager.book.BookEntity;
import tech.ada.librarymanager.member.MemberEntity;

import java.time.LocalDate;

@Entity
@Table(name = "tb_lend")
public class LendEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    private LocalDate lendDate;
    private LocalDate returnDate;
    private Double lateFee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public LocalDate getLendDate() {
        return lendDate;
    }

    public void setLendDate(LocalDate lendDate) {
        this.lendDate = lendDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }
}
