package fr.epita.netflix.service;

import fr.epita.netflix.datamodel.Contact;
import fr.epita.netflix.datamodel.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ContactJPADAO extends JPADAO<Contact>{
    public ContactJPADAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<Contact> getAll(Session session) {
        Query<Contact> query = session.createQuery(
                "from Contact c "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<Contact> get(Long id, Session session) {

        Query<Contact> query = session.createQuery(
                "from Contact c " +
                        "where (:id is null or :id = c.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }

}
