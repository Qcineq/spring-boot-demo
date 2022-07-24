package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "{book.title}")
    @NotNull
    private String title;

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 600, message = "{book.description}")
    @NotNull
    private String description;

    @ManyToOne
    @NotNull
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    @Min(1)
    private int pages;

    @ManyToOne
    @NotNull
    private Category category;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}