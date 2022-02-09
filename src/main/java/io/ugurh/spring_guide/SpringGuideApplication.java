package io.ugurh.spring_guide;

import io.ugurh.spring_guide.domain.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringGuideApplication {

    public static void main(String[] args) {
        //ApplicationContext manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(
                SpringGuideApplication.class, args);

        //use ApplicationContext to find which filter is being used
        RecommenderImplementation recommender = appContext.getBean(
                RecommenderImplementation.class);

        //call method to get recommendations
        String[] result = recommender.recommendMovies();

        //display results
        System.out.println(Arrays.toString(result));
    }

}
