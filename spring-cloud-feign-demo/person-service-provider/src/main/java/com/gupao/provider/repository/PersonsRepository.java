package com.gupao.provider.repository;

import com.gupao.provider.entity.PersonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends PagingAndSortingRepository<PersonEntity,Long> {
}
