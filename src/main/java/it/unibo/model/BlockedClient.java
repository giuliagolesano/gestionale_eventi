package it.unibo.model;

import java.util.Date;

/**
 * Class about a BLOCKED CLIENT.
 */
public class BlockedClient extends Client{

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
    public BlockedClient(int id, String name, String surname, boolean consent, String gender, Date birth,
            String number) {
        super(id, name, surname, consent, gender, birth, number);
    }
    
}
