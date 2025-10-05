// LoggerService: Singleton class
class LoggerService {
    // 1. Static instance (only one will ever be created)
    private static LoggerService instance;

    // 2. Private constructor (no one else can create it)
    private LoggerService() {
        System.out.println("LoggerService instance created.");
    }

    // 3. Public method to get the one instance
    public static LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    // 4. Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        // Get the LoggerService instance and log messages
        LoggerService logger1 = LoggerService.getInstance();
        logger1.log("This is the first log message.");

        LoggerService logger2 = LoggerService.getInstance();
        logger2.log("This is the second log message.");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both loggers are the same instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
	

