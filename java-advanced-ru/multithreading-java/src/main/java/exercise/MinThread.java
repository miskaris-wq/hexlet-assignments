package exercise;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int min;
    @Override
    public void run() {
        min = numbers[0];
        for (var num: numbers) {
            if (num < min) {
                min = num;
            }
        }
    }

    public int getMin() {
        return min;
    }

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }
}
// END
