package hello.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private Grade grade;


    public Member(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
}
