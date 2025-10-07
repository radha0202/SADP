public class SingletonDemo {

    static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
            System.out.println("Singleton instance created");
        }

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

    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println("Thread " + Thread.currentThread().getName() +
                               " got instance: " + singleton.hashCode());
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
