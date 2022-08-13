package fr.epita.netflix;

import fr.epita.netflix.repository.*;
import fr.epita.netflix.service.*;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class NetflixBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(NetflixBackendApplication.class);
	}

	@Bean
	public UserJPADAO getUserDAO(SessionFactory sf){
		return new UserJPADAO(sf);
	}
	@Bean
	public RoleJPADAO getRoleDAO(SessionFactory sf){
		return new RoleJPADAO(sf);
	}
	@Bean
	public MovieJPADAO getMovieDAO(SessionFactory sf){
		return new MovieJPADAO(sf);
	}
	@Bean
	public MovieUserJPADAO getMovieUserDAO(SessionFactory sf){
		return new MovieUserJPADAO(sf);
	}
	@Bean
	public ContactJPADAO getContactDAO(SessionFactory sf){
		return new ContactJPADAO(sf);
	}
	@Bean
	public SeenMovieJPADAO getSeenMovieDAO(SessionFactory sf){
		return new SeenMovieJPADAO(sf);
	}
	@Bean
	public AdressJPADAO getAdressDAO(SessionFactory sf){
		return new AdressJPADAO(sf);
	}



	@Bean
	public UserRepository getUserRepository(SessionFactory sf,
											UserJPADAO userDao
	){
		return new UserRepository(sf, userDao);
	}

	@Bean
	public RoleRepository getRoleRepository(SessionFactory sf,
											RoleJPADAO roleDAO
	){
		return new RoleRepository(sf, roleDAO);
	}

	@Bean
	public MovieRepository getMovieRepository(SessionFactory sf,
											 MovieJPADAO movieDAO
	){
		return new MovieRepository(sf, movieDAO);
	}

	@Bean
	public MovieUserRepository getMovieUserRepository(SessionFactory sf,
													  MovieUserJPADAO movieUserDAO
	){
		return new MovieUserRepository(sf, movieUserDAO);
	}

	@Bean
	public ContactRepository getContactRepository(SessionFactory sf,
												  ContactJPADAO contactDao
	){
		return new ContactRepository(sf, contactDao);
	}

	@Bean
	public SeenMovieRepository getMovieUserRepository(SessionFactory sf,
													  SeenMovieJPADAO seenMovieDAO
	){
		return new SeenMovieRepository(sf, seenMovieDAO);
	}


	@Bean
	public AdressRepository getAdressRepository(SessionFactory sf,
												AdressJPADAO adressDAO
	){
		return new AdressRepository(sf, adressDAO);
	}


}

