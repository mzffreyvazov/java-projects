public class MyList<Type> {
    private Type[] values;
    private int firstIndex;

    public MyList() {
        this.values = (Type[]) new Object[10];
    }

    public void add(Type value) {
        if (this.firstIndex + 1 == this.values.length) {
            this.grow();
        }
        this.values[firstIndex] = value;
        this.firstIndex++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
    
        this.values = newValues;
    }

    public int size() {
        return this.firstIndex;
    }

    public boolean contains(Type value) {
        for (int i = 0; i < this.size(); i++) {
            if (this.values[i].equals(value) || this.values[i] == value) {
                return true;
            }
        }

        return false;
    }

    public Type get(int index) {
        if (index < 0 || index >= this.firstIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstIndex + "]");
        }
        return this.values[index];
    }

    private int indexOfValue(Type value) {
        for (int i = 0; i < this.firstIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
    
        return -1;
    }

    public void remove(Type value) {
        int indexToMove = indexOfValue(value);

        if (indexToMove < 0) {
            return; // not found
        }

        this.moveLeft(indexToMove+1);
        this.firstIndex--;
    }

    public void moveLeft(int indexToMove) {
        for (int i = indexToMove; i < this.size(); i++) {
            this.values[i-1] = this.values[i];
        }
    }
}

