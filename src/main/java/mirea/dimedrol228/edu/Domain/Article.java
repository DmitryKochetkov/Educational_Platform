package mirea.dimedrol228.edu.Domain;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "articles")
@Data
public class Article extends CourseContent {
    @Column(name = "header")
    private String header;

    @Column(name = "content_path")
    private String content_path;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "articles_hashtags",
            joinColumns = { @JoinColumn(name = "article_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "hashtag_id", referencedColumnName = "id")}
    )
//    @Column(name = "hashtags")
    private List<Hashtag> hashtags;

    public String getCreatedFormatted() {
        Locale locale = new Locale("ru", "RU");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(getCreated());

        return date;
    }

    //TODO: Set<User> views;
}
