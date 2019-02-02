package org.integrahackaton.dao;

import org.integrahackaton.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(User user) {
        manager.persist(user);
    }

    public List<User> listar() {
        return manager.createQuery("FROM user", User.class).getResultList();
    }

    public User find(Integer id) {
        return manager.find(User.class, id);
    }
}
