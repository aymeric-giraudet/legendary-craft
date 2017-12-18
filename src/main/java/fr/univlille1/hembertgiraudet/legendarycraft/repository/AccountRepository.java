package fr.univlille1.hembertgiraudet.legendarycraft.repository;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@RepositoryRestResource(exported = false)
@Transactional
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByUsername(@Param("username") String username);
}
