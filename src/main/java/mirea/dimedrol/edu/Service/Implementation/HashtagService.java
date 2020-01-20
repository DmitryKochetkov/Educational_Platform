package mirea.dimedrol.edu.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Dto.HashtagDto;
import mirea.dimedrol.edu.Model.HashtagDao;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Repository.HashtagRepository;
import mirea.dimedrol.edu.Service.IHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class HashtagService implements IHashtagService {

    HashtagRepository hashtagRepository;

    @Autowired
    public HashtagService(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public HashtagDao createHashtag(HashtagDao hashtag) {
        hashtag.setCreated(new Date());
        hashtag.setUpdated(new Date());

            HashtagDao createdHashtag = hashtagRepository.save(hashtag);
            log.info("IN createHashtag - hashtag with name {} created", createdHashtag.getName());
            return createdHashtag;
    }

    @Override
    public HashtagDao findByName(String name) {
        HashtagDao result = hashtagRepository.findByName(name);
        if (result == null)
            log.info("IN findByName - no hashtag {} found", name);
        else log.info("IN findByName - hashtag {} successfully found by name {}", result, name);

        return result;
    }

    @Override
    public HashtagDao editHashtag(HashtagDao hashtag, String description) {
        hashtag.setDescription(description);
        hashtag.setUpdated(new Date());
        hashtagRepository.save(hashtag);
        log.info("IN editHashtag - hashtag with name {} edited. New description: {}", hashtag.getName(), hashtag.getDescription());
        return hashtag;
    }
}
