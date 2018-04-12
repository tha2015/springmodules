package dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dsl.graph.business.BusinessApi;
import dsl.graph.business.BusinessApiImpl;
import dsl.graph.ui.UIApi;
import dsl.graph.ui.UIApiImpl;

@Configuration
public class ApplicationConfigImpl {

	@Bean
	public Bundle<BusinessApi> businessBundle() {
		return BundleImpl.of(BusinessApiImpl.class, BusinessApi.class);
	}

	@Bean
	public Bundle<UIApi> uiBundle() {
		return BundleImpl.of(UIApiImpl.class, UIApi.class, businessBundle());
	}
}
