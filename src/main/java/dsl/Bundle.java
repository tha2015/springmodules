package dsl;

import java.time.Instant;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public 	class Bundle<T> implements AutoCloseable {

    private final ConfigurableApplicationContext context;
    private final T api;

    private Bundle(ConfigurableApplicationContext context, T api) {
        this.context = context;
        this.api = api;
    }

    public ConfigurableApplicationContext module() {
        return context;
    }

    public T api() {
        return api;
    }

    @Override
    public void close() {
        context.close();
    }

    public static <U> Bundle<U> of(Class<?> config, Class<U> api, Object... dependentApis) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        for (Object dependentApi : dependentApis) {
        	context.getBeanFactory().registerSingleton(dependentApi.toString() + '/' + Instant.now(), dependentApi);
        }

        context.registerBean(config);
        context.refresh();

        U apiObject = context.getBean(api);

        return new Bundle<U>(context, apiObject);

    }

}
