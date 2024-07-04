public class Teacher extends Person {

    private int salary;

    public Teacher(String name, String location, int salary) {
        super(name, location);
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + "\n" + "  salary " + this.salary + " euro/month";
    }
    
}
