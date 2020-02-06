package ro.ubb.movie.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Client extends BaseEntity<Long> {

    private String cnp;
    private String firstName;
    private String lastName;
    private int age;
}
