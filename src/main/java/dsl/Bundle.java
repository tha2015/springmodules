package dsl;

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

        AnnotationConfigApplicationContext module = new AnnotationConfigApplicationContext();
        module.registerBean(config, dependentApis);
        module.refresh();

        U apiObject = module.getBean(api);

        return new Bundle<U>(module, apiObject);

    }

}
