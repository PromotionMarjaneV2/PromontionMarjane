package com.brief.marjane2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.brief.marjane2.entity")
@EnableJpaRepositories(basePackages = "com.brief.marjane2.repository" )
public class PromontionMarjane {




    public static void main(String[] args) {


        SpringApplication.run(PromontionMarjane.class, args);

    }

}
