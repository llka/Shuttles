package ru.ilka.shuttles.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;

import ru.ilka.shuttles.TestConfig;
import ru.ilka.shuttles.dao.ShuttleDao;
import ru.ilka.shuttles.entity.Shuttle;
import ru.ilka.shuttles.entity.ShuttleClass;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class ShuttleLogicTest {
    //private static Logger logger = LogManager.getLogger(ShuttleLogicTest.class);
    private static Logger logger = LoggerFactory.getLogger(ShuttleLogicTest.class);

    @InjectMocks
    @Autowired
    private ShuttleLogic shuttleLogic;

    @Mock
    private ShuttleDao shuttleDao;

    private ArrayList<Shuttle> TEST_SHUTTLES;
    private static final int TEST_SHUTTLES_SIZE = 5;
    private static final int DEFAULT_SHUTTLE_CAPACITY = 7;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        TEST_SHUTTLES = new ArrayList<>(TEST_SHUTTLES_SIZE);
        for (int i = 0; i < TEST_SHUTTLES_SIZE; i++) {
            Shuttle shuttle = new Shuttle(i, DEFAULT_SHUTTLE_CAPACITY + TEST_SHUTTLES_SIZE * i, ShuttleClass.BUSINESS);
            TEST_SHUTTLES.add(shuttle);
        }
    }

    @Test
    public void shouldFindAllShuttles() {
        //given
        when(shuttleDao.loadAllShuttles()).thenReturn(TEST_SHUTTLES);

        //when
        List<Shuttle> shuttles = shuttleLogic.findAllShuttles();
        for (int i = 0; i < shuttles.size(); i++) {
            logger.info(shuttles.get(i).toString());
        }

        //then
        Assert.assertEquals(shuttles.size(), TEST_SHUTTLES_SIZE);
    }

}
