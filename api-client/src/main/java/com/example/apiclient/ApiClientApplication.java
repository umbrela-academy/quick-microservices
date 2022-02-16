package com.example.apiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Enable for @PreAuthorize annotation processing.
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//protected static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
//	@Override
//	protected MethodSecurityExpressionHandler createExpressionHandler() {
//		return new OAuth2MethodSecurityExpressionHandler();
//	}
//}


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClientApplication.class, args);
	}

}
