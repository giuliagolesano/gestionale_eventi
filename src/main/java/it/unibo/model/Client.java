package it.unibo.model;

import java.util.Date;

/**
 * Class about a CLIENT.
 */
public class Client extends User{

    private boolean consent;
    private String gender;
    private Date birth;
    private String number;

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
    public Client(final int id, final String name, final String surname, final boolean consent, final String gender, final Date birth, final String number) {
        super(id, name, surname);
        this.consent = consent;
        this.gender = gender;
        this.birth = birth;
        this.number = number;
    }

    /**
     * Get the consent.
     * @return
     */
    public boolean isConsent() {
        return consent;
    }

    /**
     * Get the gender.
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get the birth date.
     * @return
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Get the number.
     * @return
     */
    public String getNumber() {
        return number;
    }
    
}
