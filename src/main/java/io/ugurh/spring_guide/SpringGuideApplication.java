package io.ugurh.spring_guide;

import io.ugurh.spring_guide.domain.CollaborativeFilter;
import io.ugurh.spring_guide.domain.ContentBasedFilter;
import io.ugurh.spring_guide.domain.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringGuideApplication {

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
        //Retrieve prototype bean from application context thrice
        ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbf3 = appContext.getBean(ContentBasedFilter.class);

        System.out.println("ContentBasedFilter 1 -> " + cbf1);
        System.out.println("ContentBasedFilter 2 -> " + cbf2);
        System.out.println("ContentBasedFilter 3 -> " + cbf3);

        //Retrieve singleton bean from application context thrice
        CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
        CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);
        CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);

        System.out.println("CollaborativeFilter 1 -> " + cf1);
        System.out.println("CollaborativeFilter 2 -> " + cf2);
        System.out.println("CollaborativeFilter 3 -> " + cf3);
    }

}
