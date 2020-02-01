package mirea.dimedrol228.edu.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course extends BaseEntity {
    private String title;

    @ManyToOne
    private User course_author;

    //@ManyToMany//TODO: persistence
    //private List<CourseContent> contents; //article could have field day or week



    //list of enrolled users
    //list of graduated users;

}
