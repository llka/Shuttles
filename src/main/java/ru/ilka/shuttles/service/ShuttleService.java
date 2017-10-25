package ru.ilka.shuttles.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.shuttles.entity.Shuttle;
import ru.ilka.shuttles.logic.ShuttleLogic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Service("shuttleService")
@Path("/shuttles")
public class ShuttleService {
    static Logger logger = LoggerFactory.getLogger(ShuttleService.class);
    private static final String MEDIA_TYPE_JSON = "application/json";

    @Autowired
    private ShuttleLogic shuttleLogic;

    @GET
    @Produces(MEDIA_TYPE_JSON)
    public List<Shuttle> getAllShuttles() {
        logger.debug("ShuttleService - getAllShuttles()");
        logger.error("Service");
        return shuttleLogic.findAllShuttles();
    }
}
