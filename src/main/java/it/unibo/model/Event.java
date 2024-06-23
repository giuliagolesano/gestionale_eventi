package it.unibo.model;

import java.util.Date;

/**
 * Class about a EVENT
 */
public class Event {
    private Date date;
    private String theme;
    
    /**
     * Costructor.
     * @param date
     * @param theme
     */
    public Event(Date date, String theme) {
        this.date = date;
        this.theme = theme;
    }

    /**
     * Get the date.
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get the theme.
     * @return
     */
    public String getTheme() {
        return theme;
    } 
}
