import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Zone<T extends Comparable<T>> {
    List<T> elements;  // List to hold elements in this zone
    T min;             // Minimum element in the zone
    T max;             // Maximum element in the zone
    int size;          // Number of elements in the current zone

    public Zone() {
        elements = new ArrayList<>();
        size = 0;
    }
}

class ZoneMap<T extends Comparable<T>> {
    List<T> elements;               // List to hold all elements
    List<Zone<T>> zones;            // List of zones
    int numZones;                   // Number of zones
    int numElementsPerZone;         // Number of elements per zone

    public ZoneMap(List<T> _elements, int _numElementsPerZone) {

        // constructor
        // your code starts here ...

    }

    public void build() {
        
        // your code start here ...

    }

    private void sortElements() {

        // your code start here ...

    }

    public int query(T key) {
        
        // your code start here ...

        return 0;
    }

    public List<T> query(T low, T high) {
        
        // your code start here ...

        return new ArrayList<T>();
    }
}
