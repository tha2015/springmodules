package dsl;

import java.time.Instant;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public 	class BundleImpl<T> implements Bundle<T>, AutoCloseable {

    private final ConfigurableApplicationContext context;
    private final T api;

    private BundleImpl(ConfigurableApplicationContext context, T api) {
        this.context = context;
        this.api = api;
    }

    @Override
    public T api() {
        return api;
    }

    @Override
    public void close() {
        context.close();
    }


    public static <U> Bundle<U> of(Class<?> javaConfigClass, Class<U> apiBeanType, Bundle<?>... dependentBundles) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        for (Bundle<?> dependentBundle : dependentBundles) {
        	context.getBeanFactory().registerSingleton(dependentBundle.api().getClass().getName() + '/' + Instant.now(), dependentBundle.api());
        }

        context.registerBean(javaConfigClass);
        context.refresh();

        U apiObject = context.getBean(apiBeanType);

        return new BundleImpl<U>(context, apiObject);

    }
}
