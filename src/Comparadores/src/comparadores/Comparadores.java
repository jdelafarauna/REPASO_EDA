package comparadores;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mayte
 */
public class Comparadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Person p1 = new Person("Jose","Velez","01234567R");
       Person p2 = new Person("Mayte", "Gonzalez", "13427927D");
       Person p3 = new Person("Alberto", "Aranda","54678122F");
       Person p4 = new Person("Amanda","Valencia", "39876542Y");
       List<Person> l = new LinkedList();
       l.add(p1);
       l.add(p2);
       l.add(p3);
       l.add(p4);

       System.out.println("Default order");
       for (Person p: l){
           System.out.println(p);
       }

        System.out.println("Sorted by name");
        Collections.sort(l);
       for (Person p: l){
           System.out.println(p);
       }

        System.out.println("Sorted by last name");
        LastNameComparator c = new LastNameComparator();
       Collections.sort(l, c);
       for (Person p: l){
           System.out.println(p);
       }
    }
    
}
