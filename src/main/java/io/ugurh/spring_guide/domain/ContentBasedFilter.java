package io.ugurh.spring_guide.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("contentBasedFilter")
//@Scope("Prototype") Option 1
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Option 2
public class ContentBasedFilter implements Filter{
    @Override
    public String[] recommendMovies() {
        return new String[]{"Harry Potter"};
    }
}
