package it.unibo.model;

import java.util.Date;

/**
 * Class about a FREE ENTRY CLIENT.
 */
public class FreeEntry extends Client {

    private String description;

    /**
     * Constructor.
     * @param id
     * @param name
     * @param surname
     * @param consent
     * @param gender
     * @param birth
     * @param number
     */
    public FreeEntry(int id, String name, String surname, boolean consent, String gender, Date birth, String number, final String desctiption) {
        super(id, name, surname, consent, gender, birth, number);
        this.description = desctiption;
    }

    /**
     * Get the description.
     * @return
     */
    public String getDescription() {
        return description;
    }
    
}
