package ro.ubb.movie.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity<Long> {
    private String title;
    private String category;
    private String year;
    private double price;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}
