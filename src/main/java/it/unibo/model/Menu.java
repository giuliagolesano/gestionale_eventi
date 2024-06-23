package it.unibo.model;

/**
 * Class about a MENU.
 */
public class Menu {
    private int id;
    private int total;

    /**
     * Constructor.
     * @param id
     * @param total
     */
    public Menu(int id, int total) {
        this.id = id;
        this.total = total;
    }

    /**
     * Get the id.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get the total number of drinks in the menu.
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     * Set the total number of drinks in the menu.
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
