import org.junit.Test;

import javax.management.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentTest {
    Student s1;
    Student s4;
    Student s2;
    Student s3;

    @Test
    public void studentTest() throws InvalidAttributeValueException {
        s1 = new Student("12345678A", "Pedro");
        s4 = new Student("12345678A", "Pedro");
        s2 = new Student("12345678B", "Luis");
        s3 = new Student("12345678C", "Jose");

        assertTrue(s1.equals(s4));
        assertFalse(s1 == s4);
        assertFalse(s2.equals(s3));
    }

    @Test
    public void mapTest() throws InvalidAttributeValueException {
        studentTest();

        Map<Student, Integer> calificaciones = new HashMap<>();

        Integer c_s1 = calificaciones.put(s1, 10);
        assertNull(c_s1);
        Integer c_s2 = calificaciones.put(s2, 7);
        assertNull(c_s2);
        Integer c_s3 = calificaciones.put(s3, 5);
        assertNull(c_s3);
        int c_s4 = calificaciones.put(s4, 2);
        assertEquals(c_s4, 10);
        
    }
}
