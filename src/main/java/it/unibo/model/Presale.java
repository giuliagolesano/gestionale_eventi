package it.unibo.model;

import java.util.Date;

/**
 * Class about a PRESALE.
 */
public class Presale {

    private int id;
    private int cost;
    private Date date;
    private String payment;

    /**
     * Costructor.
     * @param id
     * @param cost
     * @param date
     * @param payment
     */
    public Presale(final int id, final int cost, final Date date, final String payment){
        this.id = id;
        this.cost = cost;
        this.date = date;
        this.payment = payment;
    }

    /**
     * Get the id.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get the cost.
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * Get the date.
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get the payment method.
     * @return
     */
    public String getPayment() {
        return payment;
    }
    
    
}
