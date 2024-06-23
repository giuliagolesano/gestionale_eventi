package it.unibo.model;

/**
 * Class about a LIST.
 */
public class List {
    private String name;
    private int cost;
    private int participants;

    /**
     * Constructor.
     * @param name
     * @param cost
     * @param participants
     */
    public List(final String name, final int cost, final int participants){
        this.name = name;
        this.cost = cost;
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
     * Get the cost.
     * @return
     */
    public int getCost() {
        return cost;
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
