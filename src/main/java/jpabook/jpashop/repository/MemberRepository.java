package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository//빈에 등록
@RequiredArgsConstructor
public class MemberRepository {

   // @PersistenceContext// 엔티티매니저에 주입
    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id) {//
        return em.find(Member.class, id);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findALl(){
        return em.createQuery("select  m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)//이름을 바인딩받아 조회
                .getResultList();
    }
}
