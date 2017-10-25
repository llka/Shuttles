package ru.ilka.shuttles.util;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.ilka.shuttles.dao.PassengerDao;
import ru.ilka.shuttles.dao.ShuttleDao;
import ru.ilka.shuttles.entity.Shuttle;
import ru.ilka.shuttles.logic.PassengerLogic;
import ru.ilka.shuttles.logic.ShuttleLogic;
import ru.ilka.shuttles.service.ShuttleService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
@ComponentScan("ru.ilka.shuttles")
public class Config {

    @Bean(name = "shuttleLogic")
    ShuttleLogic shuttleLogic() {
        return new ShuttleLogic();
    }

    @Bean(name = "passengerLogic")
    PassengerLogic passengerLogic() {
        return new PassengerLogic();
    }

    @Bean(name = "shuttleDao")
    ShuttleDao shuttleDao() {
        return new ShuttleDao();
    }

    @Bean(name = "passengerDao")
    PassengerDao passengerDao() {
        return new PassengerDao();
    }

    @Bean(name = "shuttleService")
    ShuttleService shuttleService() {
        return new ShuttleService();
    }

//    @Autowired
//    private Bus bus;

//    @Bean
//    Server rsServer() {
//        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
//        //endpoint.setBus(bus);
//        endpoint.setAddress("/rest/");
//        // Register 2 JAX-RS root resources supporting "/sayHello/{id}" and "/sayHello2/{id}" relative paths
//        endpoint.setServiceBeans(Arrays.<Object>asList(shuttleService()));
//        endpoint.setResourceClasses(ShuttleService.class);
//        endpoint.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
//        //endpoint.setResourceProvider(ShuttleService.class, (ResourceProvider) jacksonJsonProvider());
//        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
//        return endpoint.create();
//    }


    @Bean(name = "jacksonJsonProvider")
    JacksonJsonProvider jacksonJsonProvider(){
        return new JacksonJsonProvider();
    }

}
