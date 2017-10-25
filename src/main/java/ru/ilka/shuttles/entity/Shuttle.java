package ru.ilka.shuttles.entity;

public class Shuttle {

    private int shuttleId;
    private int capacity;
    private ShuttleClass shuttleConvenientClass;

    public Shuttle() {
    }

    public Shuttle(Shuttle shuttle) {
        this.shuttleId = shuttle.shuttleId;
        this.capacity = shuttle.capacity;
        this.shuttleConvenientClass = shuttle.shuttleConvenientClass;
    }

    public Shuttle(int shuttleId, int capacity, ShuttleClass shuttleConvenientClass) {
        this.shuttleId = shuttleId;
        this.capacity = capacity;
        this.shuttleConvenientClass = shuttleConvenientClass;
    }

    public int getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(int shuttleId) {
        this.shuttleId = shuttleId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ShuttleClass getShuttleConvenientClass() {
        return shuttleConvenientClass;
    }

    public void setShuttleConvenientClass(ShuttleClass shuttleConvenientClass) {
        this.shuttleConvenientClass = shuttleConvenientClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shuttle shuttle = (Shuttle) o;

        if (shuttleId != shuttle.shuttleId) return false;
        if (capacity != shuttle.capacity) return false;
        return shuttleConvenientClass == shuttle.shuttleConvenientClass;
    }

    @Override
    public int hashCode() {
        int result = shuttleId;
        result = 31 * result + capacity;
        result = 31 * result + shuttleConvenientClass.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Shuttle{" +
                "shuttleId=" + shuttleId +
                ", capacity=" + capacity +
                ", shuttleConvenientClass=" + shuttleConvenientClass +
                '}';
    }
}
