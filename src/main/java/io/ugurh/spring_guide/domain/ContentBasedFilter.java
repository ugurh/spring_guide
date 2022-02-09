package io.ugurh.spring_guide.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("contentBasedFilter")
public class ContentBasedFilter implements Filter{
    @Override
    public String[] recommendMovies() {
        return new String[]{"Harry Potter"};
    }
}
