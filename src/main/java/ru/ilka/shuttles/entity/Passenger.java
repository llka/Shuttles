package ru.ilka.shuttles.entity;


public class Passenger {

    private int passengerId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private boolean ban;

    public Passenger() {
    }

    public Passenger(int passengerId, String firstName, String lastName, String login, String password, boolean ban) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.ban = ban;
    }

    public Passenger(Passenger passenger) {
        this.passengerId = passenger.passengerId;
        this.firstName = passenger.firstName;
        this.lastName = passenger.lastName;
        this.login = passenger.login;
        this.password = passenger.password;
        this.ban = passenger.ban;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean isBanned) {
        this.ban = isBanned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (passengerId != passenger.passengerId) return false;
        if (!firstName.equals(passenger.firstName)) return false;
        if (!lastName.equals(passenger.lastName)) return false;
        if (!login.equals(passenger.login)) return false;
        return password.equals(passenger.password);
    }

    @Override
    public int hashCode() {
        int result = passengerId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
