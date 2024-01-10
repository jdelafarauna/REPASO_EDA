package comparadores;

import java.util.Objects;

/**
 *
 * @author mayte
 */
public class Person implements Comparable{
    private String name;

    private String lastName;
    private String dni;
    

    public Person(String name, String lastName, String dni) {
        throw new RuntimeException("Not implemented.");
    }

    @Override
    public int compareTo(Object o) {
        throw new RuntimeException("Not implemented.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString(){
        return this.name + this.lastName + this.dni;
    }
}
