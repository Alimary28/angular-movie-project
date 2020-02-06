package ro.ubb.movie.web.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClientDto extends BaseDto {
    private String cnp;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "ClientDto{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}'+ super.toString();
    }
}
