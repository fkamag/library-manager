package tech.ada.librarymanager.member;

import jakarta.persistence.*;
import tech.ada.librarymanager.address.AddressEntity;

@Entity
@Table(name = "tb_member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private Boolean hasPermission;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    public MemberEntity() {}

    public MemberEntity(MemberDTO memberDTO) {
        this.id = memberDTO.id();
        this.name = memberDTO.name();
        this.email = memberDTO.email();
        this.hasPermission = memberDTO.hasPermission();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
