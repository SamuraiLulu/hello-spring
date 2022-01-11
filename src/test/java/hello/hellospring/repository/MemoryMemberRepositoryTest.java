package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
//모든 test는 순서가 보장이 안된다. 따라서 각자 따로 돌도록 설계를 해줘야 한다. 혹은 매 테스트가 끝나고 메모리를 비워주는 method를 만들어준다.
    //각각의 method가 끝날 떄마다 실행된다. callBack과 같다고 생각
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result  = " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

       List<Member> result = repository.findAll();

       assertThat(result.size()).isEqualTo(2);
    }


}
