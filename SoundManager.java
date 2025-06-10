import greenfoot.*;

public class SoundManager {
    private static GreenfootSound bgm = new GreenfootSound("bgm.mp3");

    public static void playBGM() {
        bgm.setVolume(100);
        if (!bgm.isPlaying()) {
            bgm.playLoop();
        }
    }

    public static void stopBGM() {
        if (bgm.isPlaying()) {
            bgm.stop();
        }
    }

    public static void pauseBGM() {
        if (bgm.isPlaying()) {
            bgm.pause();
        }
    }
}
