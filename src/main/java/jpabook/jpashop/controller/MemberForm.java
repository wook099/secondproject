package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원의 이름은 필수 입니다.")//값이 비면 오류뜸
    private String name;

    private String city;
    private String street;
    private String zipcode;

}
