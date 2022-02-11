package io.ugurh.spring_guide.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named // coming from spring
public class XXXBasedFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void postConstruct() {
        //initialization code goes here
        logger.info("In XXXBasedFilter postConstruct method");
    }
}
