package it.unibo.model;

/**
 * Class about a TABLE.
 */
public class Table {
    private String name;
    private String password;
    private int cost;
    private int position; //,the positions are numbered
    private int participants;

    /**
     * Costructor.
     * @param name
     * @param password
     * @param cost
     * @param position
     * @param participants
     */
    public Table(final String name, final String password, final int cost, final int position, final int participants){
        this.name = name;
        this.password = password;
        this.cost = cost;
        this.position = position;
        this.participants = participants;
    }

    /**
     * Get the name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the password.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the cost.
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * Get the position.
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Get the number of participants.
     * @return
     */
    public int getParticipants() {
        return participants;
    }

    /**
     * Set the number of participants.
     * @param participants
     */
    public void setParticipants(int participants) {
        this.participants = participants;
    }
 
}
