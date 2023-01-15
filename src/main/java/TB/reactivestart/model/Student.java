package TB.reactivestart.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private String id;
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
