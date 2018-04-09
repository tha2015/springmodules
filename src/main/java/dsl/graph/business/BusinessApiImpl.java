package dsl.graph.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessApiImpl implements BusinessApi {

	@Bean
	public Adder adder() {
		return new Adder();
	}

	@Bean
	@Override
	public Calculator calculator() {
		return new Calculator(adder());
	}

}
