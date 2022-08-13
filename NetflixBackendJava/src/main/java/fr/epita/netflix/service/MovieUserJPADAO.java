package fr.epita.netflix.service;

import fr.epita.netflix.datamodel.Movie;
import fr.epita.netflix.datamodel.MovieUser;
import fr.epita.netflix.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MovieUserJPADAO extends JPADAO<MovieUser>{
    public MovieUserJPADAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<MovieUser> getAll(Session session) {
        Query<MovieUser> query = session.createQuery(
                "from MovieUser m "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<MovieUser> get(Long id, Session session) {

        Query<MovieUser> query = session.createQuery(
                "from MovieUser m " +
                        "where (:id is null or :id = m.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }


    public List<MovieUser> searchWithRelationship(Session session) {

        Query<MovieUser> query = session.createQuery(
                "select distinct movieUser from MovieUser movieUser left join fetch movieUser.roles"
        );

        query.getQueryString();
        return query.list();

    }

    public List<MovieUser> searchOneWithRelationship(Long id,Session session) {

        Query<MovieUser> query = session.createQuery(
                "select movieUser from MovieUser movieUser left join fetch movieUser.roles where movieUser.id =:id"
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query.list();

    }
}
