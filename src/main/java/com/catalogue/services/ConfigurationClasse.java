package com.catalogue.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class ConfigurationClasse {

@Bean
public SimpleJaxWsServiceExporter getExporter(){
SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
serviceExporter.setBaseAddress("http://localhost:9090/produits");
return serviceExporter;
    }
}
