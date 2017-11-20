package fr.univlille1.hembertgiraudet.legendarycraft.repository;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends PagingAndSortingRepository<Character, Long>{
    List<Character> findByName(@Param("name") String name);
}
