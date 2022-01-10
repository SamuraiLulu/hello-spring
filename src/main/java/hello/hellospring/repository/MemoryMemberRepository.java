package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository  implements MemberRepository{

    //값 저장위해 map 생성 : 어딘가에 값이 저장되어 있어야하니까 map사용
    private static Map<Long, Member> store = new HashMap<>();
    private Long squence = 0L;

    @Override
    public Member save(Member member) {
        //멤버를 순차적으로 증가
        member.setId(++squence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    //roop돌리기 편하므로 list
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
