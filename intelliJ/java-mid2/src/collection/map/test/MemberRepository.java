package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private Map<String, Member> repository = new HashMap<>();

    public void save(Member member) {
        repository.put(member.getId(), member);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public Member findById(String id) {
        return repository.get(id);
    }

    public Member findByName(String name) {
        for (Member member : repository.values()) {
            if(member.getName().equals(name))
                return member;
        }

        return null;
    }

}
