package it.unibo.model;

/**
 * General user class to manage all persons represented in the db.
 */
public class User {
    private int id;
    private String name;
    private String surname;

    /**
     * Constructor.
     * @param id
     * @param name
     * @param surname
     */
    public User(final int id, final String name, final String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Get the id.
     * @return
     */
    public int getUserId() {
        return this.id;
    }

    /**
     * Get the name.
     * @return
     */
    public String getUserName() {
        return this.name;
    }

    /**
     * Get the surname.
     * @return
     */
    public String getUserSurname() {
        return this.surname;
    }

}
