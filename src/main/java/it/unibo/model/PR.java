package it.unibo.model;

/**
 * Class about a PUBLIC RELATION EMPLOYEE.
 */
public class PR extends Employee{

    /**
     * Constructor.
     * @param id
     * @param name
     * @param surname
     * @param avaibility
     * @param type
     */
    public PR(int id, String name, String surname, boolean avaibility, String type) {
        super(id, name, surname, avaibility, type);
    }
    
}
