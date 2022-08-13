package fr.epita.netflix.repository;

import fr.epita.netflix.datamodel.Contact;
import fr.epita.netflix.datamodel.Movie;
import fr.epita.netflix.service.ContactJPADAO;
import fr.epita.netflix.service.MovieJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class ContactRepository {
    private final SessionFactory sessionFactory;
    private final ContactJPADAO contacctJPADAO;

    public ContactRepository(SessionFactory sf,
                           ContactJPADAO contactDAO
    ) {
        this.sessionFactory = sf;
        this.contacctJPADAO = contactDAO;
    }

    public List<Contact> getContacts() {
        Session session = getSession();
        List<Contact> searchResult = this.contacctJPADAO.search();
        return searchResult;
    }

    @Transactional
    public Contact createContact(Contact contact){
        this.contacctJPADAO.create(contact);
        return getContacts().get(0);
    }

    public Contact getById(Long id){
        Session session = getSession();
        List<Contact> searchResult = this.contacctJPADAO.search(id);
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
