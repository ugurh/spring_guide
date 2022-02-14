package io.ugurh.spring_guide.service;

import io.ugurh.spring_guide.service.imp.XXXBasedFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Field injection
    //@Autowired
    final Filter filter;
    //Solution 2: Bean with matching name is injected
    // final Filter contentBasedFilter;

    @Inject
    XXXBasedFilter xxxBasedFilter;
    //Constructor injection
    public RecommenderImplementation(@Qualifier("contentBasedFilter") Filter filter) {
        this.filter = filter;
    }

    @PostConstruct
    public void postConstruct() {
        //initialization code goes here
        logger.info("In RecommenderImplementation postConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }

    /** Setter injection
    Using field injection keeps the code simple and readable,
    but it is unsafe because Spring can set private fields of the objects.
    Testing also becomes inconvenient because we need a way to perform dependency injection for testing.
    Yet another disadvantage is that a developer may add a lot of optional dependencies which can make the application complex.
     If there was a constructor,
    then each additional dependency would result in increasing the number of arguments of the constructor.
    */
   /*
    public void setFilter(Filter filter) {
        this.filter = filter;
    } */

    //use a filter to find recommendations
    public String[] recommendMovies() {
        logger.info("Get Recommend Movies");
        String[] results = filter.recommendMovies();
        return results;
    }

    @Value("${recommender.implementation.favoriteMovie:Default Movie}")
    String favoriteMovie;
    public String getFavoriteMovie() {
        return favoriteMovie;
    }

}
