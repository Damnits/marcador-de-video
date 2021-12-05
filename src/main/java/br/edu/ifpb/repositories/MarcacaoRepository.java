package br.edu.ifpb.repositories;

import br.edu.ifpb.model.Marcacao;
import br.edu.ifpb.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long> {
    @Query("SELECT b FROM tb_marcacao b WHERE b.video = ?1")
    List<Marcacao> findMarcacaosByVideo(Video id);
}
