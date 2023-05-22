package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Forum;
import tn.eesprit.gestionevenementback.Repository.ForumRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements IForumService{
    private final ForumRepository ForumRepo;
    @Override
    public List<Forum> retrieveAllForums(){return ForumRepo.findAll();}
    @Override
    public Forum addOrUpdateForum(Forum forum){return ForumRepo.save(forum);}
    @Override
    public Forum retrieveForum(Integer id){return ForumRepo.findById(id).orElse(null);}
    @Override
    public void removeForum(Integer id){ForumRepo.deleteById(id);}

}
