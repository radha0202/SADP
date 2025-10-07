class LoggerService {
    private static LoggerService instance;

    private LoggerService() {
        System.out.println("LoggerService instance created.");
    }

    public static LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        LoggerService logger1 = LoggerService.getInstance();
        logger1.log("This is the first log message.");

        LoggerService logger2 = LoggerService.getInstance();
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both loggers are the same instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
	

