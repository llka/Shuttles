package ru.ilka.shuttles.dao;

import org.springframework.stereotype.Repository;
import ru.ilka.shuttles.entity.Shuttle;
import ru.ilka.shuttles.entity.ShuttleClass;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShuttleDao {

    private static final int TEST_SHUTTLES_SIZE = 5;
    private static final int DEFAULT_SHUTTLE_CAPACITY = 7;

    public List<Shuttle> loadAllShuttles() {
        ArrayList<Shuttle> shuttles = new ArrayList<>(TEST_SHUTTLES_SIZE);
        for (int i = 0; i < TEST_SHUTTLES_SIZE; i++) {
            Shuttle shuttle = new Shuttle(i, DEFAULT_SHUTTLE_CAPACITY + TEST_SHUTTLES_SIZE * i, ShuttleClass.BUSINESS);
            shuttles.add(shuttle);
        }
        return shuttles;
    }
}
