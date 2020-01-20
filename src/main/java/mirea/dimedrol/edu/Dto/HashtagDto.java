package mirea.dimedrol.edu.Dto;

import lombok.Data;
import mirea.dimedrol.edu.Model.HashtagDao;

@Data
public class HashtagDto {
    private String name;
    private String description;

    public HashtagDto() {}

    public HashtagDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public HashtagDao toDAO() {
        HashtagDao hashtagDao = new HashtagDao();
        hashtagDao.setName(name);
        hashtagDao.setDescription(description);

        return hashtagDao;
    }
}
