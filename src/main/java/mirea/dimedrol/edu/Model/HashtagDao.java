package mirea.dimedrol.edu.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hashtags")
@Data
public class HashtagDao extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "hashtags")
    @Column
    private List<ArticleDao> articles;
}
