package com.management.risk.Mitigation;

import java.util.Date;

/**
 * The type Milstone.
 */
public class Milstone extends Task{
    /**
     * The Due date.
     */
    Date due_date;


    /**
     * Instantiates a new Milstone.
     *
     * @param due_date the due date
     */
    public Milstone(Date due_date) {
        this.due_date =due_date;
    }
}
