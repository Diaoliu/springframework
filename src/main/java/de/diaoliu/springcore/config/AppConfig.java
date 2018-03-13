package de.diaoliu.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "de.diaoliu.springcore.xmlBean.dao")
public class AppConfig {

}
