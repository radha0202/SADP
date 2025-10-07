interface Camera {
    void takePhoto();
}

interface VideoRecorder {
    void recordVideo();
}

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

interface MobileFactory {
    Camera createCamera();
    VideoRecorder createVideoRecorder();
}

class SamsungFactory implements MobileFactory {
    public Camera createCamera() {
        return new SamsungCamera();
    }
    public VideoRecorder createVideoRecorder() {
        return new SamsungVideoRecorder();
    }
}

class IPhoneFactory implements MobileFactory {
    public Camera createCamera() {
        return new IPhoneCamera();
    }
    public VideoRecorder createVideoRecorder() {
        return new IPhoneVideoRecorder();
    }
}

public class MobileFactoryDemo {
    public static void main(String[] args) {
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

