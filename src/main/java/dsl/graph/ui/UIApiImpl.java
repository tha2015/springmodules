package dsl.graph.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dsl.graph.business.BusinessApi;

@Configuration
public class UIApiImpl implements UIApi {

	@Autowired
    private BusinessApi businessApi;

    @Bean
    @Override
    public CalculatorController calculatorController() {
        return new CalculatorController(businessApi.calculator());
    }

}
