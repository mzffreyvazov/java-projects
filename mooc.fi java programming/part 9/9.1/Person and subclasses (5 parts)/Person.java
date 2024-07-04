public class Person {
    private String name;
    private String location;

    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String toString() {
        return this.name + "\n" + "  " + this.location;
    }

}
