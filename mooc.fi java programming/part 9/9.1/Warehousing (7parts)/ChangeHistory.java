import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status); 
    }

    public void clear() {
        this.history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        return Collections.max(this.history);
    }

    public double minValue() {
        return Collections.min(this.history);
    }

    public double average() {
        if (this.history.isEmpty()) {
            return 0.0; // or handle the empty case as needed
        }
        double sum = 0.0;
        for (double value : this.history) {
            sum += value;
        }
        return sum / this.history.size();
    }
}
