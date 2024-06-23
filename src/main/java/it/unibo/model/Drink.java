package it.unibo.model;

import java.util.Date;

/**
 * Class about a DRINK.
 */
public class Drink {

    private int id;
    private String name;
    private String type;
    private Date purchase;
    private Date expiry;
    private int avaibility;

    /**
     * 
     * @param id
     * @param name
     * @param type
     * @param purchase
     * @param expiry
     * @param avaibility
     */
    public Drink(int id, String name, String type, Date purchase, Date expiry, int avaibility) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.purchase = purchase;
        this.expiry = expiry;
        this.avaibility = avaibility;
    }

    /**
     * Get the id.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Get the purchase date.
     * @return
     */
    public Date getPurchase() {
        return purchase;
    }

    /**
     * Get the expiry date.
     * @return
     */
    public Date getExpiry() {
        return expiry;
    }

    /**
     * Get the avaibility.
     * @return
     */
    public int getAvaibility() {
        return avaibility;
    }

    /**
     * Set the avaibiltiy.
     * @param avaibility
     */
    public void setAvaibility(int avaibility) {
        this.avaibility = avaibility;
    }
}