package application;
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        // Return true only if all sensors are on
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (!this.isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Sensor is off or no sensors added");
        }

        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }

        int average = sum / sensors.size();
        this.readings.add(average); // Store the average reading
        return average;
    }

    public List<Integer> readings() {
        return new ArrayList<>(this.readings);
    }
}
