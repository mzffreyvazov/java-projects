import java.util.ArrayList;

public class Hideout<T> {
    private ArrayList<T> hideout;

    public Hideout() {
        this.hideout = new ArrayList<>();
    }

    public void putIntoHideout(T toHide) {
        this.hideout.clear();
        this.hideout.add(toHide);
    }

    public T takeFromHideout() {
        if (this.hideout.isEmpty()) {
            return null;
        }
        T item = this.hideout.get(0);
        this.hideout.clear();
        return item;
    }

    public boolean isInHideout() {
        return !this.hideout.isEmpty();
    }
}
