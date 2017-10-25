package ru.ilka.shuttles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ilka.shuttles.dao.PassengerDao;
import ru.ilka.shuttles.dao.ShuttleDao;
import ru.ilka.shuttles.logic.PassengerLogic;
import ru.ilka.shuttles.logic.ShuttleLogic;

@Configuration
public class TestConfig {
    @Bean
    ShuttleLogic shuttleLogic() {
        return new ShuttleLogic();
    }

    @Bean
    PassengerLogic passengerLogic() {
        return new PassengerLogic();
    }

    @Bean
    ShuttleDao shuttleDao() {
        return new ShuttleDao();
    }

    @Bean
    PassengerDao passengerDao() {
        return new PassengerDao();
    }

}
