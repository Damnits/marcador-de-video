package br.edu.ifpb.services;

import br.edu.ifpb.model.Marcacao;
import br.edu.ifpb.model.Video;
import br.edu.ifpb.repositories.MarcacaoRepository;
import br.edu.ifpb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MarcacaoService {
    @Autowired
    private MarcacaoRepository marcacaoRepository;

    public List<Marcacao> findAll(){
        return marcacaoRepository.findAll();
    }

    public Marcacao findById(Long id){
        return marcacaoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }
    public Marcacao insert(Marcacao obj){
        return marcacaoRepository.save(obj);
    }

    public Marcacao update(Long id, Marcacao obj){
        try {
            Marcacao entity = marcacaoRepository.getById(id);
            updateData(entity, obj);
            return marcacaoRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Marcacao entity, Marcacao obj){
        entity.setNome(obj.getNome());
        entity.setTempo_inicio(obj.getTempo_inicio());
        entity.setTempo_fim(obj.getTempo_fim());
    }

    public List<Marcacao> findByIdVideo(Video video){
        return marcacaoRepository.findMarcacaosByVideo(video);
    }


    public void delete(Long id){
        try{
            marcacaoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
