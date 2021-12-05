package br.edu.ifpb.services;

import br.edu.ifpb.model.Video;
import br.edu.ifpb.repositories.VideoRepository;
import br.edu.ifpb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    public List<Video> findAll(){
        return repository.findAll();
    }

    public Video findById(Long id){
        return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
    }

    public Video insert(Video obj){
        return repository.save(obj);
    }
    public Video update(Long id, Video obj){
        try {
            Video entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Video entity, Video obj) {
        entity.setLink(obj.getLink());
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
