package ru.ilka.shuttles.util;

import ru.ilka.shuttles.service.ShuttleService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class JaxRsConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes = super.getClasses();
        classes.add(ShuttleService.class);
        return classes;
    }
}
