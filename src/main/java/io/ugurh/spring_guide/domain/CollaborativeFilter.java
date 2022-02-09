package io.ugurh.spring_guide.domain;

import org.springframework.stereotype.Component;

@Component
public class CollaborativeFilter implements Filter{
    @Override
    public String[] recommendMovies() {
        return new String[0];
    }
}
