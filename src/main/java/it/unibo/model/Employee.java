package it.unibo.model;

/**
 * Class about a EMPLOYEE
 */
public class Employee extends User{

    private boolean avaibility;
    private String type;

    /**
     * Constructor.
     * @param id
     * @param name
     * @param surname
     * @param avaibility
     * @param type
     */
    public Employee(final int id, final String name, final String surname, final boolean avaibility, final String type) {
        super(id, name, surname);
        this.avaibility = avaibility;
        this.type = type;
    }

    /**
     * Get the avaibility.
     * @return
     */
    public boolean isAvaibility() {
        return avaibility;
    }

    /**
     * Get the type.
     * @return
     */
    public String getType() {
        return type;
    }
    
}
