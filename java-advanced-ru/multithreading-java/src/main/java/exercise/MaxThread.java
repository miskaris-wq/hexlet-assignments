package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int max;
    @Override
    public void run() {
        max = numbers[0];
        for (var num: numbers) {
            if (num > max) {
                max = num;
            }
        }
    }

    public int getMax() {
        return max;
    }

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }
}
// END
