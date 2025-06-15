package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[0];

    public synchronized int get(int index) {
        return numbers[index];
    }

    public synchronized int getSize() {
        return numbers.length;
    }

    public synchronized void add(int num) {
        int[] newNumbers = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        newNumbers[newNumbers.length - 1] = num;
        numbers = newNumbers;
    }
    // END
}
