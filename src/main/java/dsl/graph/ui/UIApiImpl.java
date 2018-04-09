package dsl.graph.ui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dsl.graph.business.BusinessApi;

@Configuration
public class UIApiImpl implements UIApi {

    private BusinessApi businessApi;

    public UIApiImpl(BusinessApi businessApi) {
        this.businessApi = businessApi;
    }

    @Bean
    @Override
    public CalculatorController calculatorController() {
        return new CalculatorController(businessApi.calculator());
    }

}
