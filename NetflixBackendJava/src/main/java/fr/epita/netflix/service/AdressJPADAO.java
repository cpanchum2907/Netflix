package fr.epita.netflix.service;

import fr.epita.netflix.datamodel.Address;
import fr.epita.netflix.datamodel.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AdressJPADAO extends JPADAO<Address> {
    public AdressJPADAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<Address> getAll(Session session) {
        Query<Address> query = session.createQuery(
                "from Address a "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<Address> get(Long id, Session session) {

        Query<Address> query = session.createQuery(
                "from Address a " +
                        "where (:id is null or :id = a.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }
}
