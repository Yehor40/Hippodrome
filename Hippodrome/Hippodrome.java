import java.util.*;


public class Hippodrome {

    private final List<Horse> horses;

    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(final List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);

        }
    }

    public void move() {
        for (final Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (final Horse horse : horses) {
            horse.print();
        }
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (final Horse horse : horses) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        final Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }

    public static void main(final String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());

        game.horses.add(new Horse("Gabi", 3, 0));
        game.horses.add(new Horse("Bison", 3, 0));
        game.horses.add(new Horse("Kaiser", 3, 0));
        game.run();
        game.printWinner();
    }
}
