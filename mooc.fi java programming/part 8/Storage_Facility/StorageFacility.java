import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
       this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storage.putIfAbsent(unit, new ArrayList<>());

        ArrayList<String> items = this.storage.get(unit);
        items.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (this.storage.containsKey(storageUnit)) {
            return this.storage.get(storageUnit);
        } else {
            return new ArrayList<>();
        }
    }

    public void remove(String storageUnit, String item) {
        if (this.storage.containsKey(storageUnit)) {
            this.storage.get(storageUnit).remove(item);
        }
    }

    public ArrayList<String> storageUnits() {
        return this.storage.keySet().stream()
            .filter(key -> !this.storage.get(key).isEmpty())
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
