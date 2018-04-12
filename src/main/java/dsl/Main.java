package dsl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dsl.graph.ui.UIApi;

public class Main {



    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigImpl.class)) {

        	Bundle<UIApi> ui = context.getBean("uiBundle", Bundle.class);

            ui.api().calculatorController().run();


        }
    }

}
