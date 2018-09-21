package com.dssd.grupo8.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T> extends EntityGraphJpaRepository<T, Long> {

    @Query("SELECT 1;")
    void testConnection();

}
