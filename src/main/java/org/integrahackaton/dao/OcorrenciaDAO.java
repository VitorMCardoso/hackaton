package org.integrahackaton.dao;

import org.integrahackaton.model.Ocorrencia;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class OcorrenciaDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Ocorrencia ocorrencia) {
        manager.persist(ocorrencia);
    }

    public List<Ocorrencia> listar() {
        return manager.createQuery("SELECT o FROM ocorrencia2 o", Ocorrencia.class).getResultList();
    }

    public Ocorrencia findById(Integer id) {
        return manager.find(Ocorrencia.class, id);
    }

    /*public List<Ocorrencia> findByLog(String logradouro) {
        String jpql = "FROM ocorrencia i WHERE i.logradouro LIKE '%'||:pLog||'%'";
        TypedQuery<Ocorrencia> query = manager.createQuery(jpql, Ocorrencia.class);
        query.setParameter("pLog", logradouro);
        return query.getResultList();
        //Query q = manager.createQuery("FROM person p WHERE p.documento =:arg1", Person.class);
        //q.setParameter("arg1", documento).getSingleResult();
        //return manager(Person.class);
    }*/
}
