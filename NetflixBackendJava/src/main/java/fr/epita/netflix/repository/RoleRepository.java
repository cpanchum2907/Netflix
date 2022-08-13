package fr.epita.netflix.repository;

import fr.epita.netflix.datamodel.Role;
import fr.epita.netflix.datamodel.User;
import fr.epita.netflix.service.RoleJPADAO;
import fr.epita.netflix.service.UserJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.util.ProxyUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

public class RoleRepository {

    private final SessionFactory sessionFactory;
    private final RoleJPADAO roleJPADAO;


    public RoleRepository(SessionFactory sf,
                          RoleJPADAO roleDAO
    ) {
        this.sessionFactory = sf;
        this.roleJPADAO = roleDAO;
    }

    @Transactional
    public Role createRole(Role role){
        this.roleJPADAO.create(role);
        return getRoles().get(0);
    }

    public List<Role> getRoles() {
        Session session = getSession();
        List<Role> searchResult = this.roleJPADAO.search();
        return searchResult;
    }

    public Role getById(Long id){
        Session session = getSession();
        List<Role> searchResult = this.roleJPADAO.search(id);
        return searchResult.get(0);
    }

    @Transactional
    public void deleteByName(String name) {

            this.roleJPADAO.delete(name);

    }



    private Session getSession() {
        Session currentSession = null;
        try {
            currentSession = this.sessionFactory.getCurrentSession();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (currentSession != null && currentSession.isOpen()) {
            return currentSession;
        } else {
            return this.sessionFactory.openSession();
        }
    }


}
