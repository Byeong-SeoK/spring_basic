package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJapMemberRepository extends JpaRepository <Member, Long>, MemberRepository{

    @Override
    Optional<Member> findByName(String name);
    //위 코드를 여기다 입력하는 것으로 SpringData JPA는 알아서
    //select m from Member m where m.name = ? 이라는 JPQL을 짜준다.
}
