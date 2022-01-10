package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원가입 member를 저장
    Member save(Member member);
    
    //id로 검색
    Optional<Member> findById(Long id);
    
    //이름으로 검색
    Optional<Member> findByName(String name);
    
    //가입된 모든 member list로 출력
    List<Member> findAll();

}
