package mirea.dimedrol228.edu.Domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class CourseContent extends BaseEntity {
    private Integer week;
}
