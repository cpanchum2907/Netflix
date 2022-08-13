package fr.epita.netflix.repository;

import fr.epita.netflix.datamodel.Address;
import fr.epita.netflix.datamodel.Contact;
import fr.epita.netflix.service.AdressJPADAO;
import fr.epita.netflix.service.ContactJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class AdressRepository {
    private final SessionFactory sessionFactory;
    private final AdressJPADAO adressJPADAO;

    public AdressRepository(SessionFactory sf,
                            AdressJPADAO adressDAO
    ) {
        this.sessionFactory = sf;
        this.adressJPADAO = adressDAO;
    }

    public List<Address> getAddress() {
        Session session = getSession();
        List<Address> searchResult = this.adressJPADAO.search();
        return searchResult;
    }

    @Transactional
    public Address createAddress(Address address){
        this.adressJPADAO.create(address);
        return getAddress().get(0);
    }

    public Address getById(Long id){
        Session session = getSession();
        List<Address> searchResult = this.adressJPADAO.search(id);
        return searchResult.get(0);
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
