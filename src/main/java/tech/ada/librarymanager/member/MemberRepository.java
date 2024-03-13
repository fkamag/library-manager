package tech.ada.librarymanager.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <MemberEntity, Long>{
}
