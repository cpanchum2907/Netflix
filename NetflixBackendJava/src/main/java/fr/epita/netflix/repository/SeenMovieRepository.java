package fr.epita.netflix.repository;

import fr.epita.netflix.datamodel.MovieUser;
import fr.epita.netflix.datamodel.SeenMovie;
import fr.epita.netflix.service.MovieUserJPADAO;
import fr.epita.netflix.service.SeenMovieJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class SeenMovieRepository {
    private final SessionFactory sessionFactory;
    private final SeenMovieJPADAO seenMovieJPADAO;

    public SeenMovieRepository(SessionFactory sf,
                               SeenMovieJPADAO seenMovieDAO
    ) {
        this.sessionFactory = sf;
        this.seenMovieJPADAO = seenMovieDAO;
    }

    public List<SeenMovie> getMovieUser() {
        Session session = getSession();
        List<SeenMovie> searchResult = this.seenMovieJPADAO.search();
        return searchResult;
    }

    @Transactional
    public SeenMovie createMovieUser(SeenMovie seenMovie){
        this.seenMovieJPADAO.create(seenMovie);
        return getMovieUser().get(0);
    }

    public List<SeenMovie> getById(Long id) {
        Session session = getSession();
        List<SeenMovie> searchResult = this.seenMovieJPADAO.search(id);
        return searchResult;
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
