public class Student extends Person {

    private int credits;

    public Student(String name, String location) {
        super(name, location);
        this.credits = 0;
    }

    public void study() {
        this.credits++;
    }

    public int credits() {
        return this.credits;
    }
    
    public String toString() {
        return super.toString() + "\n" + "  " + "Study credits "+ this.credits();
    }
}
