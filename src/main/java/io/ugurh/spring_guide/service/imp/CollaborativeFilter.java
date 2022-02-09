package io.ugurh.spring_guide.service.imp;

import io.ugurh.spring_guide.service.Filter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Option 2
public class CollaborativeFilter implements Filter {
    @Override
    public String[] recommendMovies() {
        return new String[0];
    }
}
