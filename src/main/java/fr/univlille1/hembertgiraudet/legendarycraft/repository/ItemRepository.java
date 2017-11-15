package fr.univlille1.hembertgiraudet.legendarycraft.repository;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>{
    List<Item> findByName(@Param("name") String name);
}
