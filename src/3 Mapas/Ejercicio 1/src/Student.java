import javax.management.InvalidAttributeValueException;
import java.lang.reflect.Array;
import java.util.Objects;

public class Student {
    private String ID;
    private String name;
    
    private int x = 33;

    public Student(String ID, String name) throws InvalidAttributeValueException {
        if (ID.length() != 9) {
            throw new InvalidAttributeValueException("ID must be length 9");
        }
        this.ID = ID;
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        if(o == this){
            return true;
        }
        Student s = (Student) o;
        return this.name.equalsIgnoreCase(s.getName()) && this.getID() == s.getID();
    }
    @Override
    public int hashCode(){
        char [] chars = (ID + name).toCharArray();
        
        int hashCode = 0;
        
        for (int i = 0; i < chars.length; i++){
            hashCode += chars[i] * Math.pow(this.x, i);
        }
        
        return hashCode;

//        int hash_id = ID.hashCode();
//        int hash_name = name.hashCode();
//        return hash_id + hash_name;

    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}