package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Post;
import tn.eesprit.gestionevenementback.Repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService{
    private final PostRepository PostRepo;
    @Override
    public List<Post> retrieveAllPosts(){return PostRepo.findAll();}
    @Override
    public Post addOrUpdatePost(Post post){return PostRepo.save(post);}
    @Override
    public Post retrievePost(Integer id){return PostRepo.findById(id).orElse(null);}
    @Override
    public void removePost(Integer id){PostRepo.deleteById(id);}

}
