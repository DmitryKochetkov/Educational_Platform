package mirea.dimedrol228.edu.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article extends BaseEntity {
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
}