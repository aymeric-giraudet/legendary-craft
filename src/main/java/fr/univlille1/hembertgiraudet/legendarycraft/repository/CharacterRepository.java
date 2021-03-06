package fr.univlille1.hembertgiraudet.legendarycraft.repository;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Account;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "character", path = "api/character")
@Transactional
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long>{
    List<Character> findByName(@Param("name") String name);
}
