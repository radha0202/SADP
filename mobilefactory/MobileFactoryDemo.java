// Product Interfaces
interface Camera {
    void takePhoto();
}

interface VideoRecorder {
    void recordVideo();
}

// Concrete Products for Samsung
class SamsungCamera implements Camera {
    public void takePhoto() {
        System.out.println("Samsung: Photo taken with 108MP camera.");
    }
}

class SamsungVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("Samsung: Recording video in 8K resolution.");
    }
}

// Concrete Products for iPhone
class IPhoneCamera implements Camera {
    public void takePhoto() {
        System.out.println("iPhone: Photo taken with advanced AI optimization.");
    }
}

class IPhoneVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("iPhone: Recording cinematic 4K video.");
    }
}

// Abstract Factory Interface
interface MobileFactory {
    Camera createCamera();
    VideoRecorder createVideoRecorder();
}

// Concrete Factory for Samsung
class SamsungFactory implements MobileFactory {
    public Camera createCamera() {
        return new SamsungCamera();
    }
    public VideoRecorder createVideoRecorder() {
        return new SamsungVideoRecorder();
    }
}

// Concrete Factory for iPhone
class IPhoneFactory implements MobileFactory {
    public Camera createCamera() {
        return new IPhoneCamera();
    }
    public VideoRecorder createVideoRecorder() {
        return new IPhoneVideoRecorder();
    }
}

// Client Code
public class MobileFactoryDemo {
    public static void main(String[] args) {
        // Change the factory here to test different brands
        MobileFactory factory;

        System.out.println("Using Samsung Phone:");
        factory = new SamsungFactory();
        Camera samsungCam = factory.createCamera();
        VideoRecorder samsungVid = factory.createVideoRecorder();
        samsungCam.takePhoto();
        samsungVid.recordVideo();

        System.out.println("\nUsing iPhone:");
        factory = new IPhoneFactory();
        Camera iphoneCam = factory.createCamera();
        VideoRecorder iphoneVid = factory.createVideoRecorder();
        iphoneCam.takePhoto();
        iphoneVid.recordVideo();
    }
}

