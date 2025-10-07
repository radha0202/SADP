
interface BeatModel {
    void initialize();
    void on();
    void off();
    int getBeatPerMinute();
}

class HeartModel {
    public void startHeart() {
        System.out.println("Heart started beating...");
    }

    public void stopHeart() {
        System.out.println("Heart stopped.");
    }

    public int getHeartRate() {

        return 60 + (int)(Math.random() * 40); 
    }
}

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

public class AdapterPatternDemo {
    public static void main(String[] args) {
        HeartModel heart = new HeartModel();

        BeatModel beatModel = new HeartAdapter(heart);

        beatModel.initialize();
        beatModel.on();
        System.out.println("Current BPM: " + beatModel.getBeatPerMinute());
        beatModel.off();
    }
}
