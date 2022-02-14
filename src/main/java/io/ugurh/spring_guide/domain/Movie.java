package io.ugurh.spring_guide.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Movie {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //for keeping track of instances created
    private static int instances = 0;

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        super();
        instances++;
        System.out.println("Movie constructor called");
        logger.info("Movie constructor called");
    }

    @PostConstruct
    private void postConstruct() {
        //initialization code
        logger.info("In Movie postConstruct method");
    }

    public static int getInstances() {
        return Movie.instances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}