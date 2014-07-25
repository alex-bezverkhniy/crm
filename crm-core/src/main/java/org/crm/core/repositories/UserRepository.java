package org.crm.core.repositories;

import org.crm.common.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by alex-dev on 7/23/14.
 */
@RepositoryRestResource
@Secured("ROLE_USER")
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    User findByUserName(String name);
}
