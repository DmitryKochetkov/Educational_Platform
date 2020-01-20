package mirea.dimedrol.edu.Service;

import mirea.dimedrol.edu.Model.HashtagDao;

public interface IHashtagService {
    HashtagDao createHashtag(HashtagDao hashtag);
    HashtagDao findByName(String name);
//    HashtagDao editHashtag(String decription); ???
}
