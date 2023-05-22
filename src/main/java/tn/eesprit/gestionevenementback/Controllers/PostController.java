package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Post;
import tn.eesprit.gestionevenementback.Services.IPostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final IPostService postService;
    @PostMapping("/add")
    Post addPost(@RequestBody Post post)
    {
        return postService.addOrUpdatePost(post);
    }
    @PutMapping("/update")
    Post updatePost(@RequestBody Post post){
        return postService.addOrUpdatePost(post);
    }
    @GetMapping("/get/{id}")
    Post getPost(@PathVariable("id") Integer id){
        return postService.retrievePost(id);
    }
    @GetMapping("/all")
    List<Post> getAllPosts(){return postService.retrieveAllPosts();}
    @DeleteMapping("/delete/{id}")
    void deletePost(@PathVariable("id") Integer id){
        postService.removePost(id);
    }

}
