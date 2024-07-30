package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class Member {

    @Id @GeneratedValue//generatedvalue 자동생성하게 해줌
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String name;

    @Embedded//내장 타입을 받을수있다
    private Adderss address;

    @OneToMany(mappedBy = "member")// 오더테이블에 있는 맴버필드에 의해 맵핑된거란 뜻
    private List<Order> orders = new ArrayList<>();


}
