package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)//성능 최적화 읽기에는 readonly true(데이터변동x) 쓰기에는 x
@RequiredArgsConstructor//final이 있는 필드만 가지고 생성자 만들어줌
public class MemberService {

    private final MemberRepository memberRepository;


    //회원 가입
    @Transactional// readonly=false
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원");
        }
    }
    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findALl();
    }

    public Member findone(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
