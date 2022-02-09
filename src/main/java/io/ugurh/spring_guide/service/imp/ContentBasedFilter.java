package io.ugurh.spring_guide.service.imp;

import io.ugurh.spring_guide.domain.Movie;
import io.ugurh.spring_guide.service.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("contentBasedFilter")
//@Scope("Prototype") Option 1
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //Option 2
public class ContentBasedFilter implements Filter {
    //for keeping track of instances created
    private static int instances= 0;

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        super();
        instances++;
        System.out.println("ContentBasedFilter constructor called");
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

