package org.crm.core.repositories;

import org.crm.common.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bezverkhniy_10534 on 21/07/2014.
 */
@RepositoryRestResource
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>, CrudRepository<UserRole, Long> {
    UserRole findByRoleName(@Param("name") String name);
}
