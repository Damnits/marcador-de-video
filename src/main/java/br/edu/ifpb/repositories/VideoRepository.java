package br.edu.ifpb.repositories;

import br.edu.ifpb.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
