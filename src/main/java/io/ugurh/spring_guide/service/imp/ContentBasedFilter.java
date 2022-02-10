package io.ugurh.spring_guide.service.imp;

import io.ugurh.spring_guide.domain.Movie;
import io.ugurh.spring_guide.service.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Primary
@Qualifier("contentBasedFilter")
//@Scope("Prototype") Option 1
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //Option 2
public class ContentBasedFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //for keeping track of instances created
    private static int instances= 0;

    private final Movie movie;

    public ContentBasedFilter(Movie movie) {
        super();
        this.movie = movie;
        instances++;
        logger.info("ContentBasedFilter constructor called");
    }

    @PostConstruct
    private void postConstruct() {
        //load movies into cache
        logger.info("In ContentBasedFilter postConstruct method");
    }

    @PreDestroy
    private void preDestroy() {
        //clear movies from cache
        logger.info("In ContentBasedFilter preDestroy method");
    }

    public Movie getMovie() {
        return movie;
    }

    public static int getInstances(){
        return ContentBasedFilter.instances;
    }

    @Override
    public String[] recommendMovies() {
        return new String[]{"Harry Potter"};
    }

}

