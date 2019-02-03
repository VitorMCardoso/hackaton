package org.integrahackaton.dao;

import org.integrahackaton.model.Person;
import org.integrahackaton.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Person person) {
        manager.persist(person);
    }

    public List<Person> listar() {
        return manager.createQuery("FROM person", Person.class).getResultList();
    }

    public Person findById(Integer id) {
        return manager.find(Person.class, id);
    }

    public List<Person> findByDoc(String documento) {
        String jpql = "FROM person p WHERE p.documento LIKE '%'||:pDoc||'%'";
        TypedQuery<Person> query = manager.createQuery(jpql, Person.class);
        query.setParameter("pDoc", documento);
        return query.getResultList();
        //Query q = manager.createQuery("FROM person p WHERE p.documento =:arg1", Person.class);
        //q.setParameter("arg1", documento).getSingleResult();
        //return manager(Person.class);
    }

    public List<Person> findByNome(String nome) {
        String jpql = "FROM person p WHERE p.nome LIKE '%'||:pDoc||'%'";
        TypedQuery<Person> query = manager.createQuery(jpql, Person.class);
        query.setParameter("pDoc", nome);
        return query.getResultList();
        //Query q = manager.createQuery("FROM person p WHERE p.documento =:arg1", Person.class);
        //q.setParameter("arg1", documento).getSingleResult();
        //return manager(Person.class);
    }

}
