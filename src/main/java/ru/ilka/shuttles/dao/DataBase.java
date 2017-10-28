package ru.ilka.shuttles.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ilka.shuttles.entity.Passenger;
import ru.ilka.shuttles.entity.Shuttle;
import ru.ilka.shuttles.entity.ShuttleClass;
import ru.ilka.shuttles.exception.DataBaseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Here could be your advertisement +375 29 3880490
 */
public class DataBase {
    static Logger logger = LoggerFactory.getLogger(DataBase.class);

    private static AtomicBoolean dbInstanceCreated = new AtomicBoolean(false);
    private static AtomicBoolean dbClosed = new AtomicBoolean(false);
    private static Lock connectionPoolLock = new ReentrantLock(true);
    private static Lock closePoolLock = new ReentrantLock(true);
    private static DataBase dataBaseInstance;
    private static int POOL_SIZE = 5;

    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> takenConnections;

    private static ArrayList<Shuttle> shuttles;
    private static ArrayList<Passenger> passengers;
    private static HashMap<Shuttle, Passenger> shuttles_has_passengers;
    private static final int INIT_SHUTTLES_SIZE = 5;
    private static final int DEFAULT_SHUTTLE_CAPACITY = 7;

    private DataBase() {
        freeConnections = new ArrayBlockingQueue<>(POOL_SIZE);
        takenConnections = new ArrayBlockingQueue<>(POOL_SIZE);
        initializeData();

        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                freeConnections.put(new ProxyConnection());
            } catch (InterruptedException e) {
                logger.error("Can not get connection " + e);
            }
        }
    }

    private void initializeData() {
        shuttles = new ArrayList<>(INIT_SHUTTLES_SIZE);
        passengers = new ArrayList<>();
        shuttles_has_passengers = new HashMap<>();

        for (int i = 0; i < INIT_SHUTTLES_SIZE; i++) {
            Shuttle shuttle = new Shuttle(i, DEFAULT_SHUTTLE_CAPACITY + INIT_SHUTTLES_SIZE * i, ShuttleClass.BUSINESS);
            shuttles.add(shuttle);
        }
    }

    public static DataBase getInstance() {
        if (!dbInstanceCreated.get()) {
            connectionPoolLock.lock();
            try {
                if (dataBaseInstance == null) {
                    dataBaseInstance = new DataBase();
                    dbInstanceCreated.set(true);
                }
            } finally {
                connectionPoolLock.unlock();
            }
        }
        return dataBaseInstance;
    }


    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        if (!dbClosed.get()) {
            try {
                connection = freeConnections.take();
                takenConnections.put(connection);
            } catch (InterruptedException e) {
                logger.error("Can't take connection from available connections." + e);
            }
        }
        return connection;
    }

    public void freeConnection(ProxyConnection connection) {
        if (!dbClosed.get()) {
            takenConnections.remove(connection);
            try {
                freeConnections.put(connection);
            } catch (InterruptedException e) {
                logger.error("Can't free connection " + e);
            }
        }
    }

    public void closeDB() {
        if (!dbClosed.get()) {
            closePoolLock.lock();
            try {
                dbClosed.set(true);
                takenConnections.addAll(freeConnections);
                freeConnections.clear();
            } finally {
                closePoolLock.unlock();
            }
        } else {
            logger.error("Other thread has already called closeDB()");
        }
    }

    public static ArrayList<Shuttle> getShuttles() {
        return shuttles;
    }

    public static void setShuttles(ArrayList<Shuttle> shuttles) {
        DataBase.shuttles = shuttles;
    }

    public static ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public static void setPassengers(ArrayList<Passenger> passengers) {
        DataBase.passengers = passengers;
    }

    public static HashMap<Shuttle, Passenger> getShuttles_has_passengers() {
        return shuttles_has_passengers;
    }

    public static void setShuttles_has_passengers(HashMap<Shuttle, Passenger> shuttles_has_passengers) {
        DataBase.shuttles_has_passengers = shuttles_has_passengers;
    }

    class ProxyConnection{
        public Shuttle findShuttleById(int id) throws DataBaseException {
            for (int i = 0; i < shuttles.size(); i++) {
                Shuttle shuttle = shuttles.get(i);
                if(shuttle.getShuttleId() == id){
                    return shuttle;
                }
            }
            throw new DataBaseException();
        }

        public List<Shuttle> findAllShuttles(){
            return shuttles;
        }

        public void saveShuttle(Shuttle shuttle){
            shuttles.add(shuttle);
        }

        public void deleteShuttle(Shuttle shuttle){
            shuttles.remove(shuttle);
        }

        public void updateShuttle(Shuttle updatedShuttle) throws DataBaseException {
            Shuttle oldShuttle = findShuttleById(updatedShuttle.getShuttleId());
            deleteShuttle(oldShuttle);
            saveShuttle(updatedShuttle);
        }
    }
}
