package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Post;

import java.util.List;

public interface IPostService {
    List<Post> retrieveAllPosts();
    Post addOrUpdatePost(Post Post);
    Post retrievePost(Integer id);
    void removePost(Integer id);
}
