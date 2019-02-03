package org.integrahackaton.dao;

import org.integrahackaton.model.Imovel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ImovelDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Imovel imovel) {
        manager.persist(imovel);
    }

    public List<Imovel> listar() {
        return manager.createQuery("SELECT i FROM imovel i", Imovel.class).getResultList();
    }

    public Imovel findById(Integer id) {
        return manager.find(Imovel.class, id);
    }

    public List<Imovel> findByLog(String logradouro) {
        String jpql = "SELECT i FROM imovel i WHERE i.logradouro LIKE '%'||:pLog||'%'";
        TypedQuery<Imovel> query = manager.createQuery(jpql, Imovel.class);
        query.setParameter("pLog", logradouro);
        return query.getResultList();
        //Query q = manager.createQuery("FROM person p WHERE p.documento =:arg1", Person.class);
        //q.setParameter("arg1", documento).getSingleResult();
        //return manager(Person.class);
    }
}
