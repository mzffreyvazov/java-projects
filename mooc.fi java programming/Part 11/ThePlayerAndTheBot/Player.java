public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Player is playing");
    }

    public void printName() {
        System.out.println(this.name);
    }
}
