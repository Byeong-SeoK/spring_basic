package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
    //implements를 통해서 인터페이스를 상속받아 실질적으로 구현한다.

    private static Map<Long, Member> store = new HashMap<>();
    //메모리 기반 저장소를 의미한다.
    private static long sequence = 0L;
    //저장되는 순서에 대한 값을 가지고 있는 변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //위 코드의 의미는 store에 저장된 value를 stream 즉 반복문을 돌려
        //하나씩 접근해본 다음 그 중에서 파리미터로 받은 name과 같은 것을
        //filter 하여 그것만 찾아내라는 것을 의미한다. 그리고 그 결과가
        //위 함수가 optional이기 때문에 optional로 반환된다.

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
