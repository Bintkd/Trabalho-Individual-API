package org.serratec.serratec_music.repository;

import org.serratec.serratec_music.domain.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {

}
