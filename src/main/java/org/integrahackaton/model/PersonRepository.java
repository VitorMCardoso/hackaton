package org.integrahackaton.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository("personRepository")
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("from Product where name like %:keyword%")
    public Person search(@Param("keyword") String keyword);
    //Optional<Person> findByDocumentoAndAndNome(String documento, String nome);
}
