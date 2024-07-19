import java.util.ArrayList;

public class Pipe<T> {
    private ArrayList<T> pipes;

    public Pipe() {
        this.pipes = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.pipes.add(value);  // Add to the end of the list
    }

    public T takeFromPipe() {
        if (!this.pipes.isEmpty()) {
            return this.pipes.remove(0);  // Remove from the beginning of the list
        }
        return null;
    }

    public boolean isInPipe() {
        return !this.pipes.isEmpty();
    }
}