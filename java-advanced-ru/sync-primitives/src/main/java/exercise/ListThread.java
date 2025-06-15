package exercise;

// BEGIN
class ListThread extends Thread{
    private SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1); // Используем Thread.sleep вместо просто sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Правильная обработка прерывания
                System.err.println("Thread was interrupted");
                return;
            }
            list.add(i);
        }
    }
}
// END
