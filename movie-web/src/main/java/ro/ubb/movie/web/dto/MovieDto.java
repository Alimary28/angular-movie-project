package ro.ubb.movie.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto extends BaseDto{

    private String title;
    private String category;
    private String year;
    private double price;

    @Override
    public String toString() {
        return "MovieDto{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}
