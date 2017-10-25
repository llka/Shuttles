package ru.ilka.shuttles.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.shuttles.dao.ShuttleDao;
import ru.ilka.shuttles.entity.Shuttle;

import java.util.List;

@Service("shuttleLogic")
public class ShuttleLogic {

    @Autowired
    private ShuttleDao shuttleDao;

    public List<Shuttle> findAllShuttles() {
        return shuttleDao.loadAllShuttles();
    }

}
