package br.edu.ifpb.controller;


import br.edu.ifpb.model.Marcacao;
import br.edu.ifpb.services.MarcacaoService;
import br.edu.ifpb.services.VideoService;
import br.edu.ifpb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarcacaoController {
    @Autowired
    private MarcacaoService marcacaoService;

    @Autowired
    private VideoService videoService;
    @GetMapping("/video/{videoId}/marcacoes")
    public List<Marcacao> getAllMarcacoesByVideoId(@PathVariable(value = "videoId") Long videoId){
        return marcacaoService.findByIdVideo(videoService.findById(videoId));
    }

    @PostMapping("/video/{videoId}/marcacoes")
    public Marcacao newMarcacao(@PathVariable(value = "videoId") Long videoId,
                                @RequestBody Marcacao newMarcacao){
        newMarcacao.setVideo(videoService.findById(videoId));
        return marcacaoService.insert(newMarcacao);
    }

    @PutMapping("/video/{videoId}/marcacoes/{marcacaoId}")
    public Marcacao updateMarcacao(@PathVariable(value = "videoId") Long videoId,
                                   @PathVariable(value = "marcacaoId") Long marcacaoId,
                                   @RequestBody Marcacao newMarcacao){
        if(videoService.findById(videoId)==null){
            throw new ResourceNotFoundException("Video id"+ videoId + "não encontrada");
        }
        if(marcacaoService.findById(marcacaoId)==null){
            throw new ResourceNotFoundException("Marcacao id"+ marcacaoId + "não encontrada");
        }
        return marcacaoService.update(marcacaoId, newMarcacao);
    }
    @DeleteMapping("/video/{videoId}/marcacoes/{marcacaoId}")
    public void deleteMarcacao(@PathVariable (value="videoId") Long videoId,
                               @PathVariable (value = "marcacaoId") Long marcacaoId){
        marcacaoService.delete(marcacaoId);
    }
}
