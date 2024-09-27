package Tutorial3.task_thread;

class PrintLetter implements Runnable {
    private char letter;
    private int times;

    public PrintLetter(char letter, int times) {
        this.letter = letter;
        this.times = times;
    }

    @Override
    public void run() {
        System.out.println("Start thread print letter " + letter + " " + times + " times.");
        for (int i = 0; i < times; i++) {
            System.out.print(this.letter);
        }
        System.out.println("End thread print letter " + letter + " " + times + " times.");
    }
}

class PrintInteger implements Runnable {
    private int startNumber;
    private int endNumber;

    public PrintInteger(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public void run() {
        System.out.println("Start thread print integer from " + startNumber + " to " + endNumber + ".");
        if (startNumber <= endNumber) {
            for (int i = startNumber; i <= endNumber; i++) {
                System.out.print(i);
            }
        } else {
            for (int i = startNumber; i >= endNumber; i--) {
                System.out.print(i);
            }
        }
        System.out.println("End thread print integer from " + startNumber + " to " + endNumber + ".");
    }
}
public class TaskThread {
    public static void main(String[] args) {
        Thread threadPrintLetterF = new Thread(new PrintLetter('F', 50));
        Thread threadPrintLetterI = new Thread(new PrintLetter('I', 50));
        Thread threadPrintLetterT = new Thread(new PrintLetter('T', 50));
        Thread threadPrintInteger = new Thread(new PrintInteger(1, 100));

        threadPrintLetterF.start();
        threadPrintLetterI.start();
        threadPrintLetterT.start();
        threadPrintInteger.start();
    }
}
