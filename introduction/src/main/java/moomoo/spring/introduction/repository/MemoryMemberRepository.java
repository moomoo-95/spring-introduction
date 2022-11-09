package moomoo.spring.introduction.repository;

import moomoo.spring.introduction.domain.Member;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<String, Member> store = new ConcurrentHashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return store.values().stream().collect(Collectors.toList());
    }

    public void clearStore() {
        store.clear();
    }
}
