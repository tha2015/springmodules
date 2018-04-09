package dsl;

import dsl.graph.business.BusinessApi;
import dsl.graph.business.BusinessApiImpl;
import dsl.graph.ui.UIApi;
import dsl.graph.ui.UIApiImpl;

public class Main {



    public static void main(String[] args) {

        try (Bundle<BusinessApi> businessBundle = Bundle.of(BusinessApiImpl.class, BusinessApi.class);
            Bundle<UIApi> uiBundle = Bundle.of(UIApiImpl.class, UIApi.class, businessBundle.api())) {

            uiBundle.api().calculatorController().run();

        }
    }

}
