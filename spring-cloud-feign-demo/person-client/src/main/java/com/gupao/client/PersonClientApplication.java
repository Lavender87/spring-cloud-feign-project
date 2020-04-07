package com.gupao.client;

import com.gupao.api.service.PersonService;
import com.gupao.client.ribbon.FirstServerForeverRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Person Client 应用程序
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@EnableHystrix
//@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

//    @Bean
//    public FirstServerForeverRule firstServerForeverRule() {
//        return new FirstServerForeverRule();
//    }
}
