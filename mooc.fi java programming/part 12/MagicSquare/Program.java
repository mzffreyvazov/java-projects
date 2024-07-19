
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(5));

        // MagicSquare square = new MagicSquare(5);
        // System.out.println(square.sumsOfDiagonals());
    }
}
