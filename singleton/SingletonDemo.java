public class SingletonDemo {

    // Singleton class
    static class Singleton {
        private static volatile Singleton instance;

        // Private constructor
        private Singleton() {
            System.out.println("Singleton instance created");
        }

        // Global access point (thread-safe with double-checked locking)
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    // Main method to test the singleton in multithreaded environment
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println("Thread " + Thread.currentThread().getName() +
                               " got instance: " + singleton.hashCode());
        };

        // Start 5 threads
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
