package fr.epita.netflix.service;

import fr.epita.netflix.datamodel.MovieUser;
import fr.epita.netflix.datamodel.Role;
import fr.epita.netflix.datamodel.SeenMovie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SeenMovieJPADAO extends JPADAO<SeenMovie> {
    public SeenMovieJPADAO(SessionFactory sf) {

        super(sf);
    }
    @Override
    public Query<SeenMovie> getAll(Session session) {
        Query<SeenMovie> query = session.createQuery(
                "from SeenMovie s "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<SeenMovie> get(Long id, Session session) {

        Query<SeenMovie> query = session.createQuery(
                "from SeenMovie s " +
                        "where (:id is null or :id = s.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }
}
