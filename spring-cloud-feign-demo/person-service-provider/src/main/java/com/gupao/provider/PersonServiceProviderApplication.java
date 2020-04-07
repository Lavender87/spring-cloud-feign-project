package com.gupao.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * {@PersonService} 提供者应用
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableTransactionManagement(proxyTargetClass = true)
public class PersonServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class,args);
    }

}
