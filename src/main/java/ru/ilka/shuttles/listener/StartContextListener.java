package ru.ilka.shuttles.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ilka.shuttles.util.Config;
import ru.ilka.shuttles.util.ContextHolder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartContextListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(StartContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("StartContextListener - contextInitialized");
        ContextHolder contextHolder = new ContextHolder();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        contextHolder.setApplicationContext(applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
