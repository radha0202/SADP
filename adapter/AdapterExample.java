import java.util.*;

class EnumToIterator implements Iterator<String> {
    private Enumeration<String> enumObj;

    public EnumToIterator(Enumeration<String> enumObj) {
        this.enumObj = enumObj;
    }

    public boolean hasNext() {
        return enumObj.hasMoreElements();
    }

    public String next() {
        return enumObj.nextElement();
    }

    
}

public class AdapterExample {
    public static void main(String[] args) {
        Vector<String> data = new Vector<>();
        data.add("Java");
        data.add("Adapter");
        data.add("Pattern");

        // Get Enumeration and convert to Iterator using Adapter
        Iterator<String> iterator = new EnumToIterator(data.elements());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

