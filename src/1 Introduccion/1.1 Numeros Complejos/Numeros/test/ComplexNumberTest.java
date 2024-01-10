import org.junit.Test;
import static org.junit.Assert.*;
public class ComplexNumberTest {
    public ComplexNumberTest() {
    }

    @Test


    public void testRealPart(){
        ComplexNumber c =new ComplexNumber(2.3,5);
        assertEquals("Comprobando que la parte real es 2,3", 2.3, c.realPart(),0.01);
    }

    @Test
    public void testImPart(){
        ComplexNumber c =new ComplexNumber(4.2,9.1);
        assertEquals("Comprobando que la parte real es 9,1", 9.1, c.realPart(),0.01);
    }

    @Test
    public void testAdd(){
        ComplexNumber c1 =new ComplexNumber(3,4);
        ComplexNumber c2 =new ComplexNumber(2,7);
        ComplexNumber c3 = c1.add(c2);
        ComplexNumber c3Expected = new ComplexNumber(5,11);
        assertEquals (5,c3.realPart(),0.01);
        assertEquals(11,c3.imaginaryPart(),0.01);



    }

    @Test

    public void testSubstract(){
        ComplexNumber c1 = new ComplexNumber(9,5);
        ComplexNumber c2 = new ComplexNumber(4,7);
        ComplexNumber c3 = c1.subtract(c2);
        ComplexNumber c3Expected = new ComplexNumber(5,-2);
        assertEquals(5,c3.realPart(),0.01);
        assertEquals(-2,c3.imaginaryPart(),0.01);
    }
}
