package mirea.dimedrol228.edu.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "hashtags")
@Data
public class Hashtag extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "hashtags")
    private List<Article> articles;
}
