package br.edu.ifpb.controller;

import br.edu.ifpb.model.Video;
import br.edu.ifpb.repositories.VideoRepository;
import br.edu.ifpb.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    List<Video> getAll(){
        return videoService.findAll();
    }

    @PostMapping
    Video newVideo(@RequestBody Video newVideo){
        return videoService.insert(newVideo);
    }

    @GetMapping("/{id}")
    Video get(@PathVariable Long id){
        return videoService.findById(id);
    }
    @PutMapping("/{id}")
    Video replaceVideo(@RequestBody Video newVideo, @PathVariable Long id){
        return videoService.update(id, newVideo);
    }

    @DeleteMapping("/{id}")
    void deleteVideo(@PathVariable Long id){
            videoService.delete(id);
        }
}
