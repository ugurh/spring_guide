package io.ugurh.spring_guide;

import io.ugurh.spring_guide.dao.PlayerDao;
import io.ugurh.spring_guide.dao.TournamentDao;
import io.ugurh.spring_guide.domain.Movie;
import io.ugurh.spring_guide.domain.Player;
import io.ugurh.spring_guide.service.imp.CollaborativeFilter;
import io.ugurh.spring_guide.service.imp.ContentBasedFilter;
import io.ugurh.spring_guide.service.RecommenderImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication
//@ComponentScan(basePackages="io.ugurh.xx")
//@ComponentScan(includeFilters = @ComponentScan.Filter (type= FilterType.REGEX, pattern="io.ugurh.yy.*"))
public class SpringGuideApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;

    @Autowired
    TournamentDao tournamentDao;

    public static void main(String[] args) {
        //ApplicationContext manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(SpringGuideApplication.class, args);

        //use ApplicationContext to find which filter is being used
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

        //call method to get recommendations
        String[] result = recommender.recommendMovies();

        //display results
        System.out.println(Arrays.toString(result));

        System.out.println("*******************************");
        //Retrieve singleton  bean from application context thrice
        ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbf3 = appContext.getBean(ContentBasedFilter.class);

        System.out.println("ContentBasedFilter 1 -> " + cbf1);
        System.out.println("ContentBasedFilter 2 -> " + cbf2);
        System.out.println("ContentBasedFilter 3 -> " + cbf3);

        //Retrieve prototype bean from application context thrice
        CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
        CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);
        CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);

        System.out.println("CollaborativeFilter 1 -> " + cf1);
        System.out.println("CollaborativeFilter 2 -> " + cf2);
        System.out.println("CollaborativeFilter 3 -> " + cf3);

        System.out.println("-----------------------------------");

        //Retrieve prototype bean from the singleton bean thrice
        Movie movie1 = cbf1.getMovie();
        Movie movie2 = cbf1.getMovie();
        Movie movie3 = cbf1.getMovie();

        System.out.println("\nMovie bean with prototype scope");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);

        //Print number of instances of each bean
        System.out.println("\nContentBasedFilter instances created: " +
                ContentBasedFilter.getInstances());
        System.out.println("Movie instances created: " + Movie.getInstances());

        System.out.println("=========================");
        System.out.println(recommender);

        //Retrieving prototype bean from application context twice
        Movie m1 = appContext.getBean(Movie.class);
        System.out.println(m1);

        Movie m2 = appContext.getBean(Movie.class);
        System.out.println(m2);
    }

    @Override
    public void run(String... args) {
        logger.info("All Players Data: {}", dao.getAllPlayers());

        logger.info("Player with Id 3: {}", dao.getPlayerById(3));

        logger.info("Inserting Player 4: {}",
                dao.insertPlayer(new Player(4, "Thiem", "AUSTRIA", new Date(System.currentTimeMillis()), 17)));

        logger.info("All Players Data: {}", dao.getAllPlayers());

        //Updating a player
        logger.info("Updating Player with Id 4: {}",
                dao.updatePlayer(new Player(4, "Thiem", "AUSTRIA", Date.valueOf("1993-09-03"), 17)));

        //View player by Id
        logger.info("Players with Id 4: {}", dao.getPlayerById(4));

        logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));

        logger.info("All Players Data: {}", dao.getAllPlayers());

        tournamentDao.createTournamentTable();
    }
}

