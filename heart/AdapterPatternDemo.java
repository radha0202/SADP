// Target interface (what client expects)
interface BeatModel {
    void initialize();
    void on();
    void off();
    int getBeatPerMinute();
}

// Adaptee class (existing class with different interface)
class HeartModel {
    public void startHeart() {
        System.out.println("Heart started beating...");
    }

    public void stopHeart() {
        System.out.println("Heart stopped.");
    }

    public int getHeartRate() {
        // Just simulating heart rate with random value
        return 60 + (int)(Math.random() * 40); // 60 - 100 bpm
    }
}

// Adapter class (makes HeartModel compatible with BeatModel)
class HeartAdapter implements BeatModel {
    private HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing Heart Adapter...");
    }

    @Override
    public void on() {
        heartModel.startHeart();
    }

    @Override
    public void off() {
        heartModel.stopHeart();
    }

    @Override
    public int getBeatPerMinute() {
        return heartModel.getHeartRate();
    }
}

// Client code
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Existing heart model
        HeartModel heart = new HeartModel();

        // Use adapter to treat HeartModel like BeatModel
        BeatModel beatModel = new HeartAdapter(heart);

        beatModel.initialize();
        beatModel.on();
        System.out.println("Current BPM: " + beatModel.getBeatPerMinute());
        beatModel.off();
    }
}
