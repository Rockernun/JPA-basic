package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();

    public Member() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

/*
Hibernate:
    create table MEMBER_PRODUCT (
        Member_MEMBER_ID bigint not null,
        products_id bigint not null
    )
...

Hibernate:
    alter table if exists MEMBER_PRODUCT
       add constraint FKc6hsxwm11n18ahnh5yvbj62cf
       foreign key (products_id)
       references Product
Hibernate:
    alter table if exists MEMBER_PRODUCT
       add constraint FK4ibylolqmostllrjdc147aowv
       foreign key (Member_MEMBER_ID)
       references Member
*/