package io.ugurh.spring_guide.repository;

import io.ugurh.spring_guide.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

    List<Player> findByNationality(String nationality);

}
