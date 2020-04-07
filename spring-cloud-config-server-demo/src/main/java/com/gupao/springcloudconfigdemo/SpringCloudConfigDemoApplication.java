package com.gupao.springcloudconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConfigDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigDemoApplication.class, args);
	}

}
