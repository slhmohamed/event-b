package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Forum;
import tn.eesprit.gestionevenementback.Services.IForumService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class ForumController {
    private final IForumService forumService;
    @PostMapping("/add")
    Forum addForum(@RequestBody Forum forum)
    {
        return forumService.addOrUpdateForum(forum);
    }
    @PutMapping("/update")
    Forum updateForum(@RequestBody Forum forum){
        return forumService.addOrUpdateForum(forum);
    }
    @GetMapping("/get/{id}")
    Forum getForum(@PathVariable("id") Integer id){
        return forumService.retrieveForum(id);
    }
    @GetMapping("/all")
    List<Forum> getAllForums(){return forumService.retrieveAllForums();}
    @DeleteMapping("/delete/{id}")
    void deleteForum(@PathVariable("id") Integer id){
        forumService.removeForum(id);
    }

}
