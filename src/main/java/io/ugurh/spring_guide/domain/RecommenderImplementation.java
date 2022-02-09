package io.ugurh.spring_guide.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    // Field injection
    //@Autowired
    final Filter filter;
    //Solution 2: Bean with matching name is injected
    // final Filter contentBasedFilter;

    //Constructor injection
    public RecommenderImplementation(@Qualifier("contentBasedFilter") Filter filter) {
        this.filter = filter;
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

        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.recommendMovies();

        return results;
    }

}
